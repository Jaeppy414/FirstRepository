package ex15usefulclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class E05Date {

	public static String myDateFormat(Calendar c, String formatStr) {
		Date date = c.getTime();
		return new SimpleDateFormat(formatStr).format(date);
	}
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		String nowStr1 = myDateFormat(calendar, "yyyy-MM-dd HH:mm:ss");
		System.out.println("현재1: "+ nowStr1);
		String nowStr2 = myDateFormat(calendar,
				"오늘은 M월의 W번째주, d번째날, F번째 E요일");
		System.out.println("현재2: "+ nowStr2);
		
		calendar.add(Calendar.DATE, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.YEAR, 1);
		String nowStr3 = myDateFormat(calendar, "yyyy년 MM월 dd일");
		System.out.println("1년2개월3일후:"+ nowStr3);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String future = "2022/12/25";
//		System.out.println(today+" "+future);
		long result = myDiffDate(today, future);
		System.out.println(today+ "에서"+ future +"까지 남은날짜:"+ result);
	}
	public static long myDiffDate(String today, String future) {
		long diffDays = 0;
		try {
			/*
			매개변수를 통해 전달된 2개의 날짜는 서로 서식이 다르다.
			today는 -를 통해 구분하고, future는 /를 통해 구분한다.
			즉 해당 날짜 서식을 명확히 지정해야만 날짜를 인식하여 파싱할 수 있다.
			 */
			Date formatToday = new SimpleDateFormat("yyyy-MM-dd").parse(today);
			Date formatFuture = new SimpleDateFormat("yyyy/MM/dd").parse(future);
			System.out.println(formatToday+" <> "+formatFuture);
			
			/*
			getTime()으로 얻어오는 시간은 총 13자리의 정수값인데 1~10까지는
			순수한 초(Sec)이고, 11~13자리는 밀리세컨즈를 의미한다.
			즉 1000으로 나눠서 뒤의 3자리를 제거하면 순수한 초가 반환된다.
			또한 하루는 60*60*24=86400초이므로 아래와 같이 남은 날짜를 구할 수 
			있다.
			 */
			diffDays = (formatFuture.getTime() - formatToday.getTime())
					/ (24*60*60*1000);
		}
		catch (Exception e) {}
		return diffDays;
	}
}
