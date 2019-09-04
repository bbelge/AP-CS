package library;

import java.util.Calendar;

public class Date {
	private int year;
	private int day;
	
	public Date() {
		year = 100000000;
		day = 366;
	}
	
	public void borrow() {
		year = Calendar.getInstance().get(Calendar.YEAR);
		day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}
	
	public int getYear() {
		return year;
	}
	
	public int getDay() {
		return day;
	}
	
}
