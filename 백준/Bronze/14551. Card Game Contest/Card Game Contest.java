import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N 종류의 카드게임
		int M = Integer.parseInt(st.nextToken()); // M으로 나눈 나머지!
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 1;
		
		for (int n : arr) {
			ans = (ans *Math.max(n, 1)) % M;
		}
		
		ans %= M;
		
		bw.write(ans+"");
		
		bw.flush();
		br.close();
		bw.close();
	}

}