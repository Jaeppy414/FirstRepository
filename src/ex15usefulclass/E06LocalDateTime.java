package ex15usefulclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class E06LocalDateTime {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		System.out.println("오늘날짜 : "+ localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println("현재시간 : "+ localTime);
		
		//시간과 날짜를 같이 출력한다.
		LocalDateTime monent = LocalDateTime.now();
		System.out.println("지금 : "+ monent);
		
		//날짜와 시간의 서식 적용하기 
		DateTimeFormatter format1 = 
				DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		DateTimeFormatter format2 = 
				DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		DateTimeFormatter format3 = DateTimeFormatter
				.ofPattern("오늘은 M월의 W번째주, d번째날, F번째 E요일");
		//우리가 지정한 서식대로 출력하기
		System.out.println("서식1 : "+ monent.format(format1));
		System.out.println("서식2 : "+ monent.format(format2));
		System.out.println("서식3 : "+ monent.format(format3));
		
		//특정날짜 지정하기 : LocalDate.of(년, 월, 일)
		LocalDate xMas = LocalDate.of(localDate.getYear(), 12, 25);
		System.out.println("크리스마스 : "+ xMas.format(format1));
		
		/*
		Period클래스 : 두 날짜 사이의 간격을 나타낸다.
			?개월 ?일 남음으로 표시할 수 있다.
		 */
		Period period = Period.between(localDate, xMas);
		System.out.println(period.getMonths()+"개월"
				+period.getDays()+"일 남음");
		
		/*
		ChronoUnit 클래스 : 특정 시간 단위로 차이를 구한다.
		 */
		//?개월 남음 : 남은 개월수를 표시한다.
		System.out.println(ChronoUnit.MONTHS.between(localDate, xMas)+"개월 남음");
		//?일 남음 : 남은 전체 일수를 표시한다.
		System.out.println(ChronoUnit.DAYS.between(localDate, xMas)+"일 남음");
		
		//현재를 기준으로 이전/이후 날짜를 구할 수 있다.
		System.out.println("5일 전 : "+ monent.minusDays(5));//5일전
		System.out.println("3일 후 : "+ monent.plusDays(3));//3일후
		System.out.println("2개월 후 : "+ monent.plusMonths(2));//2개월후
		System.out.println("1년 후 : "+ monent.plusYears(1));//1년후
		System.out.println("1년2개월3일 후 : "
				+ monent.plusYears(1).plusMonths(2).plusDays(3));
		//네이버 예약 지금 구매한 나라ㅉ부터 3개월 이후까지 쓸 수 있는 것들이 있는데
		// 그런 것들을 지정해놓고 그 떄까지 유효기간이 된다고 표현할 수 있음
		
	}

}
