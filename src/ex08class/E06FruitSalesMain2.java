package ex08class;

import java.util.Scanner;
/*
첫번째 버전은 각 클래스의 멤버변수가 고정된 초기값으로 선언되어
상태가 다른 객체를 생성할 수 없다는 단점이 있었다.
두번째 버전에서는 다양한 초기값을 부여할 수 있도록 초기화 메서드를
도입한다.
 */
class FruitSeller2{
	
	int numOfApple;
	int myMoney;
	int apple_price;
	
	/*
	초기화 메서드를 선언하여 객체 생성 후 다양한 형태의 초기화가
	가능하다.
	 */
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	public int saleApple(int money) {
		int num = money/apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
class FruitBuyer2{
	int myMoney;
	int numOfApple;
	
	//초기화 메서드 정의
	public void initMembers(int _mymoney, int _numOfApple) {
		myMoney = _mymoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
	
}
public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int number1 = 0;
		int number2 = 0;
		
		/*
		초기화 메서드가 정의되었으므로 상태가 다른 객체를 생성할 수 있다.
		하지만 객체생성과 초기화를 각각 진행해야 한다는 단점이 존재한다.
		 */
		//판매자1 : 사과 100개, 단가 1000원으로 정의
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		//판매자2 : 사과 80개, 단가 500원으로 정의
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		//구매자 : 보유금액 : 10000원
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);
		
		System.out.println("구매행위가 일어나기 전");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		System.out.printf("사과 얼마치 줄까?\n");
		number1 = scanner.nextInt();
		number2 = scanner.nextInt();
		//각각의 판매자에게 5000원을 지불하고 사과를 구매한다.
		buyer.buyApple(seller1, number1);
		buyer.buyApple(seller2, number2);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();	//5개를 판매한다.
		seller2.showSaleResult();	//10개를 판매한다.
		buyer.showBuyResult();	//10000원을 내고 전체 15개를 구매한다.
	}
}
