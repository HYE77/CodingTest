import java.util.*;
import java.io.*;

public class Main {

    static int MAX_LEN = 2_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 원래 역의 개수
        int M = Integer.parseInt(st.nextToken()); // 공사 횟수

        boolean[] isOpen = new boolean[MAX_LEN]; // i번째 역이 존재하는지
        int[] prev = new int[MAX_LEN]; // i번 역의 이전 역
        int[] next = new int[MAX_LEN]; // i번 역의 다음 역

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        isOpen[first] = true;

        int from = first;

        for (int i = 1; i < N; i++) {
            int to = Integer.parseInt(st.nextToken());

            isOpen[to] = true;

            next[from] = to;
            prev[to] = from;

            from = to;
        }

        // 원형 연결
        next[from] = first;
        prev[first] = from;

        // 공사 start
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken().toString();
            int i, j, curNext, curPrev, newNext, newPrev;
            switch (cmd) {
                case "BN":
                    i = Integer.parseInt(st.nextToken());
                    j = Integer.parseInt(st.nextToken());

                    curNext = next[i];
                    sb.append(curNext).append('\n'); // i의 다음 역 고유번호 출력

                    // j역 짓기
                    if (isOpen[j]) break;

                    next[i] = j;
                    isOpen[j] = true;
                    next[j] = curNext;
                    prev[j] = i;
                    prev[curNext] = j;

                    break;

                case "BP":
                    i = Integer.parseInt(st.nextToken());
                    j = Integer.parseInt(st.nextToken());

                    curPrev = prev[i];
                    sb.append(curPrev).append('\n'); // i역의 이전 역 고유번호 출력

                    // j역 짓기
                    if (isOpen[j]) break;

                    prev[i] = j;
                    isOpen[j] = true;
                    next[curPrev] = j;
                    prev[j] = curPrev;
                    next[j] = i;

                    break;

                case "CN":
                    i = Integer.parseInt(st.nextToken());
                    curNext = next[i];
                    sb.append(curNext).append('\n'); // 폐쇄될 역 출력
                    isOpen[curNext] = false;

                    newNext = next[curNext];
                    next[i] = newNext;
                    prev[newNext] = i;

                    break;

                case "CP":
                    i = Integer.parseInt(st.nextToken());
                    curPrev = prev[i];
                    sb.append(curPrev).append('\n'); // 폐쇄될 역 출력
                    isOpen[curPrev] = false;

                    newPrev = prev[curPrev];
                    prev[i] = newPrev;
                    next[newPrev] = i;

                    break;
            }
        }

        System.out.println(sb.toString());
    }
}