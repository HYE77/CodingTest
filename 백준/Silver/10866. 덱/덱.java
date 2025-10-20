import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
        	
        	st = new StringTokenizer(br.readLine());
        	int num = 0;
        	String cmd = st.nextToken();
        	if (st.hasMoreTokens()) {
        		num = Integer.parseInt(st.nextToken());
        	}
        	
        	switch (cmd) {
        	case "push_front" :
        		deq.addFirst(num);
        		break;
        	case "push_back" :
        		deq.addLast(num);
        		break;
        	case "pop_front" :
        		sb.append(deq.isEmpty() ? -1 : deq.pollFirst()).append('\n');
        		break;
        	case "pop_back" :
        		sb.append(deq.isEmpty() ? -1 : deq.pollLast()).append('\n');
        		break;
        	case "size" :
        		sb.append(deq.size()).append('\n');
        		break;
        	case "empty" :
        		sb.append(deq.isEmpty() ? 1 : 0).append('\n');
        		break;
        	case "front" :
        		sb.append(deq.isEmpty() ? -1 : deq.peekFirst()).append('\n');
        		break;
        	case "back" :
        		sb.append(deq.isEmpty() ? -1 : deq.peekLast()).append('\n');
        		break;
        	}
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}
