import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] cheese;
	static boolean[][] visited;
	static int[][] airSide;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        visited = new boolean[N][M];
        
        // 초기 치즈 입력받기
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		cheese[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 초기 내부 공기와 외부 공기 구분 (-1=외부, 0=내부, 1=치즈)
        Queue<int[]> q = new ArrayDeque<>();
        cheese[0][0] = -1;
        q.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
        	int[] curr = q.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		int nr = curr[0] + dr[i];
        		int nc = curr[1] + dc[i];
        		
        		if (nr >= 0 && nc >= 0 && nr < N && nc < M && cheese[nr][nc] == 0) {
        			cheese[nr][nc] = -1;
        			q.add(new int[] {nr, nc});
        		}
        	}
        }
             
        // -1=외부, 0=내부, 1=치즈
        int time = 0;
        while (!allMelt()) { // 치즈가 다 녹지 않았다면 반복
        	
        	// 녹을 치즈 구분
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			
        			// 치즈라면 -> 외부와 몇 면 닿아있는지 확인
        			if (cheese[i][j] == 1) {
        				
        				int airCnt = 0;
        				
        				for (int d = 0; d < 4; d++) {
        					int nr = i + dr[d];
        					int nc = j + dc[d];
        					
        					if (nr >= 0 && nc >= 0 && nr < N && nc < M && cheese[nr][nc] == -1) airCnt++;
        				}
        				
        				// 두 변 이상 맞닿았다면 녹을 치즈라는 표시
        				if (airCnt >= 2) cheese[i][j] = 99;
        			}
        		}
        	}
        	
        	// 치즈 녹이기
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			// 녹을 치즈라면
        			if (cheese[i][j] == 99) cheese[i][j] = -1;
        		}
        	}
        	
        	// 수정 요망 !! 
        	// 내부 공기라면 -> 외부랑 닿았는지 확인
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			// 내부
        			if (cheese[i][j] == 0) {
        				
        				for (int d = 0; d < 4; d++) {
        					int nr = i + dr[d];
        					int nc = j + dc[d];
        					
        					if (nr >= 0 && nc >= 0 && nr < N && nc < M && cheese[nr][nc] == -1) {
        						// cheese[i][j]를 시작으로 bfs -> 내부 공기 전부 외부 공기로 바꾸기
        						polutedAir(i, j);
        						break;
        					}
        				}
        			}
        		}
        	}
//        	System.out.println("time : " + time);
//        	for (int[] arr : cheese) {
//        		System.out.println(Arrays.toString(arr));
//        	}
        	
        	time++;
        }
        
        bw.write(time+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void polutedAir(int r, int c) {
    	// 0 -> -1
    	Queue<int[]> q = new ArrayDeque<>();
    	cheese[r][c] = -1;
    	q.add(new int[] {r, c});
    	
    	while (!q.isEmpty()) {
    		int[] curr = q.poll();
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = curr[0] + dr[i];
    			int nc = curr[1] + dc[i];
    			
    			if (nr >= 0 && nc >= 0 && nr < N && nc < M && cheese[nr][nc] == 0) {
    				cheese[nr][nc] = -1;
    				q.add(new int[] {nr, nc});
    			}
    		}
    	}
    }
    
    static boolean allMelt() {
    	boolean ans = true;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (cheese[i][j] == 1) return false;
    		}
    	}
    	
    	return true;
    }
}
