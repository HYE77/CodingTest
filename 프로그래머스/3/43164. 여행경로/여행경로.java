import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] answer;
    static boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        // 알파벳 순서가 빠른 경로를 먼저 탐색하기 위해 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        
        String[] route = new String[tickets.length + 1];
        route[0] = "ICN";
        
        dfs("ICN", tickets, route, 1);
        
        return answer;
    }
    
    static void dfs(String current, String[][] tickets, String[] route, int cnt) {
        
        if (found) return;
        
        if (cnt == tickets.length + 1) {
            answer = route.clone();
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route[cnt] = tickets[i][1];
                
                dfs(tickets[i][1], tickets, route, cnt + 1);
                
                visited[i] = false;
            }
        }
    }
}