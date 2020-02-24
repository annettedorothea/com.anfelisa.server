package com.anfelisa.box.utils;

import java.util.Arrays;

public class LanguageValidator {

	private final static String[] languages = new String[] { "de", "fr", "en" };

	public static boolean isLanguageValid(String language) {
		if (language != null && !Arrays.asList(languages).contains(language)) {
			return false;
		}
		return true;
	}
}
