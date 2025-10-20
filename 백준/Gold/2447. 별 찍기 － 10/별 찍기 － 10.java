import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static char[][] grid;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        grid = new char[N][N];
        for (char[] row : grid) {
        	Arrays.fill(row, '*');
        }
        
        solve(0, 0, N);
        for (char[] row : grid) {
        	sb.append(row).append('\n');
        }
        
        System.out.println(sb.toString());
        br.close();
    }
    
    static void solve(int startR, int startC, int size) {
    	
    	// base case
    	if (size == 3) {
    		grid[startR+1][startC+1] = ' ';
    		return;
    	}
    	
    	
    	// recursion
    	// 상단
    	solve(startR, startC, size/3);
    	solve(startR, startC + size/3, size/3);
    	solve(startR, startC + 2 * size/3, size/3);
    	
    	// 중간
    	solve(startR + size/3, startC, size/3);
    	for (int r = startR+size/3; r < startR + 2 * size/3; r++) {
    		for (int c = startC + size/3; c < startC + 2*size/3; c++) {
    			grid[r][c] = ' ';
    		}
    	}
    	solve(startR + size/3, startC + 2 * size/3, size/3);
    	
    	// 하단
    	solve(startR + 2*size/3, startC, size/3);
    	solve(startR + 2*size/3, startC + size/3, size/3);
    	solve(startR + 2*size/3, startC + 2*size/3, size/3);
    }
}
