import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0) visited[i][j] = true;
            }
        }
        
        int ans = -1;
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == n-1 && cur[1] == m-1) {
                ans = cur[2];
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
                
                q.add(new int[] {nr, nc, cur[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        return ans;
        
    }
}