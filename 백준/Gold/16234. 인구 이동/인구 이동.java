import java.util.*;
import java.io.*;

public class Main {

    static int N, L, R, day;
    static boolean isMoved;
    static int[][] population, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        day = 0;
        while (true) {
            // 국경 열 수 있나 쭉 확인하기
            visited = new int[N][N];

            int num = 1;
            isMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] > 0) continue;

                    // 해당 연합 bfs 시작
                    int sum = population[i][j];
                    int cnt = 1;
                    Queue<int[]> q = new ArrayDeque<>();
                    visited[i][j] = num;
                    q.add(new int[] {i, j, population[i][j]});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] > 0) continue;
                            int gap = Math.abs(cur[2] - population[nr][nc]);
                            if (gap >= L && gap <= R) {
                                visited[nr][nc] = num;
                                cnt++;
                                sum += population[nr][nc];
                                q.add(new int[] {nr, nc, population[nr][nc]});
                            }
                        }
                    }

                    // 연합 다 확인했다면 인구 이동
                    if (cnt > 1) {
                        isMoved = true;
                        int newPop = sum / cnt;
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < N; c++) {
                                if (visited[r][c] == num) population[r][c] = newPop;
                            }
                        }
                    }
                    num++;
                }
            }
            if (!isMoved) break;
            day++;
        }

        System.out.println(day);
        br.close();
    }
}