import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙, 작은 절반
        PriorityQueue<Integer> big = new PriorityQueue<>(); // 최소힙, 큰 절반

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            small.add(num);
            big.add(small.poll());

            // 최대힙의 크기 >= 최소힙의 크기
            if (big.size() > small.size()) small.add(big.poll());

            if (i % 2 == 0) sb.append(small.peek());
            else sb.append(Math.min(small.peek(), big.peek()));

            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}