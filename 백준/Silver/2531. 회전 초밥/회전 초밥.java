import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가지 수
        int k = Integer.parseInt(st.nextToken()); // 연속 몇 접시?
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	lst.add(Integer.parseInt(br.readLine()));
        }
        
        int maxCnt = 0;
        
        // 초기 세팅
        Deque<Integer> tmp = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
        	tmp.add(lst.get(i));
        }
        
        Set<Integer> set = new HashSet<>();
        
        // 탐색
        for (int start = 1; start <= N; start++) {
        	// 이전 가짓수 계산해보기
        	set.clear();
        	set.addAll(tmp);
        	set.add(c);
        	maxCnt = Math.max(maxCnt, set.size());
        	
        	// 다음 tmp 만들기
        	tmp.pollFirst();
        	tmp.add(lst.get((start + k - 1) % N));
        }
        
        bw.write(maxCnt+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
}
