import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			sc.next();
			int[] scores = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				int tmp = sc.nextInt();
				scores[tmp]++;
			}
			
			int maxIdx = 100;
			for (int i = 100; i >= 0; i--) {
				if (scores[i] > scores[maxIdx]) {
					maxIdx = i;
				}
			}
			
			System.out.println("#" + t + " " + maxIdx);
		}
		
		sc.close();
	

	}

}
