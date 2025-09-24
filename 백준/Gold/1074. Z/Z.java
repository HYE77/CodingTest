import java.util.*;
import java.io.*;

public class Main {
	
	static int N, r, c;
	static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    
        conquer(0, 0, N);
        
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void conquer(int row, int col, int size) {
        if (size == 1) return; // 마지막 칸에 도달했으면 끝

        int half = size / 2;
        int area = half * half;

        if (r < row + half && c < col + half) { // 왼쪽 위
        	conquer(row, col, half);
        } else if (r < row + half && c >= col + half) { // 오른쪽 위
            answer += area;
            conquer(row, col + half, half);
        } else if (r >= row + half && c < col + half) { // 왼쪽 아래
            answer += area * 2;
            conquer(row + half, col, half);
        } else { // 오른쪽 아래
            answer += area * 3;
            conquer(row + half, col + half, half);
        }
    }
}
