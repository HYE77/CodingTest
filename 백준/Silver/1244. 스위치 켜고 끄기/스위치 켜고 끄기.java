import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] switches = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String sex = st.nextToken();
			if (sex.equals("1")) {
				// 남자라면
				int k = Integer.parseInt(st.nextToken());
				
				for (int i = k-1; i < N; i++) {
					if ((i+1) % k == 0) {
						switches[i] = Math.abs(switches[i] - 1);
					}
				}
			} else {
				// 여자라면
				int k = Integer.parseInt(st.nextToken());
				switches[k-1] = Math.abs(switches[k-1] - 1);
				int gap = 1;
				while (true) {
					if (k-1 + gap < N && k-1 - gap >= 0) {
						if (switches[k+gap-1] == switches[k-gap-1]) {
							switches[k+gap-1] = Math.abs(switches[k+gap-1] - 1);
							switches[k-gap-1] = Math.abs(switches[k-gap-1] - 1);
						} else break;
						gap++;
					} else break;
				}
				
			}
		}
		for (int i = 0; i < N; i++) {
		    bw.write(switches[i] + " ");
		    if ((i+1) % 20 == 0) { // 20개 출력하면 줄바꿈
		        bw.newLine();
		    }
		}

		
		bw.flush();
		br.close();
		bw.close();

	}

}
