import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			double B = Integer.parseInt(st.nextToken());
			double N = Integer.parseInt(st.nextToken());
			
			if (B == 0 && N == 0) break;
			
			int a = 1;
			while (true) {
				if (Math.pow(a, N) > B) break;
				a++;
			}
			
			int ans = Math.abs(Math.pow(a, N) - B) < Math.abs(Math.pow(a-1, N) - B) ? a : a-1;
			bw.write(ans + "\n");
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}	
