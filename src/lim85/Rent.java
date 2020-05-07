package lim85;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


		
//		String today() {
//			
//			Calendar cal = Calendar.getInstance();
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//			String today = sdf1.format(cal.getTime());
//			
//			
//			return today;
//		}
		public class Rent
		{
			public static void main(String[] args) throws Exception
			  {
//			    System.out.println(diffOfDate("20031028", "20031102"));
//			  }
//
//			 
//
//			  public static long diffOfDate(String begin, String end) throws Exception
//			  {
//			    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//
//			 
//
//			    Date beginDate = formatter.parse(begin);
//			    Date endDate = formatter.parse(end);
//
//			 
//
//			    long diff = endDate.getTime() - beginDate.getTime();
//			    long diffDays = diff / (24 * 60 * 60 * 1000);
//
//			    long gap = (beginDate.getTime() - endDate.getTime()) / (24*60*60*1000);
//			    gap = Math.abs(gap);
//		        System.out.println(gap+"일");
//			    
//			    
//
//			    return diffDays;
			    
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf1.format(cal.getTime());
				System.out.println(today);		// 오늘날짜
			    
//				String strStartDate = "2020-04-01";	// rentalDate 로 바꿔야된다.
//		        String strEndDate = today;
//		        String strFormat = "yyyy-MM-dd";
//		        
//		        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
//		        
//		        Date startDate = sdf2.parse(strStartDate);	// rentalDate
//	            Date endDate = sdf2.parse(strEndDate);		// today
//	            
//	            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
//	            gap = Math.abs(gap);
//	            System.out.println(gap+"일");
	            
				 
			     SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			     cal.add(Calendar.DATE, 7);
			     System.out.println("after: " + sdf2.format(cal.getTime()));
				
				
				
			    
			    
			  }
		}

//		 long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
//         gap = Math.abs(gap);
//         System.out.println(gap+"일");
