import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 2^n - 1 계산
        BigInteger moves = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.print(output);
        }
    }

    public static void hanoi(int num, int from, int via, int to) {
        if (num == 1) {
            output.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(num - 1, from, to, via);
        output.append(from).append(" ").append(to).append("\n");
        hanoi(num - 1, via, from, to);
    }
}
