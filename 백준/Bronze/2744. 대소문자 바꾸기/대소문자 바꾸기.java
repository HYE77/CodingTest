import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// a : 97
		// z : 122
		// A : 65
		// Z : 90
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		int N = word.length();
		String ans = "";
		
		for (int i = 0; i < N; i++) {
			int asci = (int) word.charAt(i);
			if (asci >= 97 && asci <= 122) {
				// 소문자
				ans += (char) (asci - 32);
				
			} else {
				// 대문자
				ans += (char) (asci + 32);
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}