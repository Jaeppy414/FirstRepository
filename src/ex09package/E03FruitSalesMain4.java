package ex09package;

import ex09package.study.buyer.FruitBuyer4;
import ex09package.study.seller.FruitSeller4;

/*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 구분하여 정상 실행되도록 변경하시오.

FruitSeller4 클래스 -> ex09package.study.seller 패키지에 묶는다.
FruitBuyer4 클래스 -> ex09package.study.buyer 패키지에 묶는다.

두 클래스를 적절히 import 하여 정상동작 할수 있도록 E03FruitSalesMain4 클래스를 구성하시오.
 */ 
/*
세번째 버전에서는 초기화 메서드를 생성자로 변경한다.
 */


public class E03FruitSalesMain4 {

	public static void main(String[] args) {
		
		
		/*
		생성자를 사용해서 객체를 생성하면 생성과 동시에 초기화 할 수
		있으므로 초기화 메서드를 사용하는 것보다 적은 코드로 작성할
		수 있다.
		 */
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);
		
		System.out.println("구매행위가 일어나기 전");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();	
		seller2.showSaleResult();	
		buyer.showBuyResult();	
	}
}
