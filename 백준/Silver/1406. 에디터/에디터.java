import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] input = br.readLine().toCharArray();
        LinkedList<String> lst = new LinkedList<>();
        ListIterator<String> iter = lst.listIterator();
        
        for (char c : input) iter.add(c+"");
        
        int n = Integer.parseInt(br.readLine());
        
//        int cursur = lst.size()-1;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	String cmd = st.nextToken();
        	
        	String c = " ";
        	if (st.hasMoreTokens()) c = st.nextToken();
        	
        	switch (cmd) {
        	case "L" :
        		if (iter.hasPrevious()) iter.previous();
        		break;
        	case "D" :
        		if (iter.hasNext()) iter.next();
        		break;
        	case "B" :
        		if (iter.hasPrevious()) {
        			iter.previous();
        			iter.remove();
        		}
        		break;
        	case "P" :
        		iter.add(c);
        		break;
        	}
        }
        
        for (String s : lst) sb.append(s);
        
        System.out.println(sb.toString());
        br.close();
    }
}
