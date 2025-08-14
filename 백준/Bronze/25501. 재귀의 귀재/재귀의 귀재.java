import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int recursion(String s, int l, int r) {
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}
	
	public static int recursionTime(String s, int l, int r) {
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 1;
		return 1 + recursionTime(s, l + 1, r - 1);
	}
	

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	
	}
	
	
	public static int palindromeTime(String s) {
		return recursionTime(s, 0, s.length() - 1);
	}

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			System.out.println(isPalindrome(str) + " " + palindromeTime(str));
		}
	}
}