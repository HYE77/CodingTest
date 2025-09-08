import java.util.*;
import java.io.*;

public class Solution {
	static int N; // 판 크기 N*N
	static char[][] board; // 판
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			
			// 초기 게임판 완성하기
			for (int i = 0; i < N; i++) {
				char[] tmpArr = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					board[i][j] = tmpArr[j];
				}
			}
			
			
			// 초기게임판에서 주위에 지뢰가 없는 칸 찾기
			Queue<Pos> zeroMines = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mineCount(i, j) == '0') zeroMines.add(new Pos(i, j));
				}
			}
			
			
			
			// 위 칸 시작점으로 bfs
			int click = 0;
			
			while (!zeroMines.isEmpty()) {
				Pos curr = zeroMines.poll();
				if (board[curr.r][curr.c] == '.') {
					bfs(curr.r, curr.c);
					click++;
				}
			}

			
			// 남은 칸 수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '.') click++;
				}
			}
			
			bw.write("#" + t + " " + click + "\n");
			
		  
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static void bfs(int r, int c) {
		// (r, c)를 기준으로 너비우선탐색하며 지뢰 탐색하는 메서드
		Queue<Pos> q = new LinkedList<>();
	
		
		board[r][c] = mineCount(r, c);
		if (board[r][c] != '0') return;
		
		// 클릭한 곳 주변 지뢰가 0이라면 bfs 시작
		q.add(new Pos(r, c));
		
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				// board 범위 밖이거나, 이미 방문 했거나 지뢰면 패스
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == '*' || board[nr][nc] >= '0' && board[nr][nc] <= '8') continue;
				
				// '.'이면
				board[nr][nc] = mineCount(nr, nc);
				if (board[nr][nc] == '0') q.add(new Pos(nr, nc));
			}
	
		}
		
	}
	
	
	static char mineCount(int r, int c) {
		// (r, c) 주위에 지뢰가 몇 개 있는지 확인하는 메서드
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 값이 보드에 존재하고 지뢰라면 카운트+1
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && board[nr][nc] == '*') cnt++;
		}
		
		return Character.forDigit(cnt, 10);
	}
	
}
