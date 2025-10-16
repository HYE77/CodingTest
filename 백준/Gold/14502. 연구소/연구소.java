import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans;
	static int[][] grid, newGrid;
	static List<int[]> virusPos;
	static int[][] selected;
	static boolean[][] alreadySelected;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        virusPos = new ArrayList<>();
        
        
        // grid 배열 입력받기
        // 0=빈칸, 1=벽, 2=바이러스
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        		if (grid[i][j] == 2) virusPos.add(new int[] {i, j});
        	}
        }
        
        // 벽 세개 조합 만들기 뽑기 ...
        selected = new int[3][2]; // 좌표 세 개 저장
        alreadySelected = new boolean[N][M];
         
        solve(0);
       
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void solve(int sIdx) {
    	
    	// 다 채웠당 
    	if (sIdx == 3) {
    		// 1. 벽 세우기
    		newGrid = new int[N][M];
    		for (int i = 0; i < N; i++) {
    			newGrid[i] = grid[i].clone();
    		}
    		
    		for (int[] pos : selected) {
    			newGrid[pos[0]][pos[1]] = 1;
    		}
    		
    		// 2. 바이러스 퍼트리자
    		Queue<int[]> q = new ArrayDeque<>();
    		
    		for (int[] virus : virusPos) {
    			q.add(virus);
    		}
    		
    		while (!q.isEmpty()) {
    			
    			int[] cur = q.poll();
    			
    			for (int i = 0; i < 4; i++) {
    				int nr = cur[0] + dr[i];
    				int nc = cur[1] + dc[i];
    				
    				if (nr >= 0 && nc >= 0 && nr < N && nc < M && newGrid[nr][nc] == 0) {
    					newGrid[nr][nc] = 2;
    					q.add(new int[] {nr, nc});
    				}
    			}
    		}
    		
    		
    		// 3. 안전구역 계산하기
    		int safe = 0;
    		for (int[] row : newGrid) {
    			for (int n : row) {
    				safe += n == 0 ? 1 : 0;
    			}
    		}
    		
    		ans = Math.max(ans, safe);
    		return;
    	}
    	
    	
    	// 더 채우자
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (grid[i][j] == 0 && !alreadySelected[i][j]) { // 벽을 세울 수 있는 곳이라면
    				selected[sIdx] = new int[] {i, j};
    				alreadySelected[i][j] = true;
    				solve(sIdx+1);
    				alreadySelected[i][j] = false;
    			}
    		}
    	}
    	
    }
}
