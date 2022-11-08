package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Ex08AsList {

	//List 컬렉션을 매개변수로 받은 후 전체를 출력한다.
	public static void ListPrint(String title, List<String> list) {
		System.out.println("# "+ title);
		/*
		출력할 내용이 String이므로 별도의 오버라이딩 없이도 내용을
		출력할 수 있다. 만약 우리가 직접 정의한 클래스라면 toString()
		메서드를 오버라이딩 해야한다.
		 */
		for(Object ob : list) {
			System.out.println(ob +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		/*
		String 객체배열 생성 및 초기화.초기데이터를 통해크기를 
		유추할 수 있으므로 이 경우에는 크기는 생략한다.
		 */
		String[] strArr = new String[] {"마린", "파이어뱃", "메딕", "마린"};
		/*
		Array.asList() : 일반적인 배열을 List<E> 컬렉션으로 변경해서
			반환한다. 단, 값을 참조만 할 수 있고 변경(입력, 삭제)은
			할 수 없다.
		 */
		List<String> list = Arrays.asList(strArr);
		ListPrint("출력1", list);
		
		//현재 상태에서는 데이터를 추가할 수 없다. 런타임에러 발생
//		list.add("탱크");
		
		//ArrayList<E>의 생성자를 통해 객체를 복사하면 데이터를 변경할 수 있다.
		list = new ArrayList<String>(list);
		//복사한 이후에는 데이터를 추가할 수 있다.
		boolean isAdd = list.add("탱크");
		System.out.println("add결과: "+ isAdd);
		ListPrint("출력2", list);
		
		/*
		이터레이터를 for문을 이용해서 출력한다.
		for(초깃값(이터레이터 객체 생성) ; 조건식(hasNext()) ; 증감식(next()) {
			print(next()메서드가 증감식을 대체함);
		}
		 */
		System.out.println("# 출력3");
		for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+" ");
			
		}
		System.out.println();
		
		/*
		Set<E> 컬렉션은 중복을 허용하지 않으므로 List에 저장된 중복값을
		아래와 같이 제거할 수 있다.
		 */
		//Set으로 복사할 때 중복값이 제거된다.
		HashSet<String> set = new HashSet<String>(list);
		//다시 List로 만든 후 출력한다.
		list = new ArrayList<String>(set);
		ListPrint("출력4", list);
	}
}
