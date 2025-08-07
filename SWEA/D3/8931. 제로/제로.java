import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			
			for (int k = 0; k < K; k++) {
				int temp = sc.nextInt();
				if (temp != 0) {
					stack.push(temp);
				} else {
					stack.pop();
				}
				
			}
			
			int sum = 0;
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
		}
		
		sc.close();

	}

}
