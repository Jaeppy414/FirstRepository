package ex12inheritance;
/*
class A{}
class B extends A {}

==> 이 경우 클래스 A,B에는 생성자를 정의하지 않았으므로 디폴트
	생성자가 컴파일러에 의해 추가된다. 따라서 위 코드는 정상적으로
	실행되고 객체 또한 문제없이 생성할 수 있다.
	아래는 위의 코드를 컴파일 했을 때의 모습이다.

class A{
	public A( ) {} <- 디폴트생성자
}
class B extends A {
	public B( ) {
		super(); <- 디폴트생성자 및 부모클래스의 생성자를
					호출하는 super()
	} 
}
=============================================================================
class C{
	public C(int X) {} <- 개발자가 직접 정의한 인수생성자
}
class D extends C {
	public D(int Y) {
		super(Y); <- 부모의 인자생성자를 호출하는 super()는 반드시
	 			기술해야 한다. 개발자가 직접 생성자를 정의하게되면
	 			디폴트 생성자는 추가되지 않으므로 super(Y)와 같이
	 			반드시 부모의 인자생성자를 호출하는 문장을 삽입해야 한다.
	} 
}
*/

class Account{
	/*
	멤버변수가 상속관계에 있다하더라도 private으로 선언되면
	클래스 내부에서만 접근할 수 있다. 즉 상속받은 하위클래스에서는
	직접 접근이 불가능하다.
	 */
	private int money;
	
	/*
	이와 같이 개발자가 생성자를 직접 정의하면 디폴트 생성자는 추가되지
	않는다. 디폴트 생성자는 개발자가 생성자를 정의하지 않았을 때만
	컴파일러에 의해 자동으로 추가된다.
	 */
	public Account(int init) {
		money = init;
	}
	//입금처리: protected로 선언되었으므로 상속관계에서 접근가능함.
	protected void depositMoney(int _money) {
		
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가합니다.");
			return;
		}
		//멤버변수에 매개변수로 전달된 금액을 더한다.
		money += _money;
	}
	//private멤버변수 값을 외부로 반환할 때 사용한다. (getter 메서드)
	protected int getAccMoney() {
		return money;
	}
}
//부모클래스인 Account를 상속받아 정의한 자식클래스
class SavingAccount extends Account {
	/*
	인자생성자에서 부모의 생성자를 호출하기 위한 super(XXX)를 사용한다.
	이 때 인자가 하나인 부모클래스의 생성자가 호출된다.
	현재 부모클래스에는 매개변수가 하나인 생성자가 유일하므로 만약
	아래와 같이 호출하지 않으면 에러가 발생한다.
	 */
	public SavingAccount(int initVal) {
		/*
		만약 아래 문장을 삭제하면 즉시 에러가 발생한다. 삭제하는
		경우 super()라는 문장, 즉 매개변수가 없는 디폴트 생성자를
		호출하는 문장이 자동으로 추가되는데 부모에는 이런 형태의
		생성자가 없으므로 아래와 같이 명시해야 한다.
		 */
		super(initVal);
	}
	/*
	부모클래스에 정의된 멤버변수 money는 private이므로 자식쪽에서는
	아래와 같이 접근할 수 없다. 보이지 않으므로 에러가 발생한다.
	 */
	public void saveMoney(int money) {
//		super.money += money;
		/*
		부모클래스에 protected로 선언된 멤버메서드를 통해 입금처리를
		해야한다.
		 */
		depositMoney(money);
	}
	public void showAccountMoney() {
		//private멤버이므로 접근이 불가능하다.
//		System.out.println("지금까지의 누적금액:"+ money);
		//접근 가능한 메서드를 통해 간접적으로 호출한다.
		System.out.println("지금까지의 누적금액:"+ getAccMoney());
	}
}
public class E02PrivateInheritanceMain {

	public static void main(String[] args) {

		//자식클래스를 통해 객체를 생성한다.
		SavingAccount sa = new SavingAccount(10000);
		/*
		private멤버이므로 상속받은 하위클래스의 참조변수를
		통해서는 접근할 수 없다. 은닉된 정보이므로 'not visible'이라는
		에러메세지를 볼 수 있따.
		 */
//		sa.money = 100000; //에러발생
		sa.saveMoney(5000);
		sa.showAccountMoney();
		//마이너스 금액은 입금이 불가능하다.
		sa.saveMoney(-1000);
		//잔액조회
		sa.showAccountMoney();
		
		/*
		부모클래스의 참조변수를 통해서도 private멤버는 접근할 수 없다.
		현재 접근하려는 위치가 Account클래스 외부이기 때문이다.
		즉, private멤버는 무조건 클래스 내부에서만 접근할 수 있다.
		 */
		Account account = new Account(1000);
//		account.money = 1000;	//에러발생
		
		/*
		Account클래스는 개발자가 매개변수를 하나 가진 생성자를
		호출했으므로 아래와 같이 객체를 생성할 수 없다. 해당 문장은
		매개변수가 없는 디폴트 생성자를 호출하기 때문이다.
		 */
//		Account account2 = new Account();
		
	}

}
