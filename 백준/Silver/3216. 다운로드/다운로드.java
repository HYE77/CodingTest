import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 
        int totalDtime = 0;
        int songTime = 0;
        int gap = 0;
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int len = Integer.parseInt(st.nextToken());
        	int dTime = Integer.parseInt(st.nextToken());
        	
        	if (gap + songTime < totalDtime + dTime) { // 노래가 시작하는 시간이 다운로드가 끝나는 시점보다 이르다면
        		gap += (totalDtime + dTime) - (gap + songTime);
        	}
        	totalDtime += dTime;
        	songTime += len;
        	
        }
        
        System.out.println(gap);
        br.close();
    }
}
