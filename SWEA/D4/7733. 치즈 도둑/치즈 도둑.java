import java.util.*;
import java.io.*;

public class Solution {
	
	static int N; 
	static int[][] cheeseBefore; // 치즈조각 원본
	static int[][] cheeseAfter; // 특정 일수가 지난 후의 치즈
	static int maxDump; // 최대 덩어리 개수
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 한 변의 길이
			
			// 치즈 원본 만들기
			cheeseBefore = new int[N][N];
			int maxValue = -1; // 가장 큰 치즈 맛 값
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheeseBefore[i][j] = Integer.parseInt(st.nextToken());
					maxValue = Math.max(maxValue, cheeseBefore[i][j]);
				}
			}
			
			// n일이 지난 후의 치즈 덩어리 값 비교하여 최대 덩어리 수 구하기
			maxDump = 0;
			for (int day = 0; day <= maxValue; day++) {
				cheeseAfter = cheeseAfterNdays(day);
				int dumpCnt = dumpCheck(cheeseAfter);
				maxDump = Math.max(maxDump, dumpCnt);
	
			}
			
			bw.write("#" + t + " " + maxDump + "\n");
		  
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static int[][] cheeseAfterNdays(int day) {
		// day일이 지난 후의 치즈 상태를 반환
		// 깊은 복사 필요!!!!!!!!!!!!!
		int[][] cheese = new int[N][N];
		for (int k = 0; k < N; k++) {
			cheese[k] = Arrays.copyOf(cheeseBefore[k], N);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cheese[i][j] <= day) cheese[i][j] = 0;
			}
		}
	
		return cheese;
	}
	
	
	static int dumpCheck(int[][] cheeseAfter) {
		
		int cnt = 0;
		
		// 치즈배열 순회하면서 0이 아닌 값 나오면 BFS 순회 / 0 나오면 지나치기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cheeseAfter[i][j] == 0) continue;
				bfs(i, j);
				cnt++;
			}
		}

		return cnt;
	}
	
	
	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		
		cheeseAfter[r][c] = 0; // 방문 처리
		q.add(new Pos(r, c)); // 큐에 넣기
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || cheeseAfter[nr][nc] == 0) continue;
				
				cheeseAfter[nr][nc] = 0;
				q.add(new Pos(nr, nc));
			}
			
		}
		
	}

}
