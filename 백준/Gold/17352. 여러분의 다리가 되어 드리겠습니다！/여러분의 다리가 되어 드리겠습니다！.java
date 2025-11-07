import java.util.*;
import java.io.*;
  
public class Main {
	
	static int N;
	static List<int[]> edges;
	static int[] parent;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine()); // 섬의 개수
        
        edges = new ArrayList<>();
        for (int i = 0; i < N-2; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	edges.add(new int[] {from, to});
        }
        
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
        }
        
        // Union Find
        for (int[] edge : edges) {
        	
        	int xParent = findParent(edge[0]);
        	int yParent = findParent(edge[1]);
        	
        	if (xParent != yParent) parent[xParent] = yParent;
        }
        
        Set<Integer> pSet = new HashSet<>();
        for (int i = 1; i <= N; i++) {
        	pSet.add(findParent(i));
        }
        
        System.out.println(pSet.toArray()[0] + " " + pSet.toArray()[1]);
         
        br.close();
    }
    
    
    static int findParent(int x) {
    	if (parent[x] != x) parent[x] = findParent(parent[x]);
    	return parent[x];
    }
}