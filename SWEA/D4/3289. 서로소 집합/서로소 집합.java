import java.util.*;
import java.io.*;

public class Solution {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1~N까지의 숫자 존재
			int M = Integer.parseInt(st.nextToken()); // 연산 횟수
			
			// 집합배열 초기화 (자기자신)
			p = new int[N+1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken()); // 연산
				int a = Integer.parseInt(st.nextToken()); // 숫자1
				int b = Integer.parseInt(st.nextToken()); // 숫자2
				
				if (cal == 0) { // a, b Union
					int pa = findSet(a);
					int pb = findSet(b);
					if (pa != pb) p[pa] = pb;
					
				} else { // a, b 같은 집합인지 확인
					if (findSet(a) == findSet(b)) sb.append("1");
					else sb.append("0");
					
				}
			}
			sb.append("\n");
			bw.write(sb.toString());
		}

		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static int findSet(int a) {
		// a가 속한 집합의 대표자를 찾아 반환하는 메서드 (경로압축O)
		if (p[a] != a) p[a] = findSet(p[a]);
		return p[a];
	}

}
