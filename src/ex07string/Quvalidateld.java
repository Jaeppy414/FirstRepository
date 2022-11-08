package ex07string;

import java.util.Scanner;

public class Quvalidateld {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요");
		String inputId = scanner.nextLine();
		
		if(idValidate(inputId)) {
			System.out.println("사용할 수 있는 아이디입니다.");
		}
		else {
			System.out.println("사용할 수 없습니다.");
		}
		
	}

	static boolean idValidate(String inputId) {
		if(inputId.length() < 8   || inputId.length() > 12) {
			return false;
		}
		
		int i=0;
		int cnt=0;
		
		while(i<inputId.length()) {
			char idChar = inputId.charAt(i);
			
			if((idChar >= 'a' && idChar <= 'z') 
					|| (idChar >='0' && idChar <='9' )) {
				cnt++;
			}	
			i++;
		}
		if(cnt == inputId.length()) {
			return true;
		}
		return false;

	}
}