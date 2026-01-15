package com.eatp.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.eatp.common.enums.DateFormat;

public class DateUtils {

	public static String covertToString(LocalDate localDate, DateFormat dateFormat) {
		return localDate.format(dateFormat.getFormatter());
	}
	
	public static String covertToString(LocalDateTime localDateTime, DateFormat dateFormat) {
		return localDateTime.format(dateFormat.getFormatter());
	}
	
	public static String getNowAsString(boolean isTimestamp) {
		return isTimestamp? covertToString(LocalDateTime.now(), DateFormat.ISO_DATE_TIME)
				: covertToString(LocalDate.now(), DateFormat.ISO_DATE_TIME);
	}
}
