package ex18lambda;

/*
람다식으로 구현하기
	: 객체지향 프로그래밍에서는 메서드를 선언하기 위해 반드시 클래스를
	정의해야 한다. 이러한 불편함 때문에 최근 함수형 프로그래밍(Functional
	Programming)의 장점이 대두되었고, 이런 Java문법의 단점을 보완하기
	위해 JDK1.8부터 람다식을 지원하게 되었다.
 */

//람다식 정의를 위한 인터페이스 정의
@FunctionalInterface
interface Ischool3{
	void studyLambda(String str); //추상메서드
}

public class Ex03Lambda {

	public static void main(String[] args) {
		
		/*
		2번 예제의 익명클래스를 다음과 같은 람다식으로 표현할 수 있다.
		1. 함수명을 제거한다. 어차피 부모 인터페이스로부터 오버라이딩
		했으므로 동일한 이름인것을 우리는 알고 있다.
		2. 람다식임을 표현하기 위해 소괄호와 중관호 사이에 화살표를 삽입한다.
		좌측의 부모참조변수가 우측의 자식영역을 참조한다는 개념으로 이해하면 된다.
		 */
		Ischool3 sch1 = (String str) -> {
			System.out.println(str+"을 드디어 써보네요..!!");
		};
		//추상메서드의 이름을 통해 람다식을 호출한다.
		sch1.studyLambda("람다식");
		
		/*
		앞의 람다식을 한번 더 줄리면 다음과 같이 표현할 수 있다.
		Ischool3 인터페이스의 추상메서드를 통해 매개변수의 타입을
		유추할 수 있으므로 String을 제거할 수 있다. 실행문이 하나인 경우
		중괄호도 생략할 수 있다.
		 */
		Ischool3 sch2 = str -> System.out.println(str +" 완전 간단..!!");
		sch2.studyLambda("람다식");
	}
}
