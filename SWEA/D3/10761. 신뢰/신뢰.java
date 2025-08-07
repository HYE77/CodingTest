import java.io.*;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t < T + 1; ++t) {
        	
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 태스크 개수
            
            int bTime = 0, oTime = 0, bPos = 1, oPos = 1; // 소요 시간, 현재 위치
            
            for (int i = 0; i < N; ++i) {
            	
                String s = st.nextToken(); // 어떤 로봇?
                int n = Integer.parseInt(st.nextToken()); // 몇 번 버튼?
                
                if (s.equals("B")) { // B로봇
                    bTime += Math.abs(n - bPos); // 이동하는 시간
                    bPos = n; // 현재 위치
                    if (bTime < oTime) { // O가 앞서서 수행했을 때 걸린 시간보다 덜 걸렸다면 기다려야 함
                        bTime = oTime;
                    }
                    bTime++; // 버튼 누르는 시간
                } else { // O로봇
                    oTime += Math.abs(n - oPos); // 이동하는 시간
                    oPos = n; // 현재 위치
                    if (oTime < bTime) { // B가 앞서서 수행했을 때 걸린 시간보다 덜 걸렸다면 기다려야 함
                        oTime = bTime;
                    }
                    oTime++; // 버튼 누르는 시간
                }
            }
            
            sb.append("#").append(t).append(" ").append(Math.max(bTime, oTime)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}