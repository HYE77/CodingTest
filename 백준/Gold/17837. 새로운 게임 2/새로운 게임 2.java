import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] color;
    static List<Integer>[][] grid;
    static int[] dr = {0, 0, 0, -1, 1}; // X우좌상하
    static int[] dc = {0, 1, -1, 0, 0};
    static Node[] nodes;
    static boolean done = false;
    static int turn = 1, ans = 0;
    static Map<Integer, Integer> dict = new HashMap<>();

    static class Node {
        int idx, r, c, dir;

        public Node(int idx, int r, int c, int dir) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 체스판
        K = Integer.parseInt(st.nextToken()); // 말의 개수
        color = new int[N][N]; // 각 위치의 색
        grid = new ArrayList[N][N]; // 각 위치 + 층에 몇 번째 말(노드)가 있는가?
        nodes = new Node[K]; // 말 순서대로 저장

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        dict.put(1, 2);
        dict.put(2, 1);
        dict.put(3, 4);
        dict.put(4, 3);

        // 체스판 채우기
        // 0: 흰색
        // 1: 빨강
        // 2: 파랑
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 말(node) 정보 입력 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(i, r, c, dir);
            grid[r][c].add(i);
        }

        outer:
        while (true) {
            // 불가능 or 1000턴 넘어간다면 종료
            if (turn > 1000) {
                ans = -1;
                break outer;
            }

            // 순서대로 말 이동시키기
            for (int i = 0; i < K; i++) {

                Node cur = nodes[i];

                int nr = cur.r + dr[cur.dir];
                int nc = cur.c + dc[cur.dir];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || color[nr][nc] == 2) {
                    int newDir = dict.get(cur.dir);
                    cur.dir = newDir;
                    int nr2 = cur.r + dr[newDir];
                    int nc2 = cur.c + dc[newDir];

                    if (nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= N || color[nr2][nc2] == 2) continue;

                    if (color[nr2][nc2] == 0) white(i, cur.r, cur.c, nr2, nc2);
                    else if (color[nr2][nc2] == 1) red(i, cur.r, cur.c, nr2, nc2);

                } else if (color[nr][nc] == 0) white(i, cur.r, cur.c, nr, nc);
                else red(i, cur.r, cur.c, nr, nc);

                if (done) break outer;
            } // 말 이동

            turn++;
        }

        System.out.println(ans+"");
        br.close();
    }

    static void red(int idx, int r, int c, int nr, int nc) {
        // 빨간 칸으로 이동하는 메서드
        int from = grid[r][c].indexOf(idx); // from층부터 옮겨야 함
        int size = grid[r][c].size();

        // 이동시키기
        List<Integer> sub = new ArrayList<>(grid[r][c].subList(from, grid[r][c].size()));
        Collections.reverse(sub); // 뒤집기
        grid[nr][nc].addAll(sub);
        grid[r][c].subList(from, size).clear();

        if (grid[nr][nc].size() >= 4) {
            done = true;
            ans = turn;
            return;
        }

        // 말 정보 수정
        for (int n : sub) {
            nodes[n].r = nr;
            nodes[n].c = nc;
        }
    }

    static void white(int idx, int r, int c, int nr, int nc) {
        // 흰색 칸으로 이동하는 메서드
        int from = grid[r][c].indexOf(idx); // from층부터 옮겨야 함
        int size = grid[r][c].size();

        // 이동시키기
        List<Integer> sub = new ArrayList<>(grid[r][c].subList(from, grid[r][c].size()));
        grid[nr][nc].addAll(sub);
        grid[r][c].subList(from, size).clear();

        if (grid[nr][nc].size() >= 4) {
            done = true;
            ans = turn;
            return;
        }

        // 말 정보 수정
        for (int n : sub) {
            nodes[n].r = nr;
            nodes[n].c = nc;
        }
    }
}