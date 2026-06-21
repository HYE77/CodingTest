import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        
        // 연결 관계 기록
        boolean[][] graph = new boolean[n][n];
        for (int[] pair : wires) {
            int a = pair[0] - 1;
            int b = pair[1] - 1;
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        // 찾기
        int ans = Integer.MAX_VALUE;
        for (int[] pair : wires) {
            int a = pair[0] - 1;
            int b = pair[1] - 1;
            
            graph[a][b] = false;
            graph[b][a] = false;
            
            int left = bfs(a, graph);
            int right = bfs(b, graph);
            
            ans = Math.min(ans, Math.abs(left - right));
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        return ans;
        
    }
    
    public int bfs(int start, boolean[][] graph) {
        
        int result = 0;
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            result++;
            
            for (int i = 0; i < graph.length; i++) {
                if (graph[cur][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                } 
            }
        }
        
        return result;
        
    }
}