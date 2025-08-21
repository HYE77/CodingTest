import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] money = new int[4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String len = st.nextToken();
			st.nextToken();
			
			switch (len) {
			case "136" :
				money[0]++;
				break;
			case "142" :
				money[1]++;
				break;
			case "148" :
				money[2]++;
				break;
			case "154" :
				money[3]++;
				break;
			
			
			}
		}
		
		int ans = 1000 * money[0] + 5000 * money[1] + 10000 * money[2] + 50000 * money[3];
		
		
		
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();

	}

}
