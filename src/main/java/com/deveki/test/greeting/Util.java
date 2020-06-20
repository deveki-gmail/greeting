package com.deveki.test.greeting;

public class Util {
	
	public static boolean isValidName(String name){
		return name.matches("^[a-zA-Z]*$");
	}
	
}
