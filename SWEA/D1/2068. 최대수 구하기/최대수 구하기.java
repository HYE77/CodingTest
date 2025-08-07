import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int T = sc.nextInt(); // test case 개수
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[] arr = new int[10]; // 숫자 배열 선언
			
			for (int i = 0; i < 10; i++) { // 숫자 배열 저장
				arr[i] = sc.nextInt();
				
			}
			
			int max = -99999;
			for (int num : arr) { // 배열 순회하며 최댓값 찾기
				if (num > max) {
					max = num;
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}

}
