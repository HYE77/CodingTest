import java.util.Scanner;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = new BigInteger(sc.next());
        BigInteger m = new BigInteger(sc.next());

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}