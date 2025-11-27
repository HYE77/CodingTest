import java.io.*;
import java.util.*;

public class Main {

    static int N, H, D, K;
    static char[][] grid;
    static int[][] visited;
    static int[] start, safe;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Pos {
        int r, c, time, hp, umb;

        public Pos(int r, int c, int time, int hp, int umb) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.hp = hp;
            this.umb = umb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // D: 내구도, H: 현재 체력, K: 우산 개수, U: 우산, S: 현위치, E: 안전지대

        N = Integer.parseInt(st.nextToken()); // grid 넓이
        H = Integer.parseInt(st.nextToken()); // 현재 체력
        D = Integer.parseInt(st.nextToken()); // 우산 내구도

        grid = new char[N][N];
        visited = new int[N][N];
        for (int[] row : visited) Arrays.fill(row, -1);
        start = new int[2];
        safe = new int[2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.charAt(j);

                if (grid[i][j] =='S') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'E') {
                    safe[0] = i;
                    safe[1] = j;
                }
            }
        }

        // search
        int ans = bfs(start[0], start[1]);

        System.out.println(ans);
        br.close();
    }

    static int bfs(int startR, int startC) {
        int result = -1;

        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(startR, startC, 0, H, 0));
        visited[startR][startC] = H;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // 범위 밖이거나 이미 방문한 곳이라면 넘어가기
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                // 안전지대라면
                if (nr == safe[0] && nc == safe[1]) return cur.time+1;

                // 시작지점이라면
                if (nr == start[0] && nc == start[1]) {
                    if (visited[nr][nc] >= cur.umb + cur.hp) continue;
                    q.add(new Pos(nr, nc, cur.time+1, cur.hp, cur.umb));
                    visited[nr][nc] = cur.umb + cur.hp;
                    continue;
                }

                // 우산이라면
                if (grid[nr][nc] == 'U') {
                    if (visited[nr][nc] >= D-1 + cur.hp) continue;
                    q.add(new Pos(nr, nc, cur.time+1, cur.hp, D-1));
                    visited[nr][nc] = D-1 + cur.hp;
                    continue;
                }

                // 죽음의 비라면
                if (grid[nr][nc] == '.') {
                    if (visited[nr][nc] >= cur.umb + cur.hp - 1) continue;

                    if (cur.umb > 0) {
                        q.add(new Pos(nr, nc, cur.time+1, cur.hp, cur.umb-1));
                        visited[nr][nc] = cur.umb-1 + cur.hp;
                    } else if (cur.umb == 0 && cur.hp > 1) {
                        q.add(new Pos(nr, nc, cur.time+1, cur.hp-1, cur.umb));
                        visited[nr][nc] = cur.umb + cur.hp-1;
                    } else if (cur.umb == 0 && cur.hp == 1) continue;

                }
            }
        }

        return result;
    }
}