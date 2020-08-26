package com.example.security;

import static com.example.security.JwtConstants.AUTHORITIES_KEY;
import static com.example.security.JwtConstants.JWT_TOKEN_VALIDITY;
import static com.example.security.JwtConstants.SIGNING_KEY;
import static com.example.security.JwtConstants.UUID;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.exception.CustomException;
import com.example.exception.ErrorCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtTokenUtil {

	public Claims getJwtClaims(String jwtToken) {
		Claims claims = null;

		try {
			claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(jwtToken).getBody();
		} catch (ExpiredJwtException e) {
			throw new CustomException("Token is Expired", e, ErrorCode.TOKEN_EXPIRE);
		} catch (SignatureException | MalformedJwtException e) {
			throw new CustomException("Invalid Token", e, ErrorCode.TOKEN_INVALID);
		} catch (Exception e) {
			throw new CustomException("Internal Error while parsing token ", e, ErrorCode.INTERNAL_SERVER_ERROR);
		}

		return claims;
	}

	public String generateToken(Authentication authentication) {

		AuthUser authUser = (AuthUser) authentication.getPrincipal();

		final String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		return Jwts.builder().claim(UUID, authUser.getManagerUuid()).claim(AUTHORITIES_KEY, authorities)
				.setSubject(authentication.getName()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, SIGNING_KEY).compact();

	}

	public boolean validateToken(Claims claims) {

		return !claims.getExpiration().before(new Date());
	}

}
