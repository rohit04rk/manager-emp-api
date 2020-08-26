package com.example.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.uuid.Generators;

@Component
public class CustomGenerator {

	public String generateUUID() {
		UUID uuid = Generators.timeBasedGenerator().generate();
		String[] arr = uuid.toString().split("-");
		if (arr[4].isEmpty()) {
			return uuid.toString();
		}
		return arr[4];
	}

}
