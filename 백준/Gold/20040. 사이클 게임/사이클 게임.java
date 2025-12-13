import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 점의 개수
        M = Integer.parseInt(st.nextToken()); // 게임 몇 판?

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        int ans = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pA = findParent(a);
            int pB = findParent(b);

            if (pA != pB) parent[pA] = pB;
            else {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static int findParent(int x) {
        if (parent[x] != x) parent[x] = findParent(parent[x]);
        return parent[x];
    }


}