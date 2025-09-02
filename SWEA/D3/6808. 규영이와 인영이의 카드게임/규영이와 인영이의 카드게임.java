import java.io.*;
import java.util.*;

public class Solution {
	
	static final ArrayList<Integer> allCards = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
	static ArrayList<Integer> myCards; // 규영
	static ArrayList<Integer> herCards; // 인영
	static int winCnt, myScore, herScore;
	static final int TOTAL = 9*8*7*6*5*4*3*2;
	static int[] result;
	static boolean[] used = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	
        	myCards = new ArrayList<>();
        	for (int i = 0; i < 9; i++) {
        		myCards.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	herCards = new ArrayList<>(allCards);
        	herCards.removeAll(myCards);
        	
        	result = new int[9];
        	winCnt = 0;
        	
        	perm(0);
        	
        	System.out.println("#" + t + " " + winCnt + " " + (TOTAL-winCnt));
        	
        }
      
        
        br.close();
   
        
    }
    
    static void perm(int idx) {
    	if (idx == 9) {
    		myScore = herScore = 0;
    		// 점수 비교
    		for (int i = 0; i < 9; i++) {
    			if (myCards.get(i) > result[i]) myScore += myCards.get(i) + result[i];
    			else herScore += myCards.get(i) + result[i];
    		}
    		
    		if (myScore > herScore) winCnt++;
    		
    		return;
    	}
    	
    	
    	for (int i = 0; i < 9; i++) {
    		if (used[i]) continue; // 이미 방문했으면 pass
    		
    		// 아직 이 카드 사용 안 했다면
    		result[idx] = herCards.get(i);
    		used[i] = true;
    		perm(idx+1);
    		used[i] = false;
    	}
    }
 
   
    
}
