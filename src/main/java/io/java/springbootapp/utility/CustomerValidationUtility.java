package io.java.springbootapp.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidationUtility {
	
	private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	/**
	 * validate user mail
	 * @param usrEmail
	 * @return
	 */
	public static boolean isValidEmail(String usrEmail){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(usrEmail);
	    System.out.println(usrEmail +" : "+ matcher.matches());
		return matcher.matches();
	}
	
	/**
	 * validate userpassword
	 * @param userPassword
	 * @return
	 */
	public static boolean isValidPassword(String userPassword){
		
		if(userPassword.length()>=8 && userPassword.length()<=10){
			return true;
		}
		return false;
		
	}
	
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss Z yyyy");

	public static boolean isValidAge(Date dob1) {  
			System.out.print("Date--"+dob1);
		 	DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");  
		 	String strDate = dateFormat.format(dob1);  
			LocalDate dob = LocalDate.parse(strDate, dateFormatter);
			LocalDate today = LocalDate.now(ZoneId.of("Asia/Dushanbe"));
			if (dob.isAfter(today)) {
			    System.out.println("Future date not allowed");
			} else {
			    int age = (int) ChronoUnit.YEARS.between(dob, today);
			
			    if (age < 18) {
			        System.out.println(age);
			        System.out.println("Underage");
			        return false;
			    } else {
			        System.out.println(age);
			        System.out.println("18 years");
			        return true;
			    }
			}
			
			return false;
	}
	
	

}
