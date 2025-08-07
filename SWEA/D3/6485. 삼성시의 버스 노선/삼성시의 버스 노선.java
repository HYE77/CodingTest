import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			int[] busstop = new int[5001];
			int N = Integer.parseInt(br.readLine()); // 버스 노선 개수
			for (int n = 0; n < N; n++) { // 버스 별 정차 정류장 입력받기
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int k = a; k <= b; k++) { // 지나는 버스 정류장에 +1
					busstop[k]++;
				}
			}
			int P = Integer.parseInt(br.readLine()); // 정류장 개수
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			for (int p = 0; p < P; p++) {
				int stop = Integer.parseInt(br.readLine());
				sb.append(busstop[stop] + " ");
			}
			
			System.out.println(sb);
		}
		
		br.close();

	}

}
