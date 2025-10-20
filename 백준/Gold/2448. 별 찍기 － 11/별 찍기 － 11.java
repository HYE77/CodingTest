import java.io.*;
import java.util.*;

public class Main {
	
	static int size;
	static char[][] grid;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        size = Integer.parseInt(br.readLine());
        grid = new char[size][size*2-1];
        for (char[] row : grid) {
        	Arrays.fill(row, ' ');
        }
        
        solve(size-1, size*2-1, size*2);
        
        for (char[] row : grid) {
        	sb.append(row).append('\n');
        }
        
        System.out.println(sb);
        br.close();
    }
    
    static void solve(int lastR, int lastC, int size) {
    	
    	// base case
    	if (size == 6) {
    		for (int c = 0; c < 5; c++) {
    			grid[lastR][lastC-5+c] = '*';
    		}
    		
    		grid[lastR-1][lastC-4] = '*';
    		grid[lastR-1][lastC-2] = '*';
    		grid[lastR-2][lastC-3] = '*';
    		return;
    	}
    	
    	
    	// divide & recursion
    	solve(lastR, lastC, size/2); // 우하
    	solve(lastR, lastC - size/2, size/2); // 좌하
    	solve(lastR - size/2/2, lastC - size/2 + size/2/2, size/2); // 상
    }
}
