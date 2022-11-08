package ex04controlstatement;

import java.util.Scanner;

public class VipHomework {

	public static void main(String[] args) {

		int grade;
		int point;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("회원등급을 입력하세요 1:VIP회원 2:일반회원\n");
		grade = scan.nextInt();
		System.out.printf("포인트 점수 입력");
		point = scan.nextInt();
		
		if(grade == 1) {
			if(point >= 1000) {
				System.out.printf("고객님의 대출 이율은 6%%입니다.");
			}
			else if(point < 1000 && point >= 0) {
				System.out.printf("고객님의 대출 이율은 7%%입니다.");
			}
			else {
				System.out.printf("점수 잘못입력쓰");
			}
			return;
		}
		
		else if(grade == 2) {
			if(point >= 2000) {
				System.out.printf("고객님의 대출 이율은 8%%입니다.");
			}
			else if(point < 2000 && point >= 0) {
				System.out.printf("고객님의 대출 이율은 9%%입니다.");
			}
			else {
				System.out.printf("점수 잘못입력쓰");
			}
			return;
		}
		else {
			System.out.println("등급 잘못입력쓰");
		}
	}

}
