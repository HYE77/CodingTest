import java.util.*;
import java.io.*; 
 
public class Solution {
     
    static Map<Integer, ArrayList<Integer>> graph;
    static int cnt;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            graph = new HashMap<>();
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 반 인원
            int M = Integer.parseInt(st.nextToken()); // 친한 친구 관계 (간선) 수 
             
            // 그래프 만들기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                // b-a 상호 연결
                graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
 
            }
             
             
            // 상원이(1)를 시작으로 친한 친구 탐색하기
            Set<Integer> friends = new HashSet<>();
             
            int ans;
            if (!graph.containsKey(1)) ans = 0; // 친구가 1명도 없음
            else { 
                // 친구 있음
                for (int bf : graph.get(1)) {
                    friends.add(bf);
                    for (int bf2 : graph.get(bf)) {
                        friends.add(bf2);
                    }
                }
                friends.remove(1);
                ans = friends.size();
            }
             
            bw.write("#" + t + " " + ans +"");
            bw.flush();
            bw.newLine();
        }
                 
         
        br.close();
        bw.close();
                 
    }
 
}