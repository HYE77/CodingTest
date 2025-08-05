import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger N = new BigInteger(sc.next());
		BigInteger M = new BigInteger(sc.next());

		BigInteger gap = N.subtract(M).abs();

		System.out.println(gap);
	}

}