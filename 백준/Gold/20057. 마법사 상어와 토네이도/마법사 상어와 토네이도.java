import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N, outSand;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};  // 좌, 하, 우, 상
	static int[] dc = {-1, 0, 1, 0};

	
	// 왼쪽으로 가는 기준
	// 우로 이동이라면 행열 부호 반전
	// 아래로 이동이라면 행-열 반전 + 행 부호 반전
	// 위로 이동이라면 행-열 반전 + 열 부호 반전
	static int[][] one = {{-1, 1}, {1, 1}};
	static int[][] two = {{-2, 0}, {2, 0}};
	static int[][] five = {{0, -2}};
	static int[][] seven = {{-1, 0}, {1, 0}};
	static int[][] ten = {{-1, -1}, {1, -1}};
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	 for (int j = 0; j < N; j++) {
        		 grid[i][j] = Integer.parseInt(st.nextToken());
        	 }
        }
        
        int currR = N/2; int currC = N/2;
        int dir = 3;
        
        while (!(currR == 0 && currC == 0)) {
        	// 방문 처리
        	visited[currR][currC] = true;
        	
        	// 꺾을 수 있나 확인
        	int nextDir = (dir + 1) % 4; // 다음 방향
        	int nr = currR + dr[nextDir];
        	int nc = currC + dc[nextDir];
        	
        	if (!visited[nr][nc]) { // 꺾을 수 있다면
        		dir = nextDir;
        		currR = nr;
        		currC = nc;
        	} else { // 꺾을 수 없다면 방향 유지
        		currR += dr[dir];
        		currC += dc[dir];
        	}
        	
        	spread(currR, currC, dir);
        	
        }

        bw.write(outSand+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void spread(int toR, int toC, int dir) {
    	// 좌=0, 하=1, 우=2, 상=3
    	// 행열 반전이 필요한 dir : 1, 3 (상, 하)
    	// 열 부호 반전이 필요한 dir : 2, 3 (우,상)
    	// 행 부호 반전이 필요한 dir : 1, 2 (우, 하)
    	int colSign = dir == 3 || dir == 2 ? -1 : 1;
    	int rowSign = dir == 1 || dir == 2 ? -1 : 1;
    	int value = grid[toR][toC];
    	int rest = value;
    	
    	
    	// 도착지점 모래
    	grid[toR][toC] = 0;
    	
    	if (dir == 0 || dir == 2 ) { // 행열 반전 불필요
    		// 1% 
    		int sand = value * 1 / 100;
    		for (int[] move : one) {
    			int nr = toR + move[0] * rowSign;
    			int nc = toC + move[1] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		// 2% 
    		sand = value * 2 / 100;
    		for (int[] move : two) {
    			int nr = toR + move[0] * rowSign;
    			int nc = toC + move[1] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		
    		// 5%
    		sand = value * 5 / 100;
    		for (int[] move : five) {
    			int nr = toR + move[0] * rowSign;
    			int nc = toC + move[1] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		
    		// 7%
    		sand = value * 7 / 100;
    		for (int[] move : seven) {
    			int nr = toR + move[0] * rowSign;
    			int nc = toC + move[1] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		
    		// 10%
    		sand = value * 10 / 100;
    		for (int[] move : ten) {
    			int nr = toR + move[0] * rowSign;
    			int nc = toC + move[1] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}

    		
    	} else { // 행열 반전 필요
    		// 1% 
    		int sand = value * 1 / 100;
    		for (int[] move : one) {
    			int nr = toR + move[1] * rowSign;
    			int nc = toC + move[0] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		// 2%
    		sand = value * 2 / 100;
    		for (int[] move : two) {
    			int nr = toR + move[1] * rowSign;
    			int nc = toC + move[0] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		
    		// 5%
    		sand = value * 5 / 100;
    		for (int[] move : five) {
    			int nr = toR + move[1] * rowSign;
    			int nc = toC + move[0] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		
    		// 7%
    		sand = value * 7 / 100;
    		for (int[] move : seven) {
    			int nr = toR + move[1] * rowSign;
    			int nc = toC + move[0] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    		
    		// 10%
    		sand = value * 10 / 100;
    		for (int[] move : ten) {
    			int nr = toR + move[1] * rowSign;
    			int nc = toC + move[0] * colSign;
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) outSand += sand;
    			else grid[nr][nc] += sand;
    			rest -= sand;
    		}
    	} 
    	
    	// 알파 위치
    	int ar = toR + dr[dir];
    	int ac = toC + dc[dir];
    	if (ar < 0 || ac < 0 || ar >= N || ac >= N) outSand += rest;
    	else grid[ar][ac] += rest;
    }
}
