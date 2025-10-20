import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] dish = br.readLine().toCharArray();
        int h = 0;
        
        char prev = dish[0];
        h += 10;
        for (int i = 1; i < dish.length; i++) {
        	if (dish[i] == prev) h += 5;
        	else h += 10;
        	prev = dish[i];
        }
        
        System.out.println(h);
        br.close();
    }
}
