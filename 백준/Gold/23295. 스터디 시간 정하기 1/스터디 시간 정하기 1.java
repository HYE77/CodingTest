import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 참가자 수
        int T = Integer.parseInt(st.nextToken()); // 스터디 시간

        final int MAX = 100000;
        int[] diff = new int[MAX + 2]; // 차분 배열

        // 참가자 시간 정보 입력
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine()); // 이 참가자의 구간 개수
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                // [s, e) 구간에 +1
                diff[s]++;
                diff[e]--;
            }
        }

        // 스위핑: 각 시각에 가능한 사람 수 time[t]
        int[] time = new int[MAX + 1];
        time[0] = diff[0];
        for (int i = 1; i <= MAX; i++) {
            time[i] = time[i - 1] + diff[i];
        }

        // 길이 T짜리 윈도우의 합을 슬라이딩 윈도우로 계산
        long curSum = 0;
        // 먼저 [0, T) 구간 합
        for (int i = 0; i < T && i <= MAX; i++) {
            curSum += time[i];
        }

        long bestSum = curSum;
        int bestStart = 0;
        int bestEnd = T; // [bestStart, bestEnd)

        // 윈도우 오른쪽으로 한 칸씩 밀기
        // i = 윈도우의 오른쪽 인덱스
        for (int i = T; i <= MAX; i++) {
            // 윈도우 [i-T+1, i] 로 이동
            curSum -= time[i - T]; // 왼쪽 끝 빠짐
            curSum += time[i];     // 새로운 오른쪽 끝 들어옴

            if (curSum > bestSum) {
                bestSum = curSum;
                bestStart = i - T + 1;
                bestEnd = bestStart + T;
            }
        }

        System.out.println(bestStart + " " + bestEnd);
    }
}
