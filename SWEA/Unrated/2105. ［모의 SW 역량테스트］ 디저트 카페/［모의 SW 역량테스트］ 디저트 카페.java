import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[][] map;
    static boolean[] visitedDstNum; // 어떤 디저트 먹었나
    static int[] dr = {1, 1, -1, -1}; // 4시 방향부터 사각형 시계 방향
    static int[] dc = {1, -1, -1, 1};
    static int answer;
    static int si, sj; // 시작 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            // 디저트 카페 지도 만들기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1; // 최대로 먹을 수 있는 디저트 종류 <- 모든 칸을 출발점으로 돌아보면서 갱신할 것

            // 모든 칸을 출발점으로 시도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    si = i;
                    sj = j;
                    visitedDstNum = new boolean[101]; // 디저트 종류 1~100
                    visitedDstNum[map[i][j]] = true; // 시작점 디저트 방문 처리
                    dfs(i, j, 0, 1); // 시작점 포함해서 count=1
                    visitedDstNum[map[i][j]] = false; // 다른 출발점 위해 해제
                }
            }

            bw.write("#" + t + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j, int dir, int count) {
        // 다음 좌표
        int ni = i + dr[dir];
        int nj = j + dc[dir];

        // 1. 출발점으로 복귀 성공
        if (ni == si && nj == sj && count >= 4) {
            answer = Math.max(answer, count);
            return;
        }

        // 2. 범위 밖이면 종료
        if (ni < 0 || nj < 0 || ni >= N || nj >= N) return;

        // 3. 이미 먹은 디저트면 종료
        if (visitedDstNum[map[ni][nj]]) return;

        // 방문 처리
        visitedDstNum[map[ni][nj]] = true;

        // 같은 방향으로 계속 진행
        dfs(ni, nj, dir, count + 1);

        // 6. 방향 꺾기 (최대 3번까지만 허용)
        if (dir < 3) {
            dfs(ni, nj, dir + 1, count + 1);
        }

        // 7. 백트래킹
        visitedDstNum[map[ni][nj]] = false;
    }
}
