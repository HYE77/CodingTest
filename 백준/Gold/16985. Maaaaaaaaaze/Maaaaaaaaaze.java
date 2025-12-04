import java.io.*;
import java.util.*;

public class Main {
    static int[][][] plates= new int[5][5][5];
    static int[][][] maze;
    static boolean[][][] visited;
    static int[] order; // 쌓는 순서
    static boolean[] orderVisited;
    static int[] dir; // 각 층의 방향
    static int ans = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            for (int r = 0; r < 5; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 5; c++) {
                    plates[i][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 쌓는 순서 정하기
        order = new int[5];
        orderVisited = new boolean[5];
        orderPerm(0);

        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
        br.close();
    }

    static void orderPerm(int sIdx) {
        // 5개의 plate의 순서를 정하는 메서드
        if (sIdx == 5) {
            // 다 채웠다면 순서 정하러 보내기
            dir = new int[5];
            dirPerm(0);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!orderVisited[i]) {
                order[sIdx] = i;
                orderVisited[i] = true;
                orderPerm(sIdx+1);
                orderVisited[i] = false;
            }
        }
    }

    static void dirPerm(int sIdx) {
        // 5개 plate 각각의 방향을 정하는 메서드
        if (sIdx == 5) {
            // 방향을 다 정했다면
            makeMaze();
            return;
        }

        for (int i = 0; i < 4; i++) {
            dir[sIdx] = i;
            dirPerm(sIdx+1);
        }
    }

    static void makeMaze() {
        maze = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            maze[i] = rotate(plates[order[i]], dir[i]);
        }

        bfs();
    }

    static void bfs() {
        int[][] startPos = {{0, 0}, {4, 0}, {0, 4}, {4, 4}};

        Queue<int[]> q;

        for (int[] sPos : startPos) {
            int sol = Integer.MAX_VALUE;

            if (maze[0][sPos[0]][sPos[1]] == 0) continue;

            visited = new boolean[5][5][5];
            q = new ArrayDeque<>();

            q.add(new int[] {0, sPos[0], sPos[1], 0});
            visited[0][sPos[0]][sPos[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                // 도착했다면
                if (cur[0] == 4 && sPos[0] + cur[1] == 4 && sPos[1] + cur[2] == 4) {
                    sol = cur[3];
                    break;
                }

                for (int d = 0; d < 6; d++) {
                    int nz = cur[0] + dz[d];
                    int nr = cur[1] + dr[d];
                    int nc = cur[2] + dc[d];

                    if (nz < 0 || nz >= 5 || nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nz][nr][nc] || maze[nz][nr][nc] == 0) continue;

                    q.add(new int[] {nz, nr, nc, cur[3]+1});
                    visited[nz][nr][nc] = true;
                }
            }

            ans = Math.min(ans, sol);
        }
    }

    static int[][] rotate(int[][] plate, int dir) {
        int[][] newPlate = new int[5][5];
        for (int r = 0; r < 5; r++) {
            newPlate[r] = Arrays.copyOf(plate[r], 5);
        }

        for (int k = 0; k < dir; k++) {
            // 회전시키기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    newPlate[i][j] = plate[4-j][i];
                }
            }

            for (int r = 0; r < 5; r++) plate[r] = Arrays.copyOf(newPlate[r], 5);
        }

        return newPlate;
    }
}
