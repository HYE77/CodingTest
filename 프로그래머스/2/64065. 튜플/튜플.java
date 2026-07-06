import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<int[]> list = new ArrayList<>();

        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("\\},\\{");

        for (String set : sets) {
            String[] nums = set.split(",");
            int[] arr = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }

            list.add(arr);
        }

        list.sort((a, b) -> Integer.compare(a.length, b.length));

        List<Integer> answer = new ArrayList<>();

        for (int[] arr : list) {
            for (int num : arr) {
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}