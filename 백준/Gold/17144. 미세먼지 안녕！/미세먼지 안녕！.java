import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, T;
	static int machine1, machine2;
	static int[][] grid;
	static boolean[][] hasDust;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        grid = new int[R][C];
        hasDust = new boolean[R][C];
        
        int machineCnt = 0;
        for (int r = 0; r < R; r++) {
        	st = new StringTokenizer(br.readLine());
        	for (int c = 0; c < C; c++) {
        		grid[r][c] = Integer.parseInt(st.nextToken());
        		if (grid[r][c] == -1) {
        			if (machineCnt == 0) {
        				machine1 = r;
        				machineCnt++;
        			} else machine2 = r;
        		}
        	}
        }
        
        // T초 흐르기
        for (int t = 0; t < T; t++) {
        	grid = dustSpread();
        	vacuumOn();
        }
        
        // 남은 먼지의 양 구하기
        int ans = 0;
        for (int[] arr : grid) {
        	for (int n : arr) {
        		if (n > 0) ans += n;
        	}
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static int[][] dustSpread() {
    	// 빈 공간 체크하기 (먼지가 없거나 공청기이면 false, 있으면 true)
    	hasDust = new boolean[R][C];
    	for (int r = 0; r < R; r++) {
    		for (int c = 0; c < C; c++) {
    			if (grid[r][c] > 0) hasDust[r][c] = true;
    		}
    	}
    	
    	// 먼지 spread 결과를 새로운 배열에 저장
    	int[][] newGrid = new int[R][C];
    	
    	for (int r = 0; r < R; r++) {
    		for (int c = 0; c < C; c++) {
    			if (grid[r][c] == -1) {
    				newGrid[r][c] = -1;
    				continue; // 공기청정기이면 지나가기
    			}
    			
    			if (hasDust[r][c]) { // 미세먼지가 있는 칸이면
    				int original = grid[r][c]; // 원본(중심) 값
    				int blankCnt = 0; // 퍼트릴 수 있는 칸
    				for (int i = 0; i < 4; i++) { // 네 방향 탐색
    					int nr = r + dr[i];
    					int nc = c + dc[i];
    					
    					if (nr < 0 || nc < 0 || nr >= R || nc >= C || grid[nr][nc] == -1) continue; // 갈 수 없거나 공청기면 넘어가
    					blankCnt++;
    					newGrid[nr][nc] += original / 5;
    				}
    				
    				// 원본값(확산의 중심) 수정하기
    				newGrid[r][c] += grid[r][c] - original / 5 * blankCnt;
    			}
    		}
    	}
    	return newGrid;
    }
    
    static void vacuumOn() {
    	// 상단
    	// section1
    	for (int r = machine1-1; r > 0; r--) {
    		grid[r][0] = grid[r-1][0];
    	}
    	
    	// section2
    	for (int c = 0; c < C-1; c++) {
    		grid[0][c] = grid[0][c+1];
    	}
    	
    	// section3
    	for (int r = 0; r < machine1; r++) {
    		grid[r][C-1] = grid[r+1][C-1];
    	}
    	
    	// section4
    	for (int c = C-1; c > 1; c--) {
    		grid[machine1][c] = grid[machine1][c-1];
    	}
    	grid[machine1][1] = 0;
    	
    	
    	
    	// 하단
    	// section1
    	for (int r = machine2+1; r < R-1; r++) {
    		grid[r][0] = grid[r+1][0];
    	}
    	
    	// section2
    	for (int c = 0; c < C-1; c++) {
    		grid[R-1][c] = grid[R-1][c+1];
    	}
    	
    	
    	// section3
    	for (int r = R-1; r > machine2; r--) {
    		grid[r][C-1] = grid[r-1][C-1];
    	}
    	
    	
    	// section4
    	for (int c = C-1; c > 1; c--) {
    		grid[machine2][c] = grid[machine2][c-1];
    	}
    	grid[machine2][1] = 0;
    	
    }
}
