import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken()); // 행
        	int M = Integer.parseInt(st.nextToken()); // 열
        	
        	// 국기 입력받기기
        	char[][] flag = new char[N][M];
        	for (int n = 0; n < N; n++) {
        		flag[n] = br.readLine().toCharArray();
        	}
        	
        	// 경계 조합 별로 색칠하는 칸 개수 구하기
        	int MIN = Integer.MAX_VALUE;
        	
        	for (int i = 0; i <= N-3; i++) {
        		for (int j = i+1; j <= N-2; j++) {
        			int currSum = colorCheck(flag, i, j);
        			MIN = Math.min(currSum, MIN);
        		}
        	}
        	
        	// 결과 출력
        	bw.write("#" + t + " " + MIN + "\n");
        	
        }

       

        bw.flush();
        bw.close();
        br.close();
    }
    
    
    public static int colorCheck(char[][] flag, int white, int blue) {
    	int ans = 0;
    	
    	// 흰색 부분 탐색
    	for (int i = 0; i <= white; i++) {
    		for (char c : flag[i]) {
    			if (c != 'W') ans++;
    		}
    	}
    	// 파란 부분 탐색
    	for (int j = white+1; j <= blue; j++) {
    		for (char c : flag[j]) {
    			if (c != 'B') ans++;
    		}
    	}
    	// 빨간 부분 탐색
    	for (int k = blue+1; k < flag.length; k++) {
    		for (char c : flag[k]) {
    			if (c != 'R') ans++;
    		}
    	}
    	
    	
    	return ans;
    }

}
