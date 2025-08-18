
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] plane = new int[1001][1001];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for (int a = y; a < y + height; a++) {
				for (int b = x; b < x + width; b++) {
					plane[a][b] = n;
				}
			}
		}
		
		for (int n = 1; n <= N; n++) {
			int ans = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (plane[i][j] == n) {
						ans++;
					}
				}
			}
			
			bw.write(ans+"");
			bw.flush();
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}

}
