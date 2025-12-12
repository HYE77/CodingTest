import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] choice;
    // 0: Not Visited, 1: Visiting (in current path), 2: Finished (team status confirmed)
    static int[] visited; 
    static int teamCount; // 최종 팀을 이룬 학생 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            choice = new int[N+1];
            visited = new int[N+1]; // 3가지 상태 배열로 변경
            teamCount = 0; // 매 테스트 케이스마다 초기화

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            // 전체 학생 수 - 팀을 이룬 학생 수 = 팀을 이루지 못한 학생 수
            sb.append(N - teamCount).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    // DFS를 통해 사이클을 찾고 팀을 확정하는 함수
    static void dfs(int current) {
        // 1. 현재 노드를 '방문 중' 상태로 변경
        visited[current] = 1; 

        int next = choice[current];

        // 2. 다음 노드 확인
        if (visited[next] == 0) {
            // Case 1: 미방문 -> 재귀 호출
            dfs(next);
        } else if (visited[next] == 1) {
            // Case 2: 방문 중 -> 사이클 발견!
            // next부터 current까지가 사이클의 멤버
            
            // 사이클 길이 계산 (next부터 다시 순회)
            int cycleLen = 0;
            int runner = next;
            while (runner != current) {
                cycleLen++;
                runner = choice[runner];
            }
            cycleLen++; // current 자신 포함
            teamCount += cycleLen;
        }
        // Case 3: visited[next] == 2 (탐색 완료) -> 이미 팀이 확정된 경로이므로 무시

        // 3. 현재 노드의 탐색 완료. 상태를 '탐색 완료'로 변경
        visited[current] = 2;
    }
}