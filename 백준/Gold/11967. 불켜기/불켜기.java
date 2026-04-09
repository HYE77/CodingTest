import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<int[]>[][] info;
    static boolean[][] light, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N*N 개의 방
        M = Integer.parseInt(st.nextToken()); // 스위치 정보 개수

        visited = new boolean[N][N];
        light = new boolean[N][N];
        info = new ArrayList[N][N];

        // info 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                info[i][j] = new ArrayList<>();
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            // (x, y) 방에서 (a, b) 방 불을 켤 수 있음
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            info[x][y].add(new int[] {a, b});
        }

        // bfs
        // 순서: 큐에 넣기 - 꺼내기 - 방문처리 - 불 켜기 - 이동(큐에 넣기)
        Queue<int[]> q = new ArrayDeque<>();
        light[0][0] = true; // 불 켜져있음

        q.add(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            visited[cur[0]][cur[1]] = true; // 방문 체크

            // 다른 방 불 켜기
            if (!info[cur[0]][cur[1]].isEmpty()) {
                for (int[] pair : info[cur[0]][cur[1]]) {
                    light[pair[0]][pair[1]] = true;
                    if (!visited[pair[0]][pair[1]] && canGo(pair[0], pair[1])) {
                        q.add(pair);
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || !light[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }

        // 불 켜진 곳 세기
        int ans = 0;
        for (boolean[] row : light) {
            for (boolean b : row) {
                if (b) ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static boolean canGo(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < N && nc < N && visited[nr][nc] && light[nr][nc]){
                return true;
            }
        }

        return false;
    }
}