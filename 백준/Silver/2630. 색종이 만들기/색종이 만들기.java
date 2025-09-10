import java.util.*;
import java.io.*;

public class Main {

    static int white = 0, blue = 0;
    static int N;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);
        bw.write(white + "\n" + blue);


        bw.flush();
        br.close();
        bw.close();
    }

    static void search(int rowStart, int colStart, int size) {
        // 종료 조건
        if (size == 1 || isSame(rowStart, colStart, size)) {
            if (paper[rowStart][colStart] == 0) white++;
            else blue++;
            return;
        }

        // 4등분 해야 하면 나누기
        search(rowStart, colStart, size/2);
        search(rowStart, colStart+size/2, size/2);
        search(rowStart+size/2, colStart, size/2);
        search(rowStart+size/2, colStart+size/2, size/2);

    }

    static boolean isSame(int rowStart, int colStart, int size) {
        Set<Integer> set = new HashSet<>();

        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                set.add(paper[i][j]);
            }
        }

        return set.size() == 1;
    }


}
