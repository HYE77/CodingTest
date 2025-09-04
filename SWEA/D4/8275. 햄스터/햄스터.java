
import java.util.*;
import java.io.*;

public class Solution {
	
	static int[] cage;
	static boolean[] visited;
	static int[] answer;
	static int[][] memo;
	static int N, X, M;
	static boolean found;
	static int hamMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 케이지 개수
			X = Integer.parseInt(st.nextToken()); // 한 케이지에 최대 몇 마리?
			M = Integer.parseInt(st.nextToken()); // 몇 번 세어봤나
			
			cage = new int[N+1];
			visited = new boolean[N+1];
			

			memo = new int[M][3];

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				memo[m] = new int[] {l, r, s}; // 기록 저장
				for (int i = l; i <= r; i++) {
					visited[i] = true;
				}
				
			}
			
			// 초기화 ..
			found = false;
			hamMax = -1;
			
			putHams(1, N);
			
			// 답이 있는지 없는지 확인
			bw.write("#" + t + " ");
			if (found) {
				
				// 제약 걸리지 않은 케이지는 최대로 맞춰주기
				for (int i = 1; i <= N; i++) {
					if (!visited[i]) bw.write(X + " ");
					else bw.write(answer[i] + " ");
				}
		
			} else {
				bw.write("-1");
			}
			
			bw.flush();
			bw.newLine();
		}
		
		
		br.close();
	}
	

	
	static boolean memoCheck() {

		for (int[] arr : memo) {
			int tmpSum = 0;
			for (int i = arr[0]; i <= arr[1]; i++) {
				tmpSum += cage[i];
				if (tmpSum > arr[2])  {
					return false;
				}
			}
			if (tmpSum != arr[2]) return false;
		}
		
		return true;
	}
	
	
	
	static void putHams(int idx, int N) {
//		// 햄스터 순열 만드는 메서드
		
		// 순열 완성 됐으면 메모 조건에 맞는지 확인해보기
		if (idx == N+1) {
			if (memoCheck() && hamCount(cage) > hamMax) {
				hamMax = hamCount(cage);
				answer = Arrays.copyOf(cage,  cage.length); // 정답 배열 저장
				found = true;
			}
			return;
		}
		
		for (int i = 0; i <= X; i++) {
			cage[idx] = i;
			putHams(idx+1, N);
		}
	}
	
	static int hamCount(int[] cage) {
		int cnt = 0;
		for (int n : cage) {
			cnt += n;
		}
		
		return cnt;
	}


}

