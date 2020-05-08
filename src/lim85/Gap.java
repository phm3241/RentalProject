package lim85;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Gap {

	public static void main(String[] args) {
		
		
		//Date now = new Date();
		
//		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String rentalDate = sdf.format(cal.getTime());
//		System.out.println(rentalDate);
//		cal.add(Calendar.DATE,7);
//		String returnDate = sdf.format(cal.getTime());
//		System.out.println(returnDate);
		
		
//		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//		String date2 = sdf.format(cal.getTime());		// 오늘날짜
//		
//		String date1 = "2020-05-01";		// 빌린날짜
//		
//		Date FirstDate = format.parse(date1);
//        Date SecondDate = format.parse(date2);
//        
//        long calDate = FirstDate.getTime() - SecondDate.getTime();
//
//        long calDateDays = calDate / ( 24*60*60*1000); 
//
//        calDateDays = Math.abs(calDateDays);
		
		
		
		
		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String today = sdf.format(cal.getTime());
//		System.out.println(today);
//		
//		
//		
//		
//		String date1 = "2020-04-01";	// 빌린날짜
//	    String date2 = "2020-05-07";	// 오늘날짜
//	 
//	    try{ // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서 컴파일을 할 수 없다.
//	        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//	        // date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
//	        Date FirstDate = format.parse(date1);
//	        Date SecondDate = format.parse(date2);
//	        
//	        // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
//	        // 연산결과 -950400000. long type 으로 return 된다.
//	        long calDate = FirstDate.getTime() - SecondDate.getTime(); 
//	        
//	        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
//	        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
//	        long calDateDays = calDate / ( 24*60*60*1000); 
//	 
//	        calDateDays = Math.abs(calDateDays);
//	        
//	        System.out.println("두 날짜의 날짜 차이: "+calDateDays);
//	        }
//	        catch(ParseException e)
//	        {
//	            // 예외 처리
//	        }


	
		//123
		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//		String today = sdf1.format(cal.getTime());
//		System.out.println(today);		// 오늘날짜
//		System.out.println("2020-04-01");
//		
//		String strStartDate = "2020-04-01";		// 빌린날짜	"2020-04-01";	rentalDate;
//        String strEndDate = today;
//        String strFormat = "yyyy-MM-dd";    //strStartDate 와 strEndDate 의 format
//        
//        //SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
//        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
//        try{
//            Date startDate = sdf2.parse(strStartDate);	//빌린날짜
//            Date endDate = sdf2.parse(strEndDate);		//오늘날짜
// 
//            //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
//            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
//            gap = Math.abs(gap);
//            System.out.println(gap+"일");
//        }catch(ParseException e){
//            e.printStackTrace();
//        }

        
        //123

	
    	Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf1.format(cal.getTime());
		System.out.println(today);		// 오늘날짜
		System.out.println("2020-04-01");
		
		String strStartDate = "2020-04-01";		// 빌린날짜	"2020-04-01";	rentalDate;
        String strEndDate = today;
        String strFormat = "yyyy-MM-dd";    //strStartDate 와 strEndDate 의 format
        
        //SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
        try{
            Date startDate = sdf2.parse(strStartDate);	//빌린날짜
            Date endDate = sdf2.parse(strEndDate);		//오늘날짜
 
            //두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
            gap = Math.abs(gap);
            System.out.println(gap+"일");
            
            
        }catch(ParseException e){
            e.printStackTrace();
        }
        	
        	
	
	
	}
}



//===========================================================================

/*


//반납
	void itemReturn() {
		
		System.out.println("반납하고자하는 도서를 입력해주세요");
		String title = admManager.sc.nextLine();
		
		int index = admManager.loginCheckIndex();
		
		if(index<0) {	//반납실패
			System.out.println("반납하고자하는 "+ title +" 자료가 없습니다.");
		}else {
			//반납성공 		반납했는데 연체 or 정상.	
			title = rentalList.get(index).title;		// 책을 찾는다.
			
			String today = format.format(cal.getTime());
			//System.out.println(today);		// 오늘날짜
		    
			String strStartDate = this.rentalDate;	// rentalDate 로 바꿔야된다.
	        String strEndDate = today;
	        String strFormat = "yyyy-MM-dd";
	        
//	        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
	        
	        Date startDate = null;
	        Date endDate = null;
			try {
				startDate = format.parse(strStartDate);
				endDate = format.parse(strEndDate);		// today
			} catch (ParseException e) {
				e.printStackTrace();
			}	// rentalDate
         
         long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
         gap = Math.abs(gap);
         //System.out.println(gap+"일");
	        
		    
			
		    
	        
	       
	        if( gap > 7) {	 // 연체.
				
				
	        	admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
				admManager.getMember().get(admManager.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
				//numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
			
				System.out.println(title + "연체일수가 있습니다.");
				System.out.println(title + "연체일수는 " + gap + " 입니다.");
				System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
				System.out.println("처리 : " + today);	
			}else if(gap < 7) {	// 연체 없음.
				
				returnDate = today;						
					
				System.out.println(title+"자료가 정상적으로 반납되었습니다.");
				System.out.println("처리 : " + today);	
				
				admManager.getMember().get(admManager.loginCheckIndex()).numOfRent --;			// 대여권수
				admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail ++;		// 대여가능권수
				admManager.getMember().get(admManager.loginCheckIndex()).numOfExtens = 1;		// 연장가능횟수
				
			}
			
			// 대여가능으로 바꾼다.
			rentInfo = "대여가능";
			
		}	
			
	
	
	} //itemReturn끝.
	
	
*/




