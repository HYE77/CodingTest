import java.util.*;

class Solution {
    boolean[] isPrime;
    boolean[] visited;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // 최대 7자리까지 가능하므로 0 ~ 9,999,999
        isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i * i < 10000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        char[] arr = numbers.toCharArray();
        visited = new boolean[arr.length];

        makeNumber(arr, "");

        for (int num : set) {
            if (isPrime[num]) {
                answer++;
            }
        }

        return answer;
    }

    void makeNumber(char[] arr, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumber(arr, current + arr[i]);
                visited[i] = false;
            }
        }
    }
}