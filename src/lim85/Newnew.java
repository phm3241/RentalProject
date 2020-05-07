package lim85;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Newnew {

	public static void main(String[] args) {
		
		
		//Date now = new Date();
		
		
		Calendar cal = Calendar.getInstance();
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/ MM/ dd");
		
		String rentalDate = sdf.format(cal.getTime());
		
		System.out.println(rentalDate);
	
		cal.add(Calendar.DATE,7);
		
		String returnDate = sdf.format(cal.getTime());
		System.out.println(returnDate);
		
		
	}
}
