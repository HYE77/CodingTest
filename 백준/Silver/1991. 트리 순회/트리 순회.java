import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<String, Node> graph;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        String left, right;

        public Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            String L = st.nextToken();
            String R = st.nextToken();

            graph.put(P, new Node(L, R));

        }

        preOrder("A");
        sb.append('\n');
        inOrder("A");
        sb.append('\n');
        postOrder("A");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void preOrder(String start) {
        sb.append(start);
        if (!graph.get(start).left.equals(".")) preOrder(graph.get(start).left);
        if (!graph.get(start).right.equals(".")) preOrder(graph.get(start).right);

    }

    static void inOrder(String start) {
        if (!graph.get(start).left.equals(".")) inOrder(graph.get(start).left);
        sb.append(start);
        if (!graph.get(start).right.equals(".")) inOrder(graph.get(start).right);

    }

    static void postOrder(String start) {
        if (!graph.get(start).left.equals(".")) postOrder(graph.get(start).left);
        if (!graph.get(start).right.equals(".")) postOrder(graph.get(start).right);
        sb.append(start);

    }
}
