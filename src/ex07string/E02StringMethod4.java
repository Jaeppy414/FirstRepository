package ex07string;

public class E02StringMethod4 {

	public static void main(String[] args) {

		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		190419-3000000 => 남자
		190419-4000000 => 여자
		*/
		String juminNum = "190419-1000000";
		/*
		주민번호로 주어진 문자열의 8번째 문자 즉 인덱스7에 해당하는
		문자가 성별을 표현하므로 이를 통해 판단할 수 있다.
		이 때 문자를 비교해야 하므로'(싱글쿼테이션)을 사용해야 한다.
		 */
		if(juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3') {
			System.out.println("남자입니다.");
		}
		else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4') {
			System.out.println("여자입니다.");
		}
		else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6') {
			System.out.println("외국인입니다.");
		}
		else {
			System.out.println("주민번호를 잘못 입력했습니다.");
		}
		
		System.out.println("### 시나리오1 ###");
		String jumin = "190419-8000000";
		
		System.out.println(jumin.charAt(7));
		
		if(jumin.charAt(7) == '1' || jumin.charAt(7) == '3') {
			System.out.println("남자입니다.");
		}
		else if(jumin.charAt(7) == '2' || jumin.charAt(7) == '4') {
			System.out.println("여자입니다.");
		}
		else {
			System.out.println("사람이 아닙니다.");
		}
		
		/*
		시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()를
		이용해서 작성하시오.
		*/
		
		System.out.println("### 시나리오2 ###");
		
		String jumin1 = "190419-2000000";
		//하이픈의 인덱스를 찾은 후 1을 더해 성별에 해당하는 문자의 인덱스를 구한다.
		int index = jumin1.indexOf("-") + 1;
		if(jumin1.charAt(index)=='1' || jumin1.charAt(index)=='3') {
			System.out.println("남자");
		}
		else if(jumin1.charAt(index)=='2' || jumin1.charAt(index)=='4') {
			System.out.println("여자");
		}
		else if(jumin1.charAt(index)=='5' || jumin1.charAt(index)=='6') {
			System.out.println("외국인");
		}
		else {
			System.out.println("주민번호를 잘못 입력했습니다.");
		}
	}
}
