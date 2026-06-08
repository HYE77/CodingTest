import java.util.*;

class Solution {

    public class Genre implements Comparable<Genre> {
        String genre;
        int totalPlay;
        List<Song> songList;

        public Genre(String genre) {
            this.genre = genre;
            this.totalPlay = 0;
            this.songList = new ArrayList<>();
        }

        @Override
        public int compareTo(Genre o) {
            return o.totalPlay - this.totalPlay;
        }
    }

    public class Song implements Comparable<Song> {
        int idx;
        int play;

        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return this.play == o.play ? this.idx - o.idx : o.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        List<Integer> ansList = new ArrayList<>();

        Map<String, Genre> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i], new Genre(genres[i]));

            map.get(genres[i]).songList.add(new Song(i, plays[i]));
            map.get(genres[i]).totalPlay += plays[i];
        }

        List<Genre> genreList = new ArrayList<>();
        for (String key : map.keySet()) {
            genreList.add(map.get(key));
        }

        Collections.sort(genreList);

        for (Genre gen : genreList) {
            Collections.sort(gen.songList);
            ansList.add(gen.songList.get(0).idx);
            if (gen.songList.size() > 1) ansList.add(gen.songList.get(1).idx);
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}