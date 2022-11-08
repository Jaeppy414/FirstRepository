package ex07string;

public class E02StringMethod4_practice {

	public static void main(String[] args) {
		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		190419-3000000 => 남자
		190419-4000000 => 여자
		*/
		String juminNum = "190419-3000000";
		
		if(juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3') {
			System.out.println("남자입니다.");
		}
		else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4') {
			System.out.println("여자입니다.");
		}
		else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6') {
			System.out.println("외국인입니다.");
		}
		else {
			System.out.println("사람이 아닙니다.");
		}
		System.out.println("========================================");
		/*
		시나리오] 해당 문자열이 이메일 형식인지 검사하는
		프로그램을 contains()를 이용해서 작성하시오.
		hong@daum.net => 이메일형식임
		not@naver => 이메일형식이아님
		*/
		//복습시 indexOf(), split() 메서드를 이용해서도 구현해보세요.
		String email = "swing0414@gmail.com";
		/*
		이메일은 아이디와 도메인을 구분하는 @(엣)와
		도메인 부분에 .(닷)이 동시에 포함되므로 이를 이용해서 판단한다.	
		 */
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일형식임");
		}
		else {
			System.out.println("이메일형식이아님");
		}
		System.out.println("========================================");
		/*
		시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()를
		이용해서 작성하시오.
		*/	
		
		String jumin = "190419-7000000";
		
		int index = jumin.indexOf("-") + 1 ;
		if(jumin.charAt(index)=='1' || jumin.charAt(index)=='3') {
			System.out.println("남자임");
		}
		else if(jumin.charAt(index)=='2' || jumin.charAt(index)=='4') {
			System.out.println("여자자임");
		}
		else if(jumin.charAt(index)=='5' || jumin.charAt(index)=='6') {
			System.out.println("외국인임");
		}
		else {
			System.out.println("잘못입력함.");
		}
		System.out.println("========================================");
		/*
		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
		작성하시오. 
		파일명 : my.file.images.jpg
		*/
		
		String file = "my.file.images.jpg";
		
		System.out.println("방법1-lastIndexOf사용");
		String filename = "my.file.123123.124124.i123123.12313mages.jpg";
		int indexNum = filename.lastIndexOf(".") + 1 ;
		String fileExt = filename.substring(indexNum);
		System.out.println("내가 찾은 인덱스 : "+ indexNum);
		System.out.println("파일확장자 : "+ fileExt);
		
		System.out.println("방법2-split사용");
		//Java에서 split()메서드 사용시 .(닷)의 경우 []를 씌워야 한다.
		String[] strArr = filename.split("[.]");
		System.out.println("배열의 크기 : "+ strArr.length);
		System.out.println("파일확장자 : "+ strArr[strArr.length - 1]);
		
		System.out.println("========================================");		
		
		System.out.println("file 길이 : "+ file.length());
		System.out.println("last : "+ file.lastIndexOf("."));
		System.out.println(file.substring(15));
		
		
	}
}


