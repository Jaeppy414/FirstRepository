package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class QuUpDuwnGame {

	public static void main(String[] args) {
		
		//난수생성 및 사용자입력을 위한 객체 생성
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		boolean correct = false; //횟수안에 못 맞췄을 때 실패하기 위해서 boolean으로 변수 하나 만들어 놓기
		
		while(true) { //게임을 재시작하기 위해 전체를 무한루프로 묶음
			int com = random.nextInt(100)+1; //컴퓨터가 먼저 랜덤하게 숫자 생성
			System.out.println("컴퓨터는: "+ com);//실제 게임에서는 주석처리하기
			
			for(int i=1 ; i<=7 ; i++) { //게임이 7회 반복되도록 하는 반복문
				
				try {
					System.out.println("1부터 100까지의 숫자를 입력하세요: ");
					int user = scan.nextInt();
					
					//가위바위보게임처럼 if 문으로 묶어서 상황 가정함
					if(user > com) {
						System.out.println("당신이 높습니다." + i +"번 째");
					}
					else if(user < com) {
						System.out.println("당신이 낮습니다."+ i + "번 째");
					}
					else {
						System.out.println("맞췄습니다.");
						System.out.println(i + "번 째에 정답.");//없어도 될듯?
						correct = true;
						break;
					}
				}
				catch(InputMismatchException e) {
					scan.nextLine();
//					e.printStackTrace();
					System.out.println("예외메세지:"+ e.getMessage());
				}
				
			}
			
			if(correct == false) { //correct가 true를 반환하지 못하면 정답을 못 맞춘거니까 correct는 false를 반환하고 게임은 실패를 반환
				System.out.println("실패");
			}
				
			int restart; //게임 재시작을 위한 변수
			
			while(true) {
				System.out.println("게임재시작(1), 종료(0)");
				try {
					restart = scan.nextInt();
					if(restart == 0) {
						return; //0을 입력하면 return, 값의 반환없이 메소드만 종료
					}
					else if(restart == 1) {
						System.out.println("재시작");
						break; //break를 통해서 가장 가까운 반복문을 끝내고 탈출하게 만들어서 바깥쪽 while로 다시 돌아감. 돌아가면 게임으로 돌아가는 거니까 게임이 다시 재시작됨(?)
					}
					else {
						System.out.println("다시 입력하세요");
					}
				}
				catch(InputMismatchException e) {
					scan.nextLine();
//					e.printStackTrace();
					System.out.println("예외메세지:"+ e.getMessage());
				}
			}
		}
	}
}
