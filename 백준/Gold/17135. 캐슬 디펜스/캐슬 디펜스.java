import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D, totalEnemy, ans = 0;
    static int[][] grid;
    static int[] selected = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) totalEnemy++;
            }
        }

        // 진행 순서: 궁수 배치 - [가까운 적 찾기 - 공격 - 한 칸 내리기]
        // 궁수 위치 정하기
        comb(0, 0);

        System.out.println(ans);
        br.close();
    }

    static void comb(int sIdx, int idx) {
        // 궁수를 배치하는 조합 구하는 메서드

        if (sIdx == 3) {
            gameStart();
            return;
        }

        for (int i = idx; i < M; i++) {
            selected[sIdx] = i;
            comb(sIdx+1, i+1);
        }
    }

    static void gameStart() {
        // 게임 진행: [가까운 적 찾기 - 공격 - 한 칸 내리기] 반복

        // grid 복사본 만들고 궁수 배치하기
        int[][] gridTemp = new int[N][M];
        for (int r = 0; r < N; r++) gridTemp[r] = Arrays.copyOf(grid[r], M);

        // 라운드 시작
        int enemyCnt = totalEnemy; // 남은 적의 수
        int killCnt = 0; // 죽인 적의 수
        Set<int[]> killHere;
        while (enemyCnt > 0) {
            // 1. 가까운 적 찾기
            killHere = new HashSet<>();
            for (int[] archer : new int[][] {{N, selected[0]}, {N, selected[1]}, {N, selected[2]}}) {
                int i = -1, j = -1, minDist = 1_000_000_000;
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        // 빈 위치이면 넘어가기
                        if (gridTemp[r][c] == 0) continue;

                        // 적이 있는 위치라면
                        int tmpDist = Math.abs(archer[0]-r) + Math.abs(archer[1]-c);
                        if (tmpDist > minDist || tmpDist > D) continue; // 거리가 더 멀면 패스
                        if (tmpDist < minDist) {
                            minDist = tmpDist;
                            i = r;
                            j = c;
                        } else {
                            // 거리가 같다면 왼쪽 위치 저장
                            if (j > c) {
                                i = r;
                                j = c;
                            }
                        }
                    }
                }
                if (i >= 0 && j >= 0) killHere.add(new int[] {i, j});
            }

            // 2. 적 공격하기
            for (int[] pos : killHere) {
                // set에 같은 위치가 들어가는 것을 막기 위해 if문 추가
                if (gridTemp[pos[0]][pos[1]] == 1) {
                    gridTemp[pos[0]][pos[1]] = 0;
                    killCnt++;
                    enemyCnt--;
                }
            }

            // 3-1. 제일 아랫줄에서 사라질 적의 수 세기
            for (int n : gridTemp[N-1]) {
                if (n == 1) enemyCnt--;
            }

            // 3-2. 한 칸 내리기
            for (int r = N-1; r > 0; r--) {
                gridTemp[r] = Arrays.copyOf(gridTemp[r-1], M);
            }

            Arrays.fill(gridTemp[0], 0);

        }

        ans = Math.max(ans, killCnt);
    }
}