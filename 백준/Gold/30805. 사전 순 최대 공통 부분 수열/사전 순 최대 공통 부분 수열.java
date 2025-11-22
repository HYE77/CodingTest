import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.num == o.num) return this.index - o.index;
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        int[] arr1 = new int[A];
        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            pq1.add(new Node(arr1[i], i));
        }

        int B = Integer.parseInt(br.readLine());
        int[] arr2 = new int[B];
        PriorityQueue<Node> pq2 = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            pq2.add(new Node(arr2[i], i));
        }

        // null point exception을 방지하기 위해 끝을 나타내는 노드 입력하기
        pq1.add(new Node(-1, -1));
        pq2.add(new Node(-1, -1));

        // 공통 부분 수열 만들기
        List<Integer> lst = new ArrayList<>();

        Node first = pq1.poll();
        Node second = pq2.poll();
        int lastIdx1 = -1;
        int lastIdx2 = -1;

        while (true) {
            // 만약 한 큐가 비었다면 멈추기
            if (first.num == -1 || second.num == -1) break;

            // 마지막 인덱스보다 먼저 나오는 숫자라면 지나치기
            if (first.index < lastIdx1 || second.index < lastIdx2) {
                if (first.index < lastIdx1) first = pq1.poll();
                if (second.index < lastIdx2) second = pq2.poll();
                continue;
            }

            // 같은 숫자를 찾았다면
            if (first.num == second.num) {
                lst.add(first.num);
                lastIdx1 = first.index;
                lastIdx2 = second.index;
                first = pq1.poll();
                second = pq2.poll();
                continue;
            }

            // 숫자가 다르다면
            if (first.num > second.num) {
                first = pq1.poll();
                continue;
            }

            if (second.num > first.num) {
                second = pq2.poll();
            }
        }

        if (lst.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(lst.size());
        for (int n : lst) {
            System.out.print(n+" ");
        }

        System.out.println();
        br.close();
    }
}