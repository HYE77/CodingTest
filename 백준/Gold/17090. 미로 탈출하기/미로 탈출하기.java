import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] maze;
    static boolean[][] possible, visited;
    static int[] dr = {-1, 1, 0, 0}; // U D L R
    static int[] dc = {0, 0, -1, 1}; // U D L R
    static String dir = "UDLR";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        possible = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        // start
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                escape(i, j);
            }
        }

        // 탈출 가능한 지점 세기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (possible[i][j]) cnt++;
            }
        }

        System.out.println(cnt+"");
    }

    static void escape(int r, int c) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        int d = dir.indexOf(maze[r][c]);
        int nr = r + dr[d];
        int nc = c + dc[d];

        // 다음으로 이동하면 탈출
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            possible[r][c] = true;
            return;
        }

        // 이미 방문한 위치라면
        if (visited[nr][nc]) {
            possible[r][c] = possible[nr][nc];
            return;
        }

        // 안 가본 곳이라면
        escape(nr, nc);
        possible[r][c] = possible[nr][nc];
    }
}