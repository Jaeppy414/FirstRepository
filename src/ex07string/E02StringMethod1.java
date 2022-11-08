package ex07string;

public class E02StringMethod1 {

	public static void main(String[] args) {

		System.out.println("String 클래스의 주요 메소드1");
		System.out.println("---------------------------");
		
		String str1 = "Welcome to java";
		String str2 = "자바야 놀자!";
		
		/*
		1] length() : 문자열의 길이를 반환한다. 비밀번호나 아이디 길이를 제한할 때 쓰면 되겠네!
		 */
		System.out.println("### 1 ###");
		System.out.println("str1의 길이:"+ str1.length());
		System.out.println("str2의 길이:"+ str2.length());
		System.out.println("---------------------------");
		/*
		2] charAt(인덱스) : 문자열에서 특정 index에 해당하는 문자
				하나를 반환한다. index는 배열과 같이 0부터 시작한다.
		 */
		System.out.println("### 2 ###");
		System.out.println("str1의 두번째 문자:"+ str1.charAt(1)); // 0 : W 1 : e
		System.out.println("str2의 두번째 문자:"+ str2.charAt(1)); // 0 :자 1 : 바
		System.out.println("---------------------------");
		/*
		3] compareTo() : 2개의 문자열의 첫번째 문자부터 순차적으로
				비교하면서 앞문자의 아스키코드가 크면 양수를 반환하고
				뒷 문자의 아스키코드가 크면 음수를 반환한다.
				두 문자열이 같을 때 0을 반환한다. 0이 반환될 때 로그인하게 되면 되겠네!
		 */
		System.out.println("### 3 ###");
		//A라는 문자를 더블쿼테이션으로 감쌋으므로 문자열로 선언된다.
		String str3 = "A";
		String str4 = "B";
		System.out.println(str3.compareTo(str4));
		System.out.println(str4.compareTo(str3));
		System.out.println("ABC".compareTo("ABC")==0 ? "문자열이같다" : "문자열이 다르다");
		System.out.println("---------------------------");
		/*
		4]concat() : 두개의 문자열을 연결할 때 사용한다. print()문에서
				+와 동일한 역할을 한다. 대부분 +연산자를 사용한대!
		 */
		System.out.println("### 4 ###");
		System.out.println("JAVA".concat("WORLD").concat("Go"));
		System.out.println("JAVA"+"WORLD"+"GO");
		System.out.println("---------------------------");
		/*
		5] contains() :문자열에 특정 문자열이 포함되어 있는지를
				판단하여 포함되었다면 true를 반환한다. 비번에 특수문자가 있는 지 확인할 수 있겠네!
		 */
		System.out.println("### 5 ###");
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
	}

}

























