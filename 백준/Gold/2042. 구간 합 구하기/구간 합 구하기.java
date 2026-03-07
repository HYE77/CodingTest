import java.util.*;
import java.io.*;

public class Main {

    static int N, K, M;
    static long[] nums;

    static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(int n) {
            this.tree = new long[4 * n];
            this.n = n;
        }

        long build(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] = build(arr, node * 2, start, mid) + build(arr, node * 2 + 1, mid + 1, end);
        }

        void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return; // 수정할 인덱스가 범위 밖인 경우

            tree[node] += diff; // 경로에 있는 모든 부모 노드에 차이값 반영
            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }

        long query(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0; // 범위를 완전히 벗어난 경우
            if (left <= start && end <= right) return tree[node]; // 범위에 완전히 포함된 경우

            int mid = (start + end) / 2;
            return query(node * 2, start, mid, left, right)
                    + query(node * 2 + 1, mid + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 수 변경이 일어나는 횟수
        K = Integer.parseInt(st.nextToken()); // 구간합 계산 횟수

        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트트리 만들기
        SegmentTree segTree = new SegmentTree(N);
        segTree.build(nums, 1, 0, N - 1);

        StringBuilder sb = new StringBuilder();

        // 입력받기
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 수 변경
                int targetIdx = b - 1; // 0-based 인덱스로 변환
                long diff = c - nums[targetIdx]; // 현재 값과의 차이 계산
                nums[targetIdx] = c; // 원본 배열 업데이트 (다음 diff 계산을 위해)
                segTree.update(1, 0, N - 1, targetIdx, diff);
            } else {
                // 구간 합
                sb.append(segTree.query(1, 0, N - 1, b - 1, (int) c - 1)).append("\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}