import java.io.*;
import java.util.*;

public class Main {

    static int[][] grid;
    static List<int[]> need2go;
    static int howMany;
    static boolean found;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        grid = new int[9][9];
        need2go = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.charAt(j) - '0';
                if (grid[i][j] == 0) need2go.add(new int[] {i, j});
            }
        }

        howMany = need2go.size();

        sudoku(0, -1, -1);

        for (int[] row : grid) {
            for (int n : row) {
                sb.append(n);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void sudoku(int idx, int prevR, int prevC) {
        // 백트래킹
        if (found) return;
        if (prevR >= 0 && prevC >= 0) {
            if (!(horCheck(prevR) && verCheck(prevC) && squareCheck(prevR, prevC))) return;
        }

        // 다 찾았다면 끝
        if (idx == howMany) {
            found = true;
            return;
        }

        int r = need2go.get(idx)[0];
        int c = need2go.get(idx)[1];

        for (int i = 1; i < 10; i++) {
            grid[r][c] = i;
            sudoku(idx+1, r, c);
            if (found) return;
            grid[r][c] = 0;
        }
    }

    static boolean horCheck(int r) {
        boolean isOk = true;
        boolean[] visited = new boolean[10];
        for (int n : grid[r]) {
            if (n == 0) continue;
            if (!visited[n]) visited[n] = true;
            else {
                isOk = false;
                break;
            }
        }

        return isOk;
    }

    static boolean verCheck(int c) {
        boolean isOk = true;
        boolean[] visited = new boolean[10];
        for (int r = 0; r < 9; r++) {
            if (grid[r][c] == 0) continue;
            if (!visited[grid[r][c]]) visited[grid[r][c]] = true;
            else {
                isOk = false;
                break;
            }
        }

        return isOk;
    }

    static boolean squareCheck(int r, int c) {
        boolean isOk = true;
        boolean[] visited = new boolean[10];

        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startR+i][startC+j] == 0) continue;
                if (!visited[grid[startR+i][startC+j]]) visited[grid[startR+i][startC+j]] = true;
                else {
                    isOk = false;
                    break;
                }
            }
            if (!isOk) break;
        }

        return isOk;
    }
}
