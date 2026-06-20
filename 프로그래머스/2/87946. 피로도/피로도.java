class Solution {
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        perm(k, dungeons, visited, 0);
        return answer;
    }

    static void perm(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                perm(fatigue - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}