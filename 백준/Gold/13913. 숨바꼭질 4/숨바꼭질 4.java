import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        int[] rightBefore = new int[100001];
        int[] time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);


        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N, 0}); // 좌표, 도달 시간
        time[N] = 0;
        rightBefore[N] = -1;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            if (cur[0] == K) continue; // 도착했거나 목적지 지났다면 더 이동X

            // X-1
            if (cur[0]-1 >= 0 && time[cur[0]-1] > cur[1] + 1) {
                time[cur[0]-1] = cur[1] + 1;
                rightBefore[cur[0]-1] = cur[0];
                q.add(new int[] {cur[0]-1, cur[1]+1});
            }

            // X+1
            if (cur[0]+1 <= 100000 && time[cur[0]+1] > cur[1] + 1) {
                time[cur[0]+1] = cur[1] + 1;
                rightBefore[cur[0]+1] = cur[0];
                q.add(new int[] {cur[0]+1, cur[1]+1});
            }

            // X*2
            if (cur[0] == 0 || cur[0] * 2 > 100000) continue;
            if (time[cur[0]*2] > cur[1] + 1) {
                time[cur[0]*2] = cur[1] + 1;
                rightBefore[cur[0]*2] = cur[0];
                q.add(new int[] {cur[0]*2, cur[1]+1});
            }
        }

        System.out.println(time[K]);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int tmp = K;
        while (rightBefore[tmp] != -1) {
            stack.push(rightBefore[tmp]);
            tmp = rightBefore[tmp];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        sb.append(K);

        System.out.println(sb.toString());
    }
}

