package com.test.common.unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = simpleDateFormat .parse("2010-06-25");
			long timeStemp =  date.getTime();
			System.out.println(timeStemp);
			
			System.out.println(System.currentTimeMillis()>timeStemp);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
