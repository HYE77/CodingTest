import java.util.*;

class Solution {

    static class Node {
        String word;
        int cnt;

        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.word.equals(target)) {
                answer = cur.cnt;
                break;
            }

            // i번째 문자 교체
            for (int i = 0; i < cur.word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String tmp = cur.word.substring(0, i) + chars[j] + cur.word.substring(i+1);
                    for (int k = 0; k < words.length; k++) {
                        if (words[k].equals(tmp) && !visited[k]) {
                            q.add(new Node(tmp, cur.cnt+1));
                            visited[k] = true;
                        }
                    }
                }
            }
        }

        return answer;

    }
}