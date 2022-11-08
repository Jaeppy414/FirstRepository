package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
사용자정의 예외클래스
1. Exception 클래스를 상속한다.
2. 생성자에서 예외발생시 출력할 메세지를 super()를 통해 입력한다.
3. 예외 발생지점에서 if문으로 감지한 후 예외객체를 생성 및 throw한다.
4. catch문에서 예외객체를 받아 예외처리한다.
 */
class AgeErrorException2 extends Exception{
	public AgeErrorException2() {
		super("나이 입력이 개잘못 되었어요.");
	}
}
public class Ex06DeveloperDefine2 {

	public static void main(String[] args) {
		
		System.out.print("나이를 입력하세요: ");
		
		//호출한 메서드 내에서 발생된 예외는 해당 메서드에서 직접 처리한다.
		int age = readAge();
		System.out.println("당신의 나이는 "+age+"살 입니다.");
	}

	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;
		
		//문자입력시 발생되는 예외처리
		try {
			inputAge = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//나이를 음수로 입력한 경우 예외처리(개발자 정의)
		try {
			if(inputAge<0) {
				/*
				예외객체가 개발자에 의해 던져지면 해당 위치에서 즉시
				예외처리한다.
				 */
				AgeErrorException2 ex = new AgeErrorException2();
				throw ex;
			}
		}
		catch (AgeErrorException2 e) {
			System.out.println(e.getMessage());
		}
		return inputAge;
	}
}
