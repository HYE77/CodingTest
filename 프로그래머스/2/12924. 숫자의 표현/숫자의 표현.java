class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int cnt = 1; cnt <= n; cnt++) {
            int remain = n - cnt * (cnt - 1) / 2;
            
            if (remain <= 0) break;
            
            if (remain % cnt == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}