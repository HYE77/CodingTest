import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] grid;
	static int chickCnt; // 초기 치킨집 개수
	static int houseCnt; // 집 개수
	static Map<Integer, Node> chickens; // 치킨집 위치
	static Map<Integer, Node> houses; // 집 위치
	static int[] selected;
	static boolean[] visited;
	static int[] dist;
	static int ans = Integer.MAX_VALUE;
	
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 받기
        N = Integer.parseInt(st.nextToken()); // 도시 한 변
        M = Integer.parseInt(st.nextToken()); // 치킨집 개수
        
        grid = new int[N][N];
        chickens = new HashMap<>();
        houses = new HashMap<>();
        selected = new int[M];
        
        chickCnt = 0; houseCnt = 0; // map에 저장할 키 
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		grid[i][j] = tmp;
        		if (tmp == 2) chickens.put(chickCnt++, new Node(i, j));
        		else if (tmp == 1) houses.put(houseCnt++, new Node(i, j));
        	}
        }
        
        visited = new boolean[chickCnt];
        
        // M개의 치킨집 고르기
        choose(0, 0);
        
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void choose(int n, int sIdx) {
    	// M개의 치킨집을 고르는 메서드
    	if (sIdx == M) {
    		ans = Math.min(ans, chickenDist(selected));
    		return;
    	}
    	
    	for (int i = n; i < chickCnt; i++) {
    		if (visited[i]) continue;
    		
    		selected[sIdx] = i;
    		visited[i] = true;
    		choose(i+1, sIdx+1);
    		visited[i] = false;
    		
    	}
    	
    }
    
    static int chickenDist(int[] select) {
    	// M개의 치킨집이 정해졌을 때 최소 치킨거리를 구하는 메서드
    	dist = new int[houseCnt];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	int distSum = 0;
    	
    	for (int chick : select) {
    		// 현재 치킨집 좌표
    		int chickR = chickens.get(chick).r;
    		int chickC = chickens.get(chick).c;
    		
    		for (int h : houses.keySet()) {
    			int houseR = houses.get(h).r;
    			int houseC = houses.get(h).c;
    			
    			int tmpDist = Math.abs(chickR - houseR) + Math.abs(chickC - houseC);
    			dist[h] = Math.min(dist[h], tmpDist);
    		}
    	}
    	
    	for (int d : dist) {
    		distSum += d;
    	}

    	return distSum;
    }
}
