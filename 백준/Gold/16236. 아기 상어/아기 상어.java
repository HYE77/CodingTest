import java.util.*;
import java.io.*;

public class Main {
    static int N, answer;
    static int[][] tank;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1}; // 북, 서, 동, 남
    static int[] dc = {0, -1, 1, 0};

    static class Pos {
        int i, j, size, time, eat;

        public Pos(int i, int j, int size, int time, int eat) {
            this.i = i;
            this.j = j;
            this.size = size;
            this.time = time;
            this.eat = eat;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 공간 입력받기
        N = Integer.parseInt(br.readLine());
        tank = new int[N][N];
        int curR = -1, curC = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tank[i][j] = Integer.parseInt(st.nextToken());
                if (tank[i][j] == 9) {
                    curR = i;
                    curC = j;
                    tank[i][j] = 0; // 상어 시작 위치는 빈칸 처리
                }
            }
        }

        // 너비우선탐색
        bfs(curR, curC, 2, 0, 0); 
        bw.write(answer + "");

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int i, int j, int size, int time, int eat) {
        visited = new boolean[N][N];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(i, j, size, time, eat));
        visited[i][j] = true;

        // 먹을 수 있는 물고기 후보
        List<Pos> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pos curr = q.poll();

            // 먹을 수 있는 물고기를 찾았을 때
            if (tank[curr.i][curr.j] != 0 && tank[curr.i][curr.j] < curr.size) {
                if (curr.time <= minDist) { 
                    minDist = curr.time;
                    fishes.add(curr);
                }
                continue; // 더 가까운 거리 확인 위해 계속 탐색
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.i + dr[d];
                int nc = curr.j + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (tank[nr][nc] > curr.size) continue; // 상어보다 크면 못 지나감

                visited[nr][nc] = true;
                q.add(new Pos(nr, nc, curr.size, curr.time + 1, curr.eat));
            }
        }

        // 먹을 수 있는 물고기가 없으면 종료
        if (fishes.isEmpty()) {
            answer = time;
            return;
        }

        // 가장 위, 가장 왼쪽 우선 정렬
        fishes.sort((a, b) -> {
            if (a.i != b.i) return a.i - b.i;
            return a.j - b.j;
        });

        Pos target = fishes.get(0); // 먹을 물고기
        int newEat = eat + 1;
        int newSize = size;
        if (newEat == newSize) {
            newSize++;
            newEat = 0;
        }

        // 물고기 먹기
        tank[target.i][target.j] = 0;
        // 새 BFS 시작
        bfs(target.i, target.j, newSize, target.time, newEat);
    }

    static boolean restFish(int sharkSize) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (tank[r][c] != 0 && tank[r][c] < sharkSize) {
                    return true;
                }
            }
        }
        return false;
    }
}
