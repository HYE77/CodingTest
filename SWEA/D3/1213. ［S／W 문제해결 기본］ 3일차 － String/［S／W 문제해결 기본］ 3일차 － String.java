import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int t = 1; t <= T; t++) {
			br.readLine(); // tc 번호 날리기
			
			String pattern = br.readLine();
			int M = pattern.length();
			String text = br.readLine();
			int N = text.length();
						
			
			int cnt = 0;
			
			// N : 문자열 길이, M : 패턴 길이
			for (int n = 0; n < N-M+1; n++) { // 비교할 인덱스
				boolean isOk = true;
				for (int m = 0; m < M; m++) { // 패턴 비교
					if (pattern.charAt(m) != text.charAt(n+m)) {
						isOk = false;
						break;
					}
				}
				if (isOk) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		
			
		}
		
		
	}

}