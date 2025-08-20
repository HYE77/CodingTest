import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < N-K+1; i++) {
			int start = i;
			int sum = 0;
			for (int k = start; k < start+K; k++) {
				sum += temp[k];
			}
			ans = Math.max(ans,  sum);
	
		}
		bw.write(ans+"");
		
		
		
		
		bw.flush();
		br.close();
		bw.close();

	}

}
