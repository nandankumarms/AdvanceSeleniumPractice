package practiceDataDrivenTesting;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CaptureCurrentSystemDate {
	public static void main(String[] args) {
		
		//To get entire calendar
		Calendar calendar=Calendar.getInstance();// Stores currrent date
		
		//Formate date to 2023-10-9 format
		SimpleDateFormat formatedDate=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=formatedDate.format(calendar.getTime());
		System.out.println(currentDate);
		
		//To get the date after next 30 days
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		
		String requiredDate=formatedDate.format(calendar.getTime());
		
		//formatedDate.format(calendar);
		System.out.println(requiredDate); 
	}

}
