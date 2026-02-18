import java.util.*;
import java.io.*;

public class Main {

    static int N, M, robotR, robotC, robotD;
    static int[][] grid;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1}; // 북 동 남 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        st = new StringTokenizer(br.readLine());
        robotR = Integer.parseInt(st.nextToken());
        robotC = Integer.parseInt(st.nextToken());
        robotD = Integer.parseInt(st.nextToken());

        // grid 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 0: 청소 안 됨 1: 벽
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소기 on
        int ans = 0;
        while (true) {
            // 1. 현재 칸 청소 안 되어 있으면 청소하기
            if (grid[robotR][robotC] == 0) {
                grid[robotR][robotC] = -1;
                ans++;
            }

            // 2. 주변 네 칸 확인
            boolean allClean = true;

            for (int d = 0; d < 4; d++) {
                int nr = robotR + dr[d];
                int nc = robotC + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && grid[nr][nc] == 0) {
                    allClean = false;
                    break;
                }
            }

            if (allClean) {
                // 2-1. 모든 칸이 청소 됨
                int nr = robotR - dr[robotD];
                int nc = robotC - dc[robotD];

                // 벽이라서 갈 수 없다면 작동 중단
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || grid[nr][nc] == 1) break;

                // 후진하기
                robotR = nr;
                robotC = nc;

            } else {
                // 2-2. 청소할 칸 있음
                for (int gap = 1; gap <= 4; gap++) {
                    int newDir = (4 + robotD - gap) % 4;

                    int nr = robotR + dr[newDir];
                    int nc = robotC + dc[newDir];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && grid[nr][nc] == 0) {
                        robotR = nr;
                        robotC = nc;
                        robotD = newDir;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}