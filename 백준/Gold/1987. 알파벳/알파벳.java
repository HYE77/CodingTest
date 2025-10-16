import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, ans;
	static char[][] grid;
	static boolean[][] gridVisited;
	static boolean[] charVisited = new boolean[26] ;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        grid = new char[R][C];
        gridVisited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
        	String str = br.readLine();
        	for (int c = 0; c < C; c++) {
        		grid[r][c] = str.charAt(c);
        	}
        }
        
        // dfs
        gridVisited[0][0] = true;
        charVisited[grid[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void dfs(int r, int c, int cnt) {
    	ans = Math.max(ans, cnt);
    	
    	for (int i = 0; i < 4; i++) {
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		
    		if (nr >= 0 && nc >= 0 && nr < R && nc < C && !gridVisited[nr][nc] && !charVisited[grid[nr][nc] - 'A']) {
    			gridVisited[nr][nc] = true;
    			charVisited[grid[nr][nc] - 'A'] = true;
    			dfs(nr, nc, cnt+1);
    			charVisited[grid[nr][nc] - 'A'] = false;
    			gridVisited[nr][nc] = false;
    		}
    	}
    }
}
