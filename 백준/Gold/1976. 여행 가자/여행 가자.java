import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 여행할 도시 개수
        
        int[][] grid = new int[N][N];
        int[] plan = new int[M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        		if (i == j) grid[i][j] = 1;
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        // 연결 정보 갱신
        for (int k = 0; k < N; k++) {
        	for (int i = 0; i < N; i++) {
        		if (grid[i][k] == 0) continue;
        		for (int j = 0; j < N; j++) {
        			if (grid[k][j] == 0) continue;
        			grid[i][j] = 1;
        		}
        	}
        }
        
        boolean possible = true;
        for (int i = 0; i < M-1; i++) {
        	if (grid[plan[i]][plan[i+1]] == 0) {
        		possible = false;
        		break;
        	}
        }
        
        bw.write(possible ? "YES" : "NO");
        
        bw.flush();
        br.close();
        bw.close();
    }
    
}
