/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package de.acegen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class StringToDateTimeConverter extends StdConverter<String, LocalDateTime> {
	@Override
	public LocalDateTime convert(String value) {
		return LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
	}
}



/******* S.D.G. *******/



