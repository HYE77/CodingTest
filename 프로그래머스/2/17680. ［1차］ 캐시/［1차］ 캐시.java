import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;

        List<String> cache = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            String orgn = cities[i];
            cities[i] = orgn.toLowerCase().trim();
        }

        // cache hit : 1, cache miss : 5
        for (String city : cities) {
            // cache hit
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else { // cache miss
                if (cache.isEmpty() || cache.size() < cacheSize) cache.add(city);
                else {
                    cache.removeFirst();
                    cache.add(city);
                }

                answer += 5;
            }
        }

        return answer;
    }
}