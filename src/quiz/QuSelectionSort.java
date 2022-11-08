package quiz;

import java.util.Arrays;

public class QuSelectionSort {

	public static void main(String[] args) {

		//10 배열 생성.
		int[] arr = new int[10];
		
		//랜덤 숫자 생성
		System.out.println("랜덤 숫자 생성");
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = (int)(Math.random()*100+1);
			
			for(int e=0 ; e<i ; e++) {
				if(arr[i]==arr[e]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("========================================");
		
		//정렬과정
		System.out.println("정렬과정 출력");
		for(int i=0 ; i<arr.length-1 ; i++) {
			int index = -1;
			int Min = arr[i];
			for(int j= i+1 ; j<arr.length ; j++) {
				if(Min>arr[j]) {
					Min=arr[j];
					index=j;
				}
			}
			if(index != -1) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}	
			System.out.println(Arrays.toString(arr));
		}
	
		System.out.println("========================================");
		
		//정렬성공
		System.out.println("정렬성공 출력");
		System.out.println(Arrays.toString(arr));
	}
}