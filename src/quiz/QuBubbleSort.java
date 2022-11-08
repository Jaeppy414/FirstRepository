package quiz;

import java.util.Arrays;

public class QuBubbleSort {
	
	public static void main(String[] args) {
		
		//10인 배열 생성
		
		int[] arr = new int[10];
		
		System.out.println("랜덤 숫자 출력");
		for(int i=0 ; i<arr.length ; i++) {
			//1~99까지의 랜덤 정수 출력
			arr[i] = (int)(Math.random()*100+1); 
			//i와 e의 크기가 같다면 i를 없애고 다시 출력해서 중복 제거
			for(int e=0 ; e<i ; e++) {
				if(arr[i]==arr[e]) { 
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("\n======================");
		
		System.out.println("정렬과정");
		for(int j=1 ; j<arr.length ; j++) {
			for(int k=0 ; k<arr.length-j ; k++) {
				if(arr[k] > arr[k+1]) {
					int temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
			}
			for(int i=0 ; i<arr.length ; i++) {
				System.out.printf("%d ", arr[i]);
			}
//			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
		System.out.println("========================");
		
		//정렬 완료된 거 다시 출력
		System.out.println("정렬성공");
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=i+1 ;j<arr.length ; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}
}