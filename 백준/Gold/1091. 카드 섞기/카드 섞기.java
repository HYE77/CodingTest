import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N]; // 각 카드가 누구에게 가야 하는지
        int[] S = new int[N]; // 카드 섞는 방법
        
        // P 배열 채우기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	P[i] = Integer.parseInt(st.nextToken());
        }
        
        // S 배열 채우기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	S[i] = Integer.parseInt(st.nextToken());
        }
        
        // 초기 카드 상태
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
        	cards[i] = i % 3; // 0 1 2 0 1 2 ...
        }
        
        int cnt = 0;
        int[] temp = Arrays.copyOf(cards, N);
        int[] tmp2 = new int[N];
        
        while (true) {
        	// target 배열과 같은지 확인
        	if (Arrays.equals(temp, P)) break;
        	
        	// 섞기
        	for (int idx = 0; idx < N; idx++) {
        		tmp2[idx] = temp[S[idx]];
        	}
        	temp = Arrays.copyOf(tmp2, tmp2.length);
        	cnt++;
        	
        	if (Arrays.equals(temp, cards)) {
        		cnt = -1;
        		break;
        	};
        	
        }
        
        System.out.println(cnt);
        br.close();
    }
    
}
