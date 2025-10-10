import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] grid;
	static int currSize, maxSize, cnt;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        maxSize = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (grid[i][j] == 1) {
        			currSize = 0;
        			dfs(i, j);
        			cnt++;
        			maxSize = Math.max(maxSize, currSize);
        		}
        	}
        }
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n').append(maxSize);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void dfs(int startR, int startC) {
    	currSize++;
    	grid[startR][startC] = 0;
    	
    	for (int i = 0; i < 4; i++) {
    		int nr = startR + dr[i];
    		int nc = startC + dc[i];
    		
    		if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) dfs(nr, nc);
    		
    	}
    }
}
