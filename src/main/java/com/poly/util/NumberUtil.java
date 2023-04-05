package com.poly.util;

public class NumberUtil {
public	static <T> int convertInt( T number) {
		if(Long.class.isInstance(number)) {
			return ((Long)number).intValue();
		}
		if(Double.class.isInstance(number))
			{ 
			return ((Double)number).intValue();
			}
		return (int)number;
	}
}
