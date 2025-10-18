import java.io.*;
import java.util.*;

public class Main {

    static int N, M, G, R, ans = 0;
    static int[][] grid;
    static List<int[]> canPlant; // 심을 수 있는 곳 전체
    static int[] selected; // 선택된 심을 위치(인덱스)
    static Deque<Integer> reds;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken()); // 초록 배양액
        R = Integer.parseInt(st.nextToken()); // 빨강 배양액

        grid = new int[N][M];
        canPlant = new ArrayList<>();
        selected = new int[G+R];
        reds = new ArrayDeque<>();

        // 0=호수 / 1=못뿌려 / 2=뿌려
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) canPlant.add(new int[] {i, j});
            }
        }

        // 심을 곳 뽑기 -> 색 정하기 -> 퍼트리기
        select(0, 0);

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void select(int sIdx, int from) {
        if (sIdx == G+R) { // 선택 다 함
            color(0); // 색 정하기
            return;
        }

        for (int i = from; i < canPlant.size(); i++) {
            selected[sIdx] = i;
            select(sIdx+1, i+1);
        }
    }

    static void color(int from) {
        if (reds.size() == R) {
            // 색 다 정함
            plant();
            return;
        }

        for (int i = from; i < R+G; i++) {
            reds.add(selected[i]);
            color(i+1);
            reds.removeLast();
        }
    }

    static void plant() {
        // 초기화
        int[][] flowers = new int[N][M];
        int[][] time = new int[N][M];

        int cnt = 0;

        // red=2 / greed=3
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < R+G; i++) {
            int[] pos = canPlant.get(selected[i]); // 꽃 인덱스

            flowers[pos[0]][pos[1]] = reds.contains(selected[i]) ? 2 : 3;
            q.add(new int[] {pos[0], pos[1], flowers[pos[0]][pos[1]], 0}); // 좌표, 색, 시간
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (flowers[cur[0]][cur[1]] == 4) continue; // 그새 꽃이 폈다면 넘어가

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                // 범위 밖이거나, 호수이거나라면
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || grid[nr][nc] == 0 || flowers[nr][nc] == 4) continue;

                // 심을 수 있는데 아무것도 안 심긴 곳이라면
                if (flowers[nr][nc] == 0) {
                    flowers[nr][nc] = cur[2];
                    time[nr][nc] = cur[3] + 1;
                    q.add(new int[] {nr, nc, flowers[nr][nc], cur[3]+1});
                } else if (time[nr][nc] == cur[3] + 1 && (flowers[nr][nc] == 2 && cur[2] == 3 || flowers[nr][nc] == 3 && cur[2] == 2)) { // 다른 배양액이 먼저 도달해 있다면
                    flowers[nr][nc] = 4;
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt);
    }
}
