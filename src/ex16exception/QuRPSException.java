package ex16exception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
class ChoiceException extends Exception{
	public ChoiceException() {
		super("[예외발생]숫자를 잘못 입력했습니다.");
	}
}

public class QuRPSException {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int gameCount = 0; 
		
		while(true) {
			
			//1.난수생성
			int com = random.nextInt(10000) % 3 + 1;//1~3사이의 난수
			System.out.println("컴퓨터:"+ com);
			
			//2.사용자입력
			int user = 0;
			System.out.println("가위바위보를 입력하세요.");
			System.out.print("가위(1), 바위(2), 보(3)=>");
				
			try{
				user = scanner.nextInt();//
				
			//3.승부판단
			//사용자가 정상적으로 입력한 경우
				if(!(user<1 || user>3)) {
					//승부판단 로직2 : 입력한 수의 차를 이용해 승부를 판단한다. 
					System.out.printf("사용자:%s, 컴퓨터:%s ", displayRPS(user), displayRPS(com));	
					switch(user - com) {
					case 0:
						System.out.println("비겼습니다.");break;
					case 1: case -2:
						System.out.println("이겼습니다.");break;
					case 2: case -1:
						System.out.println("졌습니다.");break;
					}
					gameCount++;//게임카운트 증가		
				}
				else {
					ChoiceException ce = new ChoiceException();
					throw ce;
				}
			}
			catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("예외메세지:"+ e.getMessage());
//				e.printStackTrace();
			}
			catch (ChoiceException ce) {
					System.out.println("가위바위보 할줄 몰라요?? 제대로 내세요 ㅋ");
				System.out.println("[예외]");
			}
			
			//4.게임재시작 여부 확인			 
			if(gameCount>=5) {
				
				while(true) {
						//0과 1을 입력하지 않아도 게임은 재시작된다. 
						System.out.print("게임재시작(1), 종료(0):");
					try {
						int restart = scanner.nextInt();
						if(restart==0) {
							//게임종료를 위해 while루프 탈출
							System.exit(0);
						}
						else if(restart==1) {
							System.out.println("게임재시작~");
							gameCount=0;
							break;
						}
						else {
							ChoiceException ce = new ChoiceException();
							throw ce;
						}
					}
					catch (InputMismatchException e) {
						scanner.nextLine();
						System.out.println("[예외발생]");
					}
					catch (ChoiceException ce) {
						System.out.println("[예외]");
					}
				}	
			}
			
		}		
	}

	public static String displayRPS(int n) {
		String str = "";
		switch(n) {
		case 1: str="가위";break;
		case 2: str="바위";break;
		case 3: str="보";break;
		}
		return str;
	}
}
