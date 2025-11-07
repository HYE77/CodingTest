import java.util.*;
import java.io.*;
  
public class Main {
	
	static int N, ans;
	static int[] arr;
	static int[] original;
//	static List<Integer> arr;
	static boolean[] visited;
	static int[] selected;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        original = new int[N];
        arr = new int[N];
//        arr = new ArrayList<>();
        selected = new int[N-2];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	original[i] = Integer.parseInt(st.nextToken());
        	arr[i] = original[i];
//        	arr.add(original[i]);
        }
        
        perm(0);        
         
        System.out.println(ans);
        br.close();
    }
    
    
    static void perm(int sIdx) {
    	
    	if (sIdx == N-2) {
    		calc();
    		return;
    	}
    	
    	for (int i = 1; i < N-1; i++) {
    		if (!visited[i]) {
    			selected[sIdx] = i;
    			visited[i] = true;
    			perm(sIdx+1);
    			visited[i] = false;
    		}
    	}
    }
    
    static void calc() {
    	
    	int score = 0;
    	
    	for (int n : selected) {
    		int leftIdx = n-1;
    		int rightIdx = n+1;
    		
    		while (arr[leftIdx] < 0) leftIdx--;
    		while (arr[rightIdx] < 0) rightIdx++;
    		
    		score += original[leftIdx] * original[rightIdx];
    		
    		arr[n] = -1; // 터트리기
    	}
    	
    	// 원상복귀
    	for (int n : selected) {
    		arr[n] = original[n];
    	}    	
    	
    	ans = Math.max(ans, score);
    }
}