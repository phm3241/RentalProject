package phm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test2 {

	public static void main(String[] args) {
		// 날짜포멧
		SimpleDateFormat format= new SimpleDateFormat ("yyyy/ MM/ dd");
		// 시간 더하기
		Calendar cal = Calendar.getInstance();
		
		
		// 대여일 : 현재시간
		String rentalDate=format.format(cal.getTime());
		
		System.out.println(rentalDate);
		
		// 반납일 : 대여일+7일
		String returnDate=cal.add(Calendar.DATE,7);
		String returnDate=format.format(cal.getTime());

//		cal.add(Calendar.DATE,7);
//		String returnDate=format.format(cal.getTime());
		
		System.out.println(returnDate);

		
		// 연장기간 : 대여일 +14일
		cal.add(Calendar.DATE,7);
		String dateOfExtens=format.format(cal.getTime());;	// 연장기간#

		System.out.println(dateOfExtens);

		String overdue;			// 연체일#
	}

}
