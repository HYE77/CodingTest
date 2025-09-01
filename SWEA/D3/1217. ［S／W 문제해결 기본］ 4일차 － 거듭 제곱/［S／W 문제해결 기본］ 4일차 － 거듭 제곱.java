
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int t = 1; t <= 10; t++) {
        	sc.nextInt();
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	System.out.println("#" + t + " " + power(N, M));
        	
        }


        sc.close();
    }
    
    
    public static int power(int N, int M) {
    	if (M == 0) return 1;
    	
    	int tmp = power(N, M/2);
    	if (M%2 == 0) return tmp  * tmp;
    	else return tmp * tmp * N;
 	
    }
    

}
