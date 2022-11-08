package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuLottoArray {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1 ; i<=45 ; i++) {
			list.add(i);
		}
		int[] lotto = new int[6];
		
		System.out.println("랜덤숫자출력");
		for(int i=0 ; i<lotto.length ; i++) {
			int num = (int)(Math.random()*list.size());
			lotto[i] = list.get(num);
			//중복제거
			list.remove(num);
		}
		for(int i=0 ; i<lotto.length ; i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
		
		//정렬과정 나와라
		System.out.println("정렬과정");
		for(int j=1 ; j<lotto.length ; j++) {
			for(int k=0 ; k<lotto.length-j ; k++) {
				if(lotto[k] > lotto[k+1]) {
					int temp = lotto[k];
					lotto[k] = lotto[k+1];
					lotto[k+1] = temp;
				}
			}
			for(int i=0 ; i<lotto.length ; i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println();
		}
		
		//오름차순 정렬
		System.out.println("오름차순 정렬");
		for(int i=0 ; i<lotto.length ; i++) {
			for(int j=i+1 ;j<lotto.length ; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
	}
}
