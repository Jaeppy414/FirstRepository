

import java.util.Scanner;

public class Gugudan1 {

	public static void main(String[] args) {

		int number, i , result ;
		int decide1, decide2;
		
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.printf("알고 싶은 구구단을 입력하세요. : \n");
			number = scanner.nextInt();
			
			System.out.printf("정순 출력 : 1 역순 출력 : 2");
			decide1 = scanner.nextInt();
			
			if(decide1 == 1) {
				for(i=1 ; i <=9 ; i++) {
					result = number * i	;
					System.out.printf("%d X %d = %2d \n", number, i, result);
				}
				break;
			}
			
			else if(decide1 == 2) {
				for(i=9 ; i>=1 ; i--) {
					result = number*i;
					System.out.printf("%d X %d = %2d \n", number, i , result);
				}
				break;
			}
			
			else {
			System.out.printf("잘못 입력했습니다. 처음으로 돌아갑니다. \n\n=============================\n\n");
			}
		}
		
		while(true) {
			System.out.printf("더 알고 싶은 구구단이 있다면 1, 없다면 0을 입력하세요.");
			decide2 = scanner.nextInt();
			
			while(true) {
				if(decide2 ==1) {
					System.out.printf("알고 싶은 구구단을 입력하세요");
					number = scanner.nextInt();
					System.out.printf("정순 출력 희망 : 1 역순 출력 희망 : 2");
					decide1 = scanner.nextInt();
					
					if(decide1 == 1) {
						for(i=1 ; i <=9 ; i++) {
							result = number * i	;
							System.out.printf("%d X %d = %2d \n", number, i, result);
						}
						break;
					}
					
					else if(decide1 == 2) {
						for(i=9 ; i>=1 ; i--) {
							result = number*i;
							System.out.printf("%d X %d = %2d \n", number, i , result);
						}
						break;
					}
					
					else {
					System.out.printf("잘못 입력했습니다. 처음으로 돌아갑니다. \n\n=============================\n\n");
					break;
					}
				
				}
				else if(decide2 == 0) {
					System.out.printf("프로그램 종료");
					return;
				}
				else {
					System.out.printf("잘못 입력했습니다. 처음으로 돌아갑니다. \n\n=============================\n\n");
					break;
				}
			}
		}	
	}
}	
