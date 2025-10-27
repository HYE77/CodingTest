import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, r, c, K;
	static int[][] grid;
	static int[][] dice = new int[4][3];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        r = Integer.parseInt(st.nextToken()); // 주사위 놓을 곳 x 좌
        c = Integer.parseInt(st.nextToken()); // 주사위 놓을 곳 y 좌표
        K = Integer.parseInt(st.nextToken()); // 명령 개수
        
        grid = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine()); // 이동 명령 
        
        for (int k = 0; k < K; k++) {
        	int move = Integer.parseInt(st.nextToken());
        	
        	// 이동 시키기
        	switch (move) {
        	case 1: // 동
        		if (c == M-1) continue;
        		rollEast();
        		c++;
        		break;
        	case 2: // 서
        		if (c == 0) continue;
        		rollWest();
        		c--;
        		break;
        	case 3: // 북
        		if (r == 0) continue;
        		rollNorth();
        		r--;
        		break;
        	case 4: // 남
        		if (r == N-1) continue;
        		rollSouth();
        		r++;
        		break;
        	}
        	
        	// 숫자 값 변경
        	if (grid[r][c] == 0) grid[r][c] = dice[3][1];
        	else {
        		dice[3][1] = grid[r][c];
        		grid[r][c] = 0;
        	}
        	
        	// 출력
        	sb.append(dice[1][1]).append('\n');
        	
        }
        
        System.out.println(sb.toString());
        br.close();
    }
    
    static void rollEast() {
    	int tmp = dice[3][1]; // 아래
    	dice[3][1] = dice[1][2];
    	dice[1][2] = dice[1][1];
    	dice[1][1] = dice[1][0];
    	dice[1][0] = tmp;
    }
    
    static void rollWest() {
    	int tmp = dice[3][1]; // 아래
    	dice[3][1] = dice[1][0];
    	dice[1][0] = dice[1][1];
    	dice[1][1] = dice[1][2];
    	dice[1][2] = tmp;
    }
    
    static void rollNorth() {
    	int tmp = dice[3][1]; // 아래
    	for (int i = 3; i >= 1; i--) {
    		dice[i][1] = dice[i-1][1];
    	}
    	dice[0][1] = tmp;
    }
    
    static void rollSouth() {
    	int tmp = dice[0][1]; // 위
    	for (int i = 0; i < 3; i++) {
    		dice[i][1] = dice[i+1][1];
    	}
    	dice[3][1] = tmp;
    }
}
