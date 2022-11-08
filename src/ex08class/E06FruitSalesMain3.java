package ex08class;

import java.util.Scanner;
/*
세번째 버전에서는 초기화 메서드를 생성자로 변경한다.
 */
class FruitSeller3{
	
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE; // 대문자로 수정 : ctrl + Shift + X / 소문자 : Y
	/*
	멤버상수는 값의 변경이 불가능하고, 단 한번만 초기화되기 때문에
	일반 멤버메서드에서는 초기화할 수 없다. 또한 초기값이 없는 상태로
	선언 자체가 불가능하다.
	하지만 생성자는 객체생성시 딱 한번만 호출되고, 개발자가 마음대로
	호출할 수 없으므로 한번 이상 초기화되지 않음이 보장된다.
	따라서 멤버상수는 생성자에서 초기화할 수 있다.
	 */
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
class FruitBuyer3{
	int myMoney;
	int numOfApple;
	
	public FruitBuyer3(int _mymoney, int _numOfApple) {
		myMoney = _mymoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
	
}
public class E06FruitSalesMain3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int number1 = 0;
		int number2 = 0;
		/*
		생성자를 사용해서 객체를 생성하면 생성과 동시에 초기화 할 수
		있으므로 초기화 메서드를 사용하는 것보다 적은 코드로 작성할
		수 있다.
		 */
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		System.out.println("구매행위가 일어나기 전");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		System.out.printf("사과 얼마치 줄까?\n");
		number1 = scanner.nextInt();
		number2 = scanner.nextInt();
		
		buyer.buyApple(seller1, number1);
		buyer.buyApple(seller2, number2);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();	
		seller2.showSaleResult();	
		buyer.showBuyResult();	
	}
}
