import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, targetR, targetC;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node {
		int r;
		int c;
		int dist;
		
		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 2) {
        			targetR = i; targetC =j;
        		}
        	}
        }
        
        bfs(targetR, targetC);
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (map[i][j] == 1 && result[i][j] == 0 && !visited[i][j] ) result[i][j] = -1;
        	}
        }
        
        for (int[] line : result) {
        	for (int n : line) {
        		bw.write(n + " ");
        	}
        	bw.newLine();
        }
        
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void bfs(int r, int c) {
    	// r, c에서 시작해서 맵 전체를 너비우선탐색하는 메서드
    	
    	Queue<Node> q = new ArrayDeque<>();
    	
    	q.add(new Node(r, c, 0));
    	result[r][c] = 0;
    	visited[r][c] = true;
    	
    	while (!q.isEmpty()) {
    		Node curr = q.poll();
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = curr.r + dr[i];
    			int nc = curr.c + dc[i];
    			
    			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
    			
    			if (map[nr][nc] == 0) {
    				result[nr][nc] = 0;
    				visited[nr][nc] = true;
    				continue;
    			}
    			
    			q.add(new Node(nr, nc, curr.dist+1));
    			result[nr][nc] = curr.dist + 1;
    			visited[nr][nc] = true;
    		}
    	}
    	
    }

}

