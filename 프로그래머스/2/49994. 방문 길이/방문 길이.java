import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;

        Set<String> visited = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            switch (dir) {
                case 'U':
                    ny++;
                    break;
                case 'D':
                    ny--;
                    break;
                case 'L':
                    nx--;
                    break;
                case 'R':
                    nx++;
                    break;
            }

            // 좌표 범위를 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 양방향 모두 저장
            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;

            visited.add(path1);
            visited.add(path2);

            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }
}