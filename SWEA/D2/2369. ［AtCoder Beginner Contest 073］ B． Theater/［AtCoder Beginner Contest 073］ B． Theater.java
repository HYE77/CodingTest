import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // how many group?
			int sum = 0;
			for (int n = 1; n <= N; n++) {
				int left = sc.nextInt();
				int right = sc.nextInt();
				
				sum += right-left+1;
				
				
			}
			System.out.println("#" + t + " " + sum);
		}
		
		
		sc.close();
		

	}

}
