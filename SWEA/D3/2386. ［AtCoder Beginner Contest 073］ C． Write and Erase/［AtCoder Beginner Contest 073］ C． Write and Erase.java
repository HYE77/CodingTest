import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			Set<Integer> nums = new HashSet<>();
			
			for (int n = 0; n < N; n++) {
				int num = sc.nextInt();
				if (!nums.contains(num)) {
					nums.add(num);
				} else {
					nums.remove(num);
				}
			}
			
			
			
			System.out.println("#" + t + " " + nums.size());
			
		}
		
		sc.close();
		

	}

}
