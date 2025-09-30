import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] stats;
	static Set<Integer> team1, team2;
	static boolean[] visited;
	static int minGap = Integer.MAX_VALUE;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        visited = new boolean[N];
        team1 = new HashSet<>();
        
        // stats 배열 만들기 
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		stats[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        makeTeam(0);
        
        bw.write(minGap+"");
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void makeTeam(int idx) {
    	// 팀 다 짰으면
    	if (team1.size() == N/2) {
    		minGap = Math.min(minGap, calcGap(team1));
    		return;
    	}

    	
    	// 팀 짜기
    	for (int i = idx; i < N; i++) {
    		if (visited[i]) continue;
    		
    		team1.add(i);
    		visited[i] = true;
    		makeTeam(i);
    		team1.remove(i);
    		visited[i] = false;
    	}
    }
    
    static int calcGap(Set<Integer> team1) {
    	// team2 짜기
    	team2 = new HashSet<>();
    	
    	for (int i = 0; i < N; i++) {
    		if (!team1.contains(i)) team2.add(i);
    	}
    	
    	int stat1 = 0, stat2 = 0;
    	
    	// team1 stat 구하기
    	for (int n : team1) {
    		for (int m : team1) {
    			if (n != m) stat1 += stats[n][m];
    		}
    	}
    	
    	// team2 stat 구하기
    	for (int n : team2) {
    		for (int m : team2) {
    			if (n != m) stat2 += stats[n][m];
    		}
    	}
    	
    	return Math.abs(stat1 - stat2);
    }
}
