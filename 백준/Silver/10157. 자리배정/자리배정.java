import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 행
        int target = Integer.parseInt(br.readLine());

        if (target > C*R) {
            bw.write(0+"");
        } else {
            int[][] arr = new int[R][C];

            int r = R-1;
            int c = 0;
            arr[r][c] = 1;
            int i = 2;
            char dir = 'u';
            while (i <= target){
                switch (dir) {
                    case 'u':
                        if (r-1 >= 0  && arr[r-1][c] == 0) {
                            r--;
                            arr[r][c] = i;
                            i++;
                        } else {
                            dir = 'r';
                            c++;
                            arr[r][c] = i;
                            i++;
                        }
                        break;
                    case 'r':
                        if (c+1 < C && arr[r][c+1] == 0) {
                            c++;
                            arr[r][c] = i;
                            i++;
                        } else {
                            dir = 'd';
                            r++;
                            arr[r][c] = i;
                            i++;
                        }
                        break;

                    case 'd':
                        if (r+1 < R && arr[r+1][c] == 0) {
                            r++;
                            arr[r][c] = i;
                            i++;
                        } else {
                            dir = 'l';
                            c--;
                            arr[r][c] = i;
                            i++;
                        }
                        break;
                    case 'l':
                        if (c-1 >= 0 && arr[r][c-1] == 0) {
                            c--;
                            arr[r][c] = i;
                            i++;
                        } else {
                            dir = 'u';
                            r--;
                            arr[r][c] = i;
                            i++;
                        }
                        break;
                }
            }
            int ansC = c+1;
            int ansR = R-r;

            bw.write(ansC + " " + ansR);
        }


        bw.flush();
        br.close();
        bw.close();

    }

}
