import java.util.*;
import java.io.*;
 
public class Solution {
     
    static List<Integer>[] adj;
    static boolean[] visited;
    
    static class Node{
    	int i, seq;

		public Node(int i, int seq) {
			this.i = i;
			this.seq = seq;
		}
   	
    }

 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = 10;
         
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken()); // 입력 데이터 수 (관계 수 * 2) 
        	int start = Integer.parseInt(st.nextToken()); // 시작점
        	
        	// 초기화
        	visited = new boolean[101]; // 1~100
        	adj = new ArrayList[101]; // 1~100 인접리스트
        	for (int i = 0; i < 101; i++) {
        		adj[i] = new ArrayList<>();
        	}
        	
        	// 관계 저장하기
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N/2; i++) {
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		adj[from].add(to);
        	}
        	
        	// 관계 탐색
        	visited = new boolean[101];
        	
        	Queue<Node> pq = new LinkedList<>();
        	pq.add(new Node(start, 0));
        	int maxLevel = 0;
        	int maxNode = start;
        	
        	while (!pq.isEmpty()) {
        		Node curr = pq.poll();
        		
        		if (visited[curr.i]) continue;
        		visited[curr.i] = true;

        		if (curr.seq > maxLevel) {
                    maxLevel = curr.seq;
                    maxNode = curr.i;
                } else if (curr.seq == maxLevel) {
                    maxNode = Math.max(maxNode, curr.i);
                }
        		
        		for (int p : adj[curr.i]) {
        			if (!visited[p]) {
        				pq.add(new Node(p, curr.seq+1));
        			}
        		}
        		
        	}
        	
        	int answer = maxNode;
        	
        	bw.write("#" + t + " " + answer +"\n");
        	
        }
           
 
         
        bw.flush();
        br.close();
        bw.close();
         
    }


     
 
}