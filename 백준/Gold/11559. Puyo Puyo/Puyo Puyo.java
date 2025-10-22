import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] grid = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
        	String row = br.readLine();
        	for (int j = 0; j < 6; j++) {
        		grid[i][j] = row.charAt(j);
        		if (grid[i][j] == '.') visited[i][j] = true;
        	}
        }
        
        // game start
        int combo = 0;
        while (true) {
        	boolean explode = false;
        	
        	for (int i = 0; i < 12; i++) {
        		for (int j = 0; j < 6; j++) {
        			if (!visited[i][j]) {
        				bfs(i, j, grid[i][j]);
        				if (grid[i][j] == '.') explode = true;
        			}
        		}
        	}
        	
        	if (!explode) break;
        	gravity();
        	combo++;
        }
        
        System.out.println(combo);
    }
    
    static void bfs(int r, int c, char color) {
    	List<int[]> trace = new ArrayList<>();
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	visited[r][c] = true;
    	trace.add(new int[] {r, c});
    	q.add(new int[] {r, c});
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = cur[0] + dr[i];
    			int nc = cur[1] + dc[i];
    			
    			if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6 && !visited[nr][nc] && grid[nr][nc] == color) {
    				visited[nr][nc] = true;
    				trace.add(new int[] {nr, nc});
    				q.add(new int[] {nr, nc});
    			}
    		}
    	}
    	
    	// 4개 이상이다 -> 터트리기
    	if (trace.size() >= 4) {
    		for (int[] rc : trace) {
    			grid[rc[0]][rc[1]] = '.';
    		}
    	}
    }
    
    
    static void gravity() {
    	// visited 배열 초기화
    	for (boolean[] row : visited) {
    		Arrays.fill(row, false);
    	}
    	
    	for (int col = 0; col < 6; col++) {
    		Stack<Character> stack = new Stack<>();
    		for (int row = 11; row >= 0; row--) {
    			if (grid[row][col] != '.') stack.add(grid[row][col]);
    		}
    		
    		while (stack.size() < 12) stack.add('.');
    		
    		for (int row = 0; row < 12; row++) {
    			grid[row][col] = stack.pop();
    			if (grid[row][col] == '.') visited[row][col] = true;
    		}
    	}
    }
}
