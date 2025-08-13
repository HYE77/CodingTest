import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String memory = br.readLine();
			char[] arr = memory.toCharArray();
			
			int ans = 0;
			if (arr[0] == '1') ans++;
			
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i-1]) ans++;
			}

			System.out.println("#" + t + " " + ans);
			
		}

		br.close();

	}

}
