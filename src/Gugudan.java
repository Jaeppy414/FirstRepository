import java.util.Scanner;

public class Gugudan {

	private static int sum1To10() {
		
		int sum = 0;
		
//		int n=0;
//		int u=0;
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("n값 입력: ");
//		n = scanner.nextInt();
//		System.out.println("u값 입력: ");
//		u = scanner.nextInt();	//이렇게 하면 n ~ u 입력값 까지의 합 구함.
//		
		for(int i=1 ; i<=10 ; i++) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		
		System.out.println("1번 1~10까지의 합:"+ sum1To10());
		
		int sum10 = sum1To10();
		System.out.printf("2번 1~10까지의 합: %d", sum10);
	}
	
}

//		
//		i = sc.nextInt();
//		Scanner scanner = new Scanner(System.in);
//		for(int i=2 ; i<=9 ; i++) {
//			for(int j=1 ; j<=9 ; j++) {
//				System.out.printf("%d X %d = %2d / ", i, j, (i*j));
//			}
//			System.out.println();
//		}
		
//		for(int dan=2 ; dan<=9 ; dan++) {
//			for(int su=1 ; su<=9 ; su++) {
//				System.out.printf("%d X %d = %2d / ", dan, su, (dan*su));
//			}
//			System.out.println();
//		}
//		System.out.println("========================================");
//		
//		for(int su=1 ; su<=9 ; su++) {
//			for(int dan=2 ; dan<=9 ; dan++) {
//				System.out.printf("%d X %d = %2d / ", dan, su, (dan*su));
//			}
//			System.out.println();
//		}
