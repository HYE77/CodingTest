class Solution {
    public int solution(int n) {
        int ones = Integer.bitCount(n);

        n++;
        while (true) {
            if (Integer.bitCount(n) == ones) {
                return n;
            }
            n++;
        }
    }
}