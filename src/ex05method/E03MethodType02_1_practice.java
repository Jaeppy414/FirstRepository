package ex05method;

public class E03MethodType02_1_practice {
//1~10까지의 합:
	// 1부터 10까지의 합은 %d입니다.

	public static void main(String[] args) {
	
		System.out.println("1부터 10까지의 합:"+ sum1To10());
		
		int sum10 = sum1To10();
		System.out.printf("1부터 10까지의 합: %d", sum10);
		
		
	}

	private static int sum1To10() {
		int sum = 0;
		for(int i=1 ; i<=10 ; i++) {
			sum += i;
		}
	return 0;
	}
	
}
