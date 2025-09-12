import java.util.*;
import java.io.*;
 
public class Solution {
     
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static int[][] adj;
	static long[] dist;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken()); // 사람 수
        	
        	// 연결 관계 행렬 만들기  
        	adj = new int[N][N];
        	for (int i =0; i < N; i++) { 
        		for (int j = 0; j < N; j++) {
        			adj[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 연결되지 않은 관계 INF로 변환
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (i != j && adj[i][j] == 0) adj[i][j] = INF;
        		}
        	}
        	
        	// 플로이드 워셜
        	for (int k = 0; k < N; k++) {
        		for (int i = 0; i < N; i++) {
        			if (adj[i][k] == INF) continue;
        			for (int j = 0; j < N; j++) {
        				if (adj[k][j] == INF) continue;
        				adj[i][j] = Math.min(adj[i][j],  adj[i][k] + adj[k][j]);
        			}
        		}
        	}
        	
        	// 각 사람 별 거리 합 구하기
        	dist = new long[N];
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			dist[i] += adj[i][j];
        		}
        	}
        	
        	// 거리 합의 최소 구하기
        	long minValue = Long.MAX_VALUE;
        	for (int i = 0; i < N; i++) {
        		minValue = Math.min(minValue, dist[i]);
        	}
        	
        	bw.write("#" + t + " " + minValue + "\n");
        	
        	
        	
        }
 
        
        bw.flush();
        br.close();
        bw.close();
         
    }
    

}