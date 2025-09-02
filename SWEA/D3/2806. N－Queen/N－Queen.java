import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean[][] tmp;
	static int ans;
	static int[] dc = {-1, 0, 1};
	static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	
        	tmp = new boolean[N][N];
        	ans = 0;
        	
        	nQueens(0, N);
        	
        	System.out.println("#" + t + " " + ans);
    	
        }
        
        br.close();
   
        
    }
    
    public static void nQueens(int rIdx, int N) {
    	if (rIdx == N) {
    		ans++;
    		return;
    	}
    	
    	for (int col = 0; col < N; col++) {
    		if (isOk(rIdx, col)) {
    			tmp[rIdx][col] = true; // queen 놓기
    			nQueens(rIdx+1, N);
    			tmp[rIdx][col] = false; // 다시 빼기
    		}
    	}
    	
    	
    }
    
    public static boolean isOk(int row, int col) {
    	boolean result = true;
    	
    	// row번 탐색해야 함 (윗줄이 row개)
    	for (int r = 1; r <= row; r++) { // 위쪽 행 하나씩 올라가면서 순회
    		for (int d = 0; d < 3; d++) { // 11시 12시 1시 방향 탐색
    			int nr = row - r;
    			int nc = col + r * dc[d];
    			if (nc >= 0 && nc < N && tmp[nr][nc] == true) {
    				// 해당 칸이 존재하는데 퀸이 있다면
    				result = false;
    				break;
    			}
    		}
    		if (!result) break;
    	}
  	
    	return result; 	
    	
    }

}
