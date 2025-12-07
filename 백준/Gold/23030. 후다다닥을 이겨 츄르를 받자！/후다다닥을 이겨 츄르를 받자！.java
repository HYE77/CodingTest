import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, T;
    static int[] lineCnt;
    // subway[노선1][역1][0] = 노선2, subway[노선1][역1][1] = 역2 (환승역 정보)
    static int[][][] subway; 
    // dist[노선][역] = 시작점에서 해당 역까지의 최단 시간
    static int[][] dist; 
    static final int MAX = 2000000000; // 충분히 큰 값으로 설정 (Integer.MAX_VALUE 사용 시 오버플로우 대비)

    static class Edge implements Comparable<Edge> {
        int line, num, cost; // line: 노선, num: 역 번호, cost: 시작점으로부터의 누적 비용

        public Edge(int line, int num, int cost) {
            this.line = line;
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 노선의 개수
        lineCnt = new int[N+1]; // 노선 별 역의 개수
        // 역 번호는 최대 50번까지 있으므로, 배열 크기를 51로 설정
        subway = new int[N+1][51][2]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lineCnt[i] = Integer.parseInt(st.nextToken());
        }

        // 환승역 정보 입력 받기
        M = Integer.parseInt(br.readLine()); // 환승역 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int line1 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int line2 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 양방향 연결
            subway[line1][num1][0] = line2;
            subway[line1][num1][1] = num2;
            subway[line2][num2][0] = line1;
            subway[line2][num2][1] = num1;
        }

        K = Integer.parseInt(br.readLine()); // 쿼리 개수
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken()); // 환승 시간

            int u1 = Integer.parseInt(st.nextToken()); // 출발 노선
            int u2 = Integer.parseInt(st.nextToken()); // 출발 역 번호
            int v1 = Integer.parseInt(st.nextToken()); // 도착 노선
            int v2 = Integer.parseInt(st.nextToken()); // 도착 역 번호

            // 초기화
            dist = new int[N+1][51];
            for (int[] arr : dist) Arrays.fill(arr, MAX);

            int d = dijkstra(u1, u2, v1, v2);
            sb.append(d).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static int dijkstra(int startLine, int startNum, int targetLine, int targetNum) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[startLine][startNum] = 0;
        pq.add(new Edge(startLine, startNum, 0));


        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            // 1. 이미 더 짧은 경로를 찾았다면 무시 (Lazy Update)
            if (dist[cur.line][cur.num] < cur.cost) continue;

            // 2. 동일 노선 다음 역 확인 (양방향, 비용 1)
            for (int move : new int[]{-1, 1}) {
                int nextLine = cur.line;
                int nextNum = cur.num + move;

                // 유효성 검사: 역 번호가 1 이상이고 해당 노선의 최대 역 번호 이하인지 확인
                if (nextNum >= 1 && nextNum <= lineCnt[nextLine]) {
                    int newCost = cur.cost + 1; // 1분 소요
                    if (dist[nextLine][nextNum] > newCost) {
                        dist[nextLine][nextNum] = newCost;
                        // ✅ 누적 비용 (newCost)을 PQ에 전달
                        pq.add(new Edge(nextLine, nextNum, newCost)); 
                    }
                }
            }

            // 3. 환승역 처리
            if (subway[cur.line][cur.num][0] > 0) {
                int transLine = subway[cur.line][cur.num][0];
                int transNum = subway[cur.line][cur.num][1];
                
                // 3-1. 환승만 하여 새로운 노선의 환승역에 도착하는 간선 (비용 T)
                int transCost = cur.cost + T;
                if (dist[transLine][transNum] > transCost) {
                    dist[transLine][transNum] = transCost;
                    // ✅ 누적 비용 (transCost)을 PQ에 전달
                    pq.add(new Edge(transLine, transNum, transCost)); 
                }
                
                // Note: 새로운 노선의 환승역 (transLine, transNum)에서
                // 다음 역으로 이동하는 것은 다음 루프에서 처리됩니다.
                // 즉, (transLine, transNum) 역이 PQ에서 추출될 때, 
                // 해당 역에서의 노선 이동(비용 +1)이 자연스럽게 처리됩니다.
            }
        }

        return dist[targetLine][targetNum];
    }
}