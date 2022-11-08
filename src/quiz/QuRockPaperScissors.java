package quiz;

import java.util.Random;
import java.util.Scanner;

public class QuRockPaperScissors {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int man = 0;
		int com = 0;

		int count = 5;
		
		while(true) {
			System.out.printf("가위바위보!");
				man = scanner.nextInt();
				com = random.nextInt(3) + 1;
				
			if(man ==1 && com ==3) {
				System.out.println("컴퓨터는?"+ com);
				System.out.println("이겼습니다.");
				count++;
			}
			else if(man == 2 && com == 1) {
				System.out.println("컴퓨터는?"+ com);
				System.out.println("이겼습니다.");
				count++;
			}
			else if(man ==3 && com ==2) {
				System.out.println("컴퓨터는?"+ com);
				System.out.println("이겼습니다.");
				count++;
			}
			else if(man==com) {
				System.out.println("컴퓨터는?"+ com);
				System.out.println("비겼습니다.");
				count++;
			}
			else if(man==1 && com==2){
				System.out.println("컴퓨터는?"+ com);
				System.out.println("졌습니다.");
				count++;
			}
			else if(man==2 && com==3){
				System.out.println("컴퓨터는?"+ com);
				System.out.println("졌습니다.");
				count++;
			}
			else if(man==3 && com==1){
				System.out.println("컴퓨터는?"+ com);
				System.out.println("졌습니다.");
				count++;
			}
			else {
				System.out.print("잘못입력했습니다. 처음으로 돌아갑니다\n");
			}
				 
			if(count>=5) {
				 
				System.out.print("게임재시작(1), 종료(0):");
				int restart = scanner.nextInt();
				if(restart==0) {
					break;
				}
				else if(restart ==1) {
					System.out.println("게임 재시작^^");
					count=0;
				}
				else {
					System.out.println("다시 입력하세요.");
				}			
			}
		}
	}
}
