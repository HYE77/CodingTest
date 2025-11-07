import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 1; i <= N; i++) roots.add(find(i));

        // 두 섬 출력 (오름차순)
        Iterator<Integer> it = roots.iterator();
        int first = it.next();
        int second = it.next();
        if (first > second) { int tmp = first; first = second; second = tmp; }
        System.out.println(first + " " + second);
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
