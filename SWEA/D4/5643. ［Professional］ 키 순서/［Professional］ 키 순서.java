import java.util.*;
import java.io.*;
 
public class Solution {
     
	static int N, M;
	static boolean[][] dist;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	
        	int N = Integer.parseInt(br.readLine()); // 학생 수 (정점)
        	int M = Integer.parseInt(br.readLine()); // 비교 횟수 (간선)
        	
        	dist = new boolean[N+1][N+1];
        	
        	for (int i = 0; i <= N; i++) {
        		dist[i][i] = true;
        	}
        	
        	// a -> b 연결하기
        	for (int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		dist[a][b] = true;
        	}
        	
        	
        	// 경유해서 갈 수 있는 관계 반영하기
        	for (int k = 1; k <= N; k++) { // k: 경유지
        		for (int i = 1; i <= N; i++) { // i: 출발지
        			for (int j = 1; j <= N; j++) { // j: 도착지
        				if (dist[i][k] && dist[k][j]) dist[i][j] = true;
        			}
        		}
        		
        	}
        	   	
        	
        	int[] in = new int[N+1]; // 해당 노드의 진입 차수
        	int[] out = new int[N+1]; // 해당 노드의 진출 차수
        	
        	// 각 노드로 들어올 수 있는 노드의 수와 각 노드에서 나와 도달할 수 있는 노드 수 
        	for (int i = 1; i <= N; i++) {
        		for (int j = 1; j <= N; j++) {
        			if (dist[i][j] == true) {
        				in[j]++;
        				out[i]++;
        			}
        		}
        	}
        	
        	// 결과 출력
        	int answer = 0;
        	for (int i = 1; i <= N; i++) {
        		if (in[i] + out[i] - 1 == N) answer++;
        	}

        	
        	bw.write("#" + t + " " + answer + "\n");
        }
 
        
        bw.flush();
        br.close();
        bw.close();
         
    }
    

}