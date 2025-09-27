
import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int A, B;
    static List<Character> ansList;
    static Set<Integer> visited;

    static class Node {
        int n;
        List<Character> trace;

        public Node(int n, List<Character> trace) {
            this.n = n;
            this.trace = trace;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            search(A);

            for (char c : ansList) {
                sb.append(c);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void search(int A) {
        visited = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(A, new ArrayList<>()));
        visited.add(A);

        while (!q.isEmpty()) {

            Node curr = q.poll();
            if (curr.n == B) {
                ansList = curr.trace;
                return;
            }

            // 네 가지 경우 모두 체크해보장
            if (!visited.contains(D(curr.n))) {
                List<Character> tmp1 = new ArrayList<>(curr.trace);
                tmp1.add('D');
                q.add(new Node(D(curr.n), tmp1));
                visited.add(D(curr.n));
            }

            if (!visited.contains(S(curr.n))) {
                List<Character> tmp2 = new ArrayList<>(curr.trace);
                tmp2.add('S');
                q.add(new Node(S(curr.n), tmp2));
                visited.add(S(curr.n));
            }
            if (!visited.contains(L(curr.n))) {
                List<Character> tmp3 = new ArrayList<>(curr.trace);
                tmp3.add('L');
                q.add(new Node(L(curr.n), tmp3));
                visited.add(L(curr.n));
            }
            if (!visited.contains(R(curr.n))) {
                List<Character> tmp4 = new ArrayList<>(curr.trace);
                tmp4.add('R');
                q.add(new Node(R(curr.n), tmp4));
                visited.add(R(curr.n));
            }

        }
    }

    static int D(int n) {
        return (2 * n) % 10000;
    }

    static int S(int n) {
        return n == 0 ? 9999 : n-1;
    }

    static int L(int n) {
        return (n * 10) % 10000 + (n / 1000);
    }

    static int R(int n) {
        return (n % 10) * 1000 + n/10 % 1000;
    }
}
