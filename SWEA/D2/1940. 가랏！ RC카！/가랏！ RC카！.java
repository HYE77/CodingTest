import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 0 : 현재 속도 유지
        // 1 : 가속
        // 2 : 감속

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // command의 개수
            int speed = 0;
            int dist = 0;
            for (int n = 0; n < N; n++) { // command 입력 받기
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());

                // 0 : 속도 유지
                if (cmd == 0) {
                    dist += speed;
                    continue;
                }

                int d = Integer.parseInt(st.nextToken());

                // 1 : 가속
                if (cmd == 1) {
                    speed += d;
                    dist += speed;
                    continue;
                }

                // 2 : 감속
                if (cmd == 2) {
                    speed = Math.max(speed - d, 0);
                    dist += speed;
                }
            }

            System.out.println("#" + t + " " + dist);
        }

        br.close();
    }
}
