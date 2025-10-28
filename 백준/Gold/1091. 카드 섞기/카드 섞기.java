import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];  // P[i] = i번째 카드가 가야 하는 사람 (0,1,2)
        int[] S = new int[N];  // S[i] = i번째 카드가 이동할 위치

        // P 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // S 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 카드 상태: 카드 번호 그대로 (0 ~ N-1)
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = i;
        }

        int count = 0;

        while (true) {
            // 1️⃣ 현재 상태가 조건을 만족하는지 확인
            boolean ok = true;
            for (int i = 0; i < N; i++) {
                if (P[cards[i]] != i % 3) {  // i번째 위치에 있는 카드의 주인이 i%3인지 확인
                    ok = false;
                    break;
                }
            }

            if (ok) { // 모든 카드가 자신의 사람에게 갔다면
                System.out.println(count);
                return;
            }

            // 2️⃣ 섞기
            int[] next = new int[N];
            for (int i = 0; i < N; i++) {
                next[S[i]] = cards[i];
            }
            cards = next;
            count++;

            // 3️⃣ 다시 원래 상태로 돌아왔는지 확인 (무한 루프 방지)
            boolean loop = true;
            for (int i = 0; i < N; i++) {
                if (cards[i] != i) {
                    loop = false;
                    break;
                }
            }

            if (loop) { // 다시 처음으로 돌아왔다면 불가능
                System.out.println(-1);
                return;
            }
        }
    }
}
