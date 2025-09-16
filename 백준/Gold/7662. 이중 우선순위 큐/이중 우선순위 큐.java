import java.util.*;
import java.io.*;

public class Main {
	
	static TreeMap<Integer, Integer> map;
	static PriorityQueue<Integer> minheap;
	static PriorityQueue<Integer> maxheap;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	map = new TreeMap<>();
        	minheap = new PriorityQueue<>();
        	maxheap = new PriorityQueue<>(Collections.reverseOrder());
        	
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		String cmd = st.nextToken();
        		int num = Integer.parseInt(st.nextToken());
        		
        		if (cmd.equals("I")) {
        			minheap.add(num);
        			maxheap.add(num);
        			map.put(num, map.getOrDefault(num, 0)+1);
        		}
        		else {
        			if (map.isEmpty()) continue;
        			
        			if (num == -1) {
        				while (!minheap.isEmpty() && !map.containsKey(minheap.peek())) {
        				    minheap.poll();
        				}
        				int tmp = minheap.poll();
        				delete(tmp);
        			}
        			else {
        				while (!maxheap.isEmpty() && !map.containsKey(maxheap.peek())) {
        				    maxheap.poll();
        				}
        				int tmp = maxheap.poll();
        				delete(tmp);
        			}
        		} 
        		
        	}
        	
        	Set<Integer> set = map.keySet();
        	
        	if (map.isEmpty()) bw.write("EMPTY\n");
        	else {
        		int min = map.firstKey();
        		int max = map.lastKey();

        		bw.write(max + " " + min + "\n");
        	}
        }
       
        
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void delete(int tmp) {
    	int cnt = map.getOrDefault(tmp, 0);
    	
    	if (cnt == 0) return;
    	else if (cnt == 1) map.remove(tmp);
    	else map.put(tmp, cnt-1);
    }
    
   

}

