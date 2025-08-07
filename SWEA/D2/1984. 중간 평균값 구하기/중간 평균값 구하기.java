import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int T = sc.nextInt(); // test case 개수
		
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = -1;
			int min = 999999;
			
			for (int num : arr) { // 최대 최소 찾기
				if (num < min) {
					min = num;
				}
				if (num > max) {
					max = num;
				}
			}
			
			int sum = 0;
			
			for (int num : arr) { // 전체 합 구하기
				sum += num;
			}
			
			int sum2 = sum - min - max;
			
			double result = (double) sum2 / 8;
			
			System.out.println("#" + tc + " " + Math.round(result));
		}

	}

}