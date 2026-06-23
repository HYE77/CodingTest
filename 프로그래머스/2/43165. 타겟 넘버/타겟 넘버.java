class Solution {
    
    static int cnt = 0;
    static int size;
    
    public int solution(int[] numbers, int target) {
        
        cnt = 0;
        size = numbers.length;
        
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
    
    static void dfs(int[] numbers, int target, int idx, int sum) {
        
        if (idx == size) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}