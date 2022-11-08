package quiz;

import java.util.Scanner;

public class QuUpgradeGuGu {

	public static void main(String[] args) {
		
//		/*
//		n의 거듭제곱
//		반복되는 것 : X n
//		결과값 : n을 1번 곱한 것 ~ n을 9번 곱한 것
//		 */
//		for(int dan=2 ; dan<=9 ; dan++) {
//			for(int su=0 ; su<=9 ; su++) {
//				if(su==0) {
//					System.out.printf("%d X 1 = %d\n",dan ,dan);
//				}
//				else {
//					//n을 i번 곱하는 식과 결과 출력
//					String data = " X " + dan;
//					String repeat = data.repeat(su);
//					int result = (int)Math.pow(dan, su+1);
//					System.out.printf("%d%s = %s\n", dan, repeat, result);
//				}
//			}
//		}
//		int result;
//		//2~9까지 반복
//		for(int x=2 ; x<10 ; x++) {
//			//제일 처음 1을 곱하는 부분은 예외적으로 기술.
//			result =x * 1;
//			System.out.printf(x, result);
//			//2~9까지 반복(수)
//			for(int y=2 ; y<10 ; y++) {
//				result = x;
//				System.out.printf(x);
//				
//				for(int z=2 ; z<=y ; z++) {
//					result *=x;
//					System.out.printf(x);
//				}
//				System.out.printf(result);
//				System.out.println();
//			}
//			System.out.println();
//		}
//		for(int i=1 ; i<=10 ; i++){
//		   
//		    System.out.print(i+" ");
//		}  
		
		Scanner scan = new Scanner(System.in);
		
		int num1;
		
		
		num1 = scan.nextInt();
		
		for(int i=1 ; i<= num1 ; i++){
		    for(int j=num1 ; j<=0 ; j--){
		        if(i<j) {
		        	System.out.println(" ");
		        }
		        else {
		        	 System.out.print("*");
		        }
		    }
		
		}
	}
}
