import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			int len = str.length();
			
			int cnt = 0;
			int idx = 0;
			while (idx < len-1) {
				if (str.charAt(idx) == '(' && str.charAt(idx+1) == ')') {
					cnt++;
					idx += 2;
				} else if (str.charAt(idx) == '(' && str.charAt(idx+1) == '|') {
					cnt++;
					idx += 2;
				}  else if (str.charAt(idx) == '|' && str.charAt(idx+1) == ')') {
					cnt++;
					idx += 2;
				} else idx++;
			}
			
			
			
			System.out.println("#" + t + " " + cnt);
		}

	}

}
