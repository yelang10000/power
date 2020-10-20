package com.sun.power.core.utils;

import org.apache.log4j.Logger;

public class TypeChange
{

	private static Logger log = Logger.getLogger(TypeChange.class);

	public static Integer stringToInteger(String str, int defaultValue)
	{

		Integer result = defaultValue;
		try
		{
			result = Integer.valueOf(str);
		} catch (Exception e)
		{
			log.error(String.format("stringToInteger %s error", str));
		}
		return result;
	}
}
