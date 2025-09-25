import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	
        	String func = br.readLine(); // 함수
        	int N = Integer.parseInt(br.readLine()); // 배열 길이
        	String input = br.readLine();
        	String input2 = input.substring(1, input.length()-1);
        	String[] arr = input2.split(",");
        	Deque<String> deq = new ArrayDeque<>();
        	if (N > 0) {
        		for (String s : arr) {
        			deq.add(s);
        		}        		
        	}
        	
        	boolean error = false;
        	boolean reversed = false;
        	for (int i = 0; i < func.length(); i++) {
        		char cmd = func.charAt(i);
        		
        		switch(cmd) {
        		case 'R':
        			reversed = reversed? false : true;
        			break;
        		case 'D':
        			if (deq.isEmpty()) {
        				error = true;
        				break;
        			}
        			if (!reversed) deq.pollFirst();
        			else deq.pollLast();
        			break;
        		}
        	}
        	
        	if (error) sb.append("error\n");
        	else if (deq.isEmpty()) sb.append("[]\n");
        	else {
        		sb.append("[");
        		
        		if (reversed) sb.append(deq.pollLast());
        		else sb.append(deq.pollFirst());
        		
        		while (!deq.isEmpty()) {
        			if (reversed) sb.append(",").append(deq.pollLast());
        			else sb.append(",").append(deq.pollFirst());
        		}
        		sb.append("]\n");
        	}
        	
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
