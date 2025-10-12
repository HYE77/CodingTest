import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 컨베이어 길이
        K = Integer.parseInt(st.nextToken()); // 내구도 0 limit

        belt = new int[N*2][2]; // 0: 내구성 1: 로봇 유무

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; i++) {
            belt[i][0] = Integer.parseInt(st.nextToken());
            belt[i][1] = 0;
        }

        int ans = solve();

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static int solve() {

        int up = 0; // 올리는 위치
        int down = N-1; // 내리는 위치
        int zeroCnt = 0; // 내구성 0인 칸의 개수
        Deque<Integer> robots = new ArrayDeque<>(); // 올라가 있는 로봇 위치
        int turn = 1; // 몇 번째 턴?

        while (true) {
            // 회전하기
            up = (up - 1 + 2*N) % (2*N);
            down = (down - 1 + 2*N) % (2*N);
            belt[down][1] = 0;

            // 먼저 올라간 로봇부터 이동 가능하면 이동 시키기
            int size = robots.size();
            for (int i = 0; i < size; i++) {
                int curr = robots.pollFirst();
                if (curr == down) { // 내리는 지점(down) 도착하면 내리기
                    belt[down][1] = 0;
                    continue;
                }

                int next = (curr+1) % (N*2);

                if (next == down) { // 다음 칸이 내리는 지점
                    if (belt[down][0] == 0) robots.addLast(curr);
                    else {
                        belt[curr][1] = 0;
                        belt[down][0]--;
                        if (belt[down][0] == 0) {
                            zeroCnt++;
                            if (zeroCnt == K) return turn;
                        }
                    }
                } else if (belt[next][0] > 0 && belt[next][1] == 0) { // 다음 칸으로 이동 가능
                    belt[curr][1] = 0;
                    belt[next][0]--;
                    if (belt[next][0] == 0) {
                        zeroCnt++;
                        if (zeroCnt == K) return turn;
                    }
                    belt[next][1] = 1;
                    robots.addLast(next);
                } else if (belt[next][0] == 0 || belt[next][1] == 1) { // 이동 불가능
                    robots.addLast(curr);
                }
            }

            // 로봇 올리기 at 올리는 위치(up)
            if (belt[up][1] == 0 && belt[up][0] > 0) {
                belt[up][1] = 1;
                belt[up][0]--;
                if (belt[up][0] == 0) {
                    zeroCnt++;
                    if (zeroCnt == K) return turn;
                }
                robots.addLast(up);
            }

            turn++;
        }
    }
}
