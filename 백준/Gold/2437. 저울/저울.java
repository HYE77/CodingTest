import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // 추를 오름차순으로 정렬
        Arrays.sort(weights);

        // 재까지 만들 수 있는 무게의 합 + 1을 추적 (다음에 만들어야 할 목표 숫자)
        int target = 1;

        for (int i = 0; i < N; i++) {
            // 현재 추가된 추가 target보다 크면, target을 만들 방법이 없음
            if (target < weights[i]) break;

            // target 이하라면, target까지 포함하여 target + weights[i] - 1 까지
            // 연속된 숫자를 만들 수 있게 됨
            target += weights[i];
        }

        // 결과 출력
        System.out.println(target);
        br.close();
    }
}