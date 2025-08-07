import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String ans = "";
		
		for (int i = 1; i <= N; i++) {
			char[] numChar = (i + "").toCharArray();
			int cnt = 0;
			for (char c : numChar) {
				if (c == '3' || c == '6' || c == '9') {
					cnt++;
				}
			}
			
			if (cnt == 0) {
				ans += i + "";
			} else if (cnt == 1) {
				ans += "-";
			} else if (cnt == 2) {
				ans += "--";
			} else if (cnt == 3) {
				ans += "---";
			} 
				
			ans += " ";
				
		
			
			
			
			
		}
		
		System.out.println(ans);
		
		sc.close();

	}

}
