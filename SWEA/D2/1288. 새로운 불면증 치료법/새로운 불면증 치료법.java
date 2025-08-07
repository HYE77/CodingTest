import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int mul = 1;
			Set<Character> numList = new HashSet<>();
			
			while (numList.size() < 10) {
				char[] charArr = ((N * mul) + "").toCharArray();
				for (char c : charArr) {
					numList.add(c);
				}
				mul++;
			}
			
			System.out.println("#" + t + " " + (mul-1)*N);
		}
		

	}

}
