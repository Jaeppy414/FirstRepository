package ex08class;

/*
추상화(abstraction) : 현실세계의 사물을 클래스로 형상화 하는 것을
	말한다. Person클래스는 "사람"의 일반적인 사항을 클래스로 추상화
	하고있다.
 */
/*
클래스 선언시 class키워드를 사용한다. 클래스명의 첫글자는 반드시
대문자로 해야한다. 또한 public이라는 접근지정자는 하나의 java파일에
한번만 사용할 수 있다.
 */


public class E01PersonMain {

	public static void main(String[] args) {
		
		/*
		Person클래스를 통해 객체(인스턴스)를 생성한다. 생성시 할당된
		주소값을 반환하고, 좌측항의 참조변수가 그 값을 할당받게 된다.
		 */
		Person person = new Person();
			
			//객체의 참조변수를 통해 멤버메서드를 호출할 수 있다.
			person.eat();
			person.sleep();
			
			//객체 생성직후 참조변수를 저장하지 않고도 멤버메서드를 호출할 수 있다.
			new Person().eat();
			new Person().sleep();
		
	}

}
