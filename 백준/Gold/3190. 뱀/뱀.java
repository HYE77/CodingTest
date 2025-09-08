import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static int[][] apples;
	static Map<Integer, Character> moves = new HashMap<>();
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0}; // 우 하 좌 상
	
	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 보드 크기 입력받고 0으로 초기화
		int N = Integer.parseInt(br.readLine()); // 보드의 크기
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
		board[0][0] = 1; // 초기 뱀 위치 
		
		// 사과 좌표 입력받고 보드에 사과를 2로 표시
		int K = Integer.parseInt(br.readLine()); // 사과의 개수
//		apples = new int[K][2];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r-1][c-1] = 2; 
//			apples[k] = new int[] {r-1, c-1};
		}
		
		// 이동 횟수와 방향 
		int M = Integer.parseInt(br.readLine()); // 방향 전환 횟수
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken()); // sec초가 끝난 뒤에 방향 전환
			char dir = st.nextToken().charAt(0);
			moves.put(sec, dir);
		}
		
		// 게임 시작!
		int time = 0;  // 현재 시간
		int curDir = 0; // 현재 진행 방향
		int curR = 0, curC = 0; // 현재 좌표 (머리)
		Queue<Pos> snake = new LinkedList<>(); // 뱀이 차지하는 좌표 저장
		snake.add(new Pos(curR, curC)); // 첫 머리 저장
		
		while (true) { // 순서 : 시간 더하기 -> 진행방향으로 고고 -> 사과 있는지 확인하고 처리 -> 방향 바꿔야 하면 바꾸기
			time++;
			
			// 머리 이동시킬 좌표
			int nextR = curR + dr[curDir % 4];
			int nextC = curC + dc[curDir % 4];
			
			// 이동할 수 있는지 확인 - 보드 바깥이거나 뱀 자신을 만나면 종료
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || board[nextR][nextC] == 1) break;
				
			// 뱀 크기 늘리기
			snake.add(new Pos(nextR, nextC));
			
			// 사과가 있으면 먹기
			if (board[nextR][nextC] == 2) board[nextR][nextC] = 1;
			
			// 사과 없으면 꼬리 움직이기
			else {
				board[nextR][nextC] = 1;
				Pos delete = snake.poll(); // 꼬리 삭제
				board[delete.i][delete.j] = 0;
			}
			
			// 방향 바꿔야 하면 바꿔주기
			if (moves.containsKey(time)) {
				if (moves.get(time) == 'D') curDir++;
				else curDir--;
				curDir = (curDir + 4) % 4;
			}
			
			curR = nextR;
			curC = nextC;
	
		}
		
		bw.write(time+"");
		


		bw.flush();
		br.close();
		bw.close();
		
		
	}


}
