class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int count;
    static int answer;

    public int solution(String word) {
        count = 0;
        answer = 0;

        dfs("", word);

        return answer;
    }

    private void dfs(String current, String target) {
        if (current.length() > 5) {
            return;
        }

        if (!current.equals("")) {
            count++;

            if (current.equals(target)) {
                answer = count;
                return;
            }
        }

        for (char vowel : vowels) {
            dfs(current + vowel, target);
        }
    }
}