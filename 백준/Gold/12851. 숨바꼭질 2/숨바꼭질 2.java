import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[][] cnt; // 시간, 방법 수
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 수빈이
        K = Integer.parseInt(st.nextToken()); // 동생
        
        cnt = new int[100001][2]; // 시간, 방법 수
        for (int i = 0; i < 100001; i++) {
        	cnt[i][0] = Integer.MAX_VALUE;
        }
        
        // BFS
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N, 0});
        
        while (!q.isEmpty()) {
        	int[] cur = q.poll(); // 위치, 시간
        	
        	// 동생을 찾았다면
        	if (cur[0] == K) {
        		if (cur[1] < cnt[K][0]) { // 먼저 도착
        			cnt[K][0] = cur[1];
        			cnt[K][1] = 1;
        		} else if (cur[1] == cnt[K][0]) cnt[K][1]++; // 같은 시간으로 도착
        		continue;
        	}
        	
        	// 방문 처리
        	if (cnt[cur[0]][0] > cur[1])  { // 첫 방문이거나 더 먼저 도착하면
        		cnt[cur[0]][0] = cur[1];
        		cnt[cur[0]][1] = 1;
        	} else if (cnt[cur[0]][0] == cur[1]) { // 같은 시간에 방문했다면 넘어가
        		cnt[cur[0]][1]++; // 같다면 방법 수 + 1
        	} 
        	
        	// X-1
        	if (cur[0]-1 >= 0 && cnt[cur[0]-1][0] >= cur[1]+1) q.add(new int[] {cur[0]-1, cur[1]+1});
        	
        	// X+1
        	if (cur[0]+1 <= 100000 && cnt[cur[0]+1][0] >= cur[1]+1) q.add(new int[] {cur[0]+1, cur[1]+1});
        	
        	// 2X
        	if (cur[0]*2 <= 100000 && cnt[cur[0]*2][0] >= cur[1]+1) q.add(new int[] {cur[0]*2, cur[1]+1});
        }
        
        bw.write(cnt[K][0] + "\n" + cnt[K][1]);
        bw.flush();
        br.close();
        bw.close();
    }
    
}
