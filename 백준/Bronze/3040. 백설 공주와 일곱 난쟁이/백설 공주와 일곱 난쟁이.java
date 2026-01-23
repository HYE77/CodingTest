import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            total += nums[i];
        }

        int gap = total - 100;

        List<Integer> except = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nums[i] + nums[j] == gap) {
                    except.add(nums[i]);
                    except.add(nums[j]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!except.contains(nums[i])) System.out.println(nums[i]);
        }
    }
}
