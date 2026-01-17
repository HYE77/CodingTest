import java.util.*;
import java.io.*;

public class Main {

    static class Pos implements Comparable<Pos> {
        int num;
        int sum;

        public Pos(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pos o) {
            if (o.sum == this.sum) return this.num - o.num;
            return o.sum - this.sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken()); // 마을의 개수
        int M =  Integer.parseInt(st.nextToken()); // 벽의 개수
        int K =  Integer.parseInt(st.nextToken()); // 돌의 개수

        st = new StringTokenizer(br.readLine());
        int[] cumSum = new int[N+1];
        for (int i = 1; i <= N; i++) cumSum[i] = cumSum[i-1] + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] stones = new int[K];
        for (int i = 0; i < K; i++) stones[i] = Integer.parseInt(st.nextToken());
        List<Pos> lst = new ArrayList<>();

        for (int i = 0; i < K-1; i++) {
            lst.add(new Pos(stones[i], cumSum[stones[i+1]-1] - cumSum[stones[i]-1]));
        }

        lst.add(new Pos(stones[K-1], cumSum[N] - cumSum[stones[K-1]-1]));

        Collections.sort(lst);

        StringBuilder sb = new StringBuilder();
        int[] ans = new int[M];

        for (int i = 0; i < M; i++) {
            ans[i] = lst.get(i).num;
        }

        Arrays.sort(ans);
        for (int n : ans) sb.append(n).append('\n');

        System.out.println(sb.toString());
        br.close();
    }
}