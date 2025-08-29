import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int T, N, M;
    static char[][] map;
    static Deque<Unit> deque;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][];
            deque = new ArrayDeque<>();

            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < M; c++) {
                    // 'S'는 수연, '*' 악마
                    if (map[r][c] == 'S') {
                        deque.addLast(new Unit(r, c, false)); // 수연은 뒤에!
                    } else if (map[r][c] == '*') {
                        deque.addFirst(new Unit(r, c, true)); // 악마는 앞에!!
                    }
                }
            }

            Object answer = bfs();

            if(answer==null) {
                answer = "GAME OVER";
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());

    }

    static Object bfs() {
        // 준비물
        // Queue =  완료! boolean [][] visited: map에 즉시 처리

        while(!deque.isEmpty()) {

            // 1. 대장 데려오기
            Unit head = deque.pollFirst();
            // 2. 할일 하기

            // 3. 다음 탐색
            for(int d=0; d<deltas.length; d++) {
                int nr = head.r + deltas[d][0];
                int nc = head.c + deltas[d][1];

                if(isIn(nr, nc)) {
                    if(head.isDevil && (map[nr][nc]=='.' || map[nr][nc]=='S')) {
                        new Unit(nr, nc, head).visit(deque);
                    }else if(!head.isDevil) {
                        if(map[nr][nc]=='.') {
                            new Unit(nr, nc, head).visit(deque);
                        }else if(map[nr][nc]=='D') { // 목적지에 도착했다면...
                            return head.depth;
                        }
                    }
                }
            }
        }

        return null;
    }

    static boolean isIn(int r, int c) {
        return 0<= r && r< N && 0<=c && c<M;
    }



    static class Unit {
        int r, c, depth=1;
        boolean isDevil;

        public Unit(int r, int c, boolean isDevil) {
            this.r = r;
            this.c = c;
            this.isDevil = isDevil;
        }

        public Unit(int r, int c, Unit pre) {
            this.r = r;
            this.c = c;
            this.isDevil = pre.isDevil;
            this.depth = pre.depth+1 ;// 기존의 depth +1
        }

        public void visit(Deque<Unit> deque) {
            deque.add(this);
            map[this.r][this.c] = isDevil?'*':'S';
        }

    }

}