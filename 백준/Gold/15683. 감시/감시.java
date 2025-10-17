import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, safe;
	static int ans = Integer.MAX_VALUE;
	static int[][] grid;
	static List<int[]> cctvLst, num5List;
	static int[] selected;
	static boolean[][] already;
	
	static Map<Integer, Integer> limit = new HashMap<>();
	static int[][][] one = {{{-1, 0}}, {{1, 0}}, {{0, -1}}, {{0, 1}}}; // 하, 상, 좌, 우,
	static int[][][] two = {{{-1, 0}, {1, 0}}, {{0, -1}, {0, 1}}}; // 상하, 좌우
	static int[][][] three = {{{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}}; // 상우, 우하, 하좌, 좌상
	static int[][][] four = {{{-1, 0}, {0, 1}, {1, 0}}, {{0, 1}, {1, 0}, {0, -1}}, {{1, 0}, {0, -1}, {-1, 0}}, {{0, -1}, {-1, 0}, {0, 1}}};
	static int[][][][] deltas = {one, two, three, four};
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        limit.put(1, 3);
        limit.put(2, 1);
        limit.put(3, 3);
        limit.put(4, 3);
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        
        
        cctvLst = new ArrayList<>();
        num5List = new  ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        		if (grid[i][j] >= 1 && grid[i][j] <= 4) cctvLst.add(new int[] {i, j, grid[i][j]});
        		else if (grid[i][j] == 5) num5List.add(new int[] {i, j});
        		else if (grid[i][j] == 0) safe++;
        	}
        }
        
        // 5번 cctv 미리 처리
        for (int[] num5 : num5List) {
        	
        	int r = num5[0];
        	int c = num5[1];
        	
        	for (int d = 0; d < 4; d++) { // 각 방향에 대해
        		int gap = 1;
        		while (true) {
        			int nr = r + gap * dr[d];
        			int nc = c + gap * dc[d];
        			
        			// 밖이거나 벽이거나, 이미 감시처리 되어있다면 더 이상 갈 필요 X
        			if (nr < 0 || nc < 0 || nr >= N || nc >= M || grid[nr][nc] == 6) break;
        			
        			// 사각지대라면 감시처리 해주자
        			if (grid[nr][nc] == 0) {
        				grid[nr][nc] = 9;
        				safe--;
        			}
        			
        			gap++;
        			// 이미 감시처리 되었거나 CCTV라면 그대로 스루
        		}
        	}
        }
        
        // cctv 방향 설정해서 사각지대 탐색 고고
        already = new boolean[cctvLst.size()][4]; // [몇 번째 CCTV?][방향(0~3)]
    	selected = new int[cctvLst.size()];
    	solve(0);

    	bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void solve(int cctvIdx) {
    	// cctvIdx -> 지금 정하는 cctv가 몇 번째인가? / dirIdx -> 이 cctv가 어느 방향 보고 있는가? 
    	
    	// 백트래킹
    	// TODO ?
    	
    	// 종료 조건
    	if (cctvIdx == cctvLst.size()) { // 방향 다 정했다면
    		ans = Math.min(ans, safe);
    		return;
    		
    	}
    	
    	for (int i = 0; i <= limit.get(cctvLst.get(cctvIdx)[2]); i++) {
    		// dirIdx (0 ~ 3) 가 해당 번호 cctv의 최대 방향 수보다 작을 때까지만
    		
    		if (already[cctvIdx][i]) continue;
    		
    		// 방향 정하기
    		selected[cctvIdx] = i; // 0 ~ 3
    		already[cctvIdx][i] = true;
    		
    		// 계산하고 다음 거 정하러 보내기
    		int[][][] here = deltas[cctvLst.get(cctvIdx)[2] - 1]; // 몇 번 CCTV인가 (종류)
    		List<int[]> changed = new ArrayList<>(); // 현재 사각지대에서 감시 구역으로 변경되는 좌표 (for 백트래킹)
    		for (int[] oneDir : here[i]) {
    			int gap = 1;
    			while (true) {
    				
    				int nr = cctvLst.get(cctvIdx)[0] + gap * oneDir[0];
    				int nc = cctvLst.get(cctvIdx)[1] + gap * oneDir[1];
    				
    				if (nr < 0 || nc < 0 || nr >= N || nc >= M || grid[nr][nc] == 6) break;
    				
    				if (grid[nr][nc] == 0) {
    					changed.add(new int[] {nr, nc});
    					grid[nr][nc] = 9;
    					safe--;
    				}
    				
    				gap++;
    				// 이미 감시처리 되었거나 CCTV라면 그대로 스루
    			}
    		}
    		
    		solve(cctvIdx+1);
    		
    		// 백트래킹 위한 처리 (원상복구)
    		already[cctvIdx][i] = false;
    		
    		for (int[] pos : changed) {
    			// 감시구역으로 바꾼 위치를 다시 사각지대로
    			grid[pos[0]][pos[1]] = 0;
    		}
    		
    		safe += changed.size();
    	}
    	
    }
    
}
