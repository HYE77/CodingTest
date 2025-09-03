import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			boolean retest = true;
			for (int i = 1; i <= 10; i++) {
				int answer = Integer.parseInt(st.nextToken());
				if (answer != (i-1) % 5 + 1) {
					retest = false;
					break;
				}
			}
			
			if (retest == true) System.out.println(t);
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}	
