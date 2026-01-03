import java.util.*;
import java.io.*;

public class Main {
    static long N, L, K;
    static int[] sum;

    // 특정 구간(Start ~ Start + Speed) 사이의 점프 지점 개수를 계산하는 함수
    static long jumpCount(long start, long speed) {
        long end = start + speed;

        // 전체 사이클(L)을 몇 번 돌았는지와 나머지 구간을 이용해 계산
        long last = (end / L) * sum[(int) L] + sum[(int) (end % L)];
        long first = (start / L) * sum[(int) L] + sum[(int) (start % L)];

        return last - first;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken()); // 목표 재생 횟수
        L = Long.parseLong(st.nextToken()); // 총 장면 개수
        K = Long.parseLong(st.nextToken()); // 점프 횟수

        // L의 크기에 따라 배열 생성 (L이 매우 크면 이 방식은 메모리 초과가 날 수 있음)
        int[] arr = new int[(int) L + 1];
        sum = new int[(int) L + 1];

        // 점프 타이밍 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[x] = 1;
        }

        // 누적 합 계산 (누적 점프 횟수)
        for (int i = 1; i <= L; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        long now = 0;       // 현재 재생된 장면의 위치
        long speed = 1;     // 현재 속도
        long totalScenes = N * L;

        // 프레임 단위 시뮬레이션
        for (long i = 1; ; i++) {
            // 이번 프레임에서 지나칠 점프 지점의 개수 확인
            long points = jumpCount(now, speed);
            long nextSpeed = speed + points;

            now += speed;     // 장면 이동
            speed = nextSpeed; // 속도 갱신

            // 목표치 도달 시 종료
            if (now >= totalScenes) {
                System.out.println(i);
                break;
            }
        }
    }
}