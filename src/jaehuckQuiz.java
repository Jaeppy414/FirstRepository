import java.util.Scanner;

// 1부터 n까지의 합 구하기
//1~n까지의 합 중에서 10000을 넘지 않는 가장 큰 수와 그 때의 n의 값 구하는 문제

public class jaehuckQuiz {

	private static int sum1To10() {
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int n=0;
		
		System.out.println("n값을 입력하세요:");
		
		n = scan.nextInt();
		System.out.println(n);
		
		for(int i=1 ; i<=n ; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		
		int sum10 = sum1To10();
		
		System.out.println("1~n1까지의 합: "+ sum10);
	}
}