package quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class QuLottoCollection {

	public static void main(String[] args) {

		/*
		TreeSte<E> 컬렉션은 중복 허용 X Tree라는 자료구조를 기반으로 하므로 정렬 허용한다. Interger와 같은 기본클래스는
		별도 오버라이딩 없이 오름차순으로 정렬.
		 */
//		TreeSet<Integer> lotto = new TreeSet<Integer>();
//		
//		while(lotto.size() < 6) {
//			lotto.add((int)(Math.random()*45)+1);
//		}
//		System.out.println(lotto);
		
		Random ran = new Random()	;
		
		//set계열의 컬렉션 생성
		HashSet<Integer> setlotto1 = new HashSet<Integer>();
		
		while(true) {
			//1~45사이 난수 생성 set에 저장
			//중복된 난수 저장 X set은 중복되지 않는 녀석이고 정렬되지 않는 녀석이다
			setlotto1.add(ran.nextInt(45)+1);
			//숫자 6개가 저장되었다면 루프를 탈출한다.
			if(setlotto1.size() == 6) break;
		}
		//set 컬렉션은 정렬되지 않는다.
		System.out.println(setlotto1);
		
		//set컬렉션은 정렬 되지 않으므로 list 컬렉션으로 변환한다.
		ArrayList<Integer> listlotto1 = new ArrayList<Integer>(setlotto1);
		listlotto1.sort(Comparator.naturalOrder()); //오름차순 정렬
//		listlotto1.sort(Comparator.reverseOrder()); //내림차순 정렬
		//정렬된 로또번호 출력
		System.out.println(listlotto1);
		
		
		
		
	}

}
