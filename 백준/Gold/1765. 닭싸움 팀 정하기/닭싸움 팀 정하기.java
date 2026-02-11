import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] parent;
    static List<Integer>[] enemy;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 사람 수
        m = Integer.parseInt(br.readLine()); // 관계 수

        enemy = new ArrayList[n+1];
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 1; i <= n; i++) enemy[i] = new ArrayList<>();

        // 관계성 기록 + 친구 먼저 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String fe = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if ("E".equals(fe)) { // 원수 관계 저장
                enemy[from].add(to);
                enemy[to].add(from);
            } else { // 친구 관계
                union(from, to);
            }
        }

        // 원수 관계 처리
        for (int i = 1; i <= n; i++) {
            for (int j : enemy[i]) {
                for (int n : enemy[j]) {
                    // i와 n은 원수의 원수이므로 친구
                    union(i, n);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(findParent(parent[i]));

        System.out.println(set.size());
        br.close();
    }

    static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb) return;

        parent[pa] = pb;
    }

    static int findParent(int n) {
        if (parent[n] != n) parent[n] = findParent(parent[n]);
        return parent[n];
    }
}