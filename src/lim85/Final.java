package lim85;

public class Final {

	public static void main(String[] args) {

		String rentalTitle = "해리포터";
		
		
		
		
		void extention() {
			System.out.println("연장하고자하는 (책)을 입력해주세요.");
			String title = kb.nextLine();
			
			int index = serchIndex(title);
			
			if(index<0) {	 //연장 실패
				System.out.println("연장하고자하는 이름의 (책)가 없습니다.");
			}else {	//연장 성공
				String rentalTilte = rental.get(index).title; //책을 찾는다.
			
				returnDate = cal.add(Calendar.DATE, 7);		//7일 연장
				
				rentInfo = "대여중"		// 대여상태 대여중으로 바꾼다.
				
				System.out.println(rentalTitle + " 7일 연장되었습니다.");
				System.out.println(returnDate + " 까지 반납하세요.");
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
