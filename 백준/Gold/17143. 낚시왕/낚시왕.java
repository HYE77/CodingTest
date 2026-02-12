import java.util.*;
import java.io.*;

public class Main {
    static int R, C, M;
    static int caught = 0;
    static int[][] tank;
    // 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽 (문제 기준)
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    static int[] reverseD = {0, 2, 1, 4, 3};
    static Shark[] sharks;

    static class Shark {
        int r, c, speed, dir, size;
        boolean isDead = false;

        public Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tank = new int[R][C];
        sharks = new Shark[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks[i] = new Shark(r, c, s, d, z);
            tank[r][c] = i;
        }

        // 낚시왕 이동
        for (int king = 0; king < C; king++) {
            // 1. 상어 잡기
            for (int r = 0; r < R; r++) {
                if (tank[r][king] > 0) {
                    int sharkIdx = tank[r][king];
                    caught += sharks[sharkIdx].size;
                    sharks[sharkIdx].isDead = true;
                    tank[r][king] = 0;
                    break;
                }
            }

            // 2. 상어 이동
            moveAllSharks();
        }

        System.out.println(caught);
    }

    static void moveAllSharks() {
        int[][] nextTank = new int[R][C];

        for (int i = 1; i <= M; i++) {
            Shark s = sharks[i];
            if (s == null || s.isDead) continue;

            // 속도 최적화: 제자리로 돌아오는 주기를 이용
            int moveDist = s.speed;
            if (s.dir <= 2) moveDist %= (R - 1) * 2;
            else moveDist %= (C - 1) * 2;

            for (int d = 0; d < moveDist; d++) {
                int nr = s.r + dr[s.dir];
                int nc = s.c + dc[s.dir];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    s.dir = reverseD[s.dir]; // 방향 반전
                    s.r += dr[s.dir];
                    s.c += dc[s.dir];
                } else {
                    s.r = nr;
                    s.c = nc;
                }
            }

            // 이동 완료 후, 같은 칸에 상어가 있는지 확인
            if (nextTank[s.r][s.c] == 0) {
                nextTank[s.r][s.c] = i;
            } else {
                // 이미 상어가 있다면 크기 비교
                int otherIdx = nextTank[s.r][s.c];
                if (sharks[otherIdx].size < s.size) {
                    sharks[otherIdx].isDead = true;
                    nextTank[s.r][s.c] = i;
                } else {
                    s.isDead = true;
                }
            }
        }
        // 원래 탱크 업데이트
        tank = nextTank;
    }
}