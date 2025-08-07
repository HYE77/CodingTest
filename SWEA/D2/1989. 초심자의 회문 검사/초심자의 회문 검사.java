import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st =  new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int N = str.length();
			
			int isP = 1;
			for (int i = 0; i < N/2; i++) {
				if (str.charAt(i) != str.charAt(N-1-i)) {
					isP = 0;
					break;
				}
			}

			System.out.println("#" + t + " " + isP);
		}
	}

}