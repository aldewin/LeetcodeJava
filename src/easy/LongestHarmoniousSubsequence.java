package easy;

/**
 * 594. Longest Harmonious Subsequence
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(findLHS1(new int[] {1, 2, 3, 4}));
        System.out.println(findHLS2(new int[] {1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(findHLS3(new int[] {1, 1, 1, 1}));
    }

    // Runtime: 20 ms, Memory: 40.3 MB
    public static int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean t = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
                else if (nums[j] - nums[i] == 1) {
                    count++;
                    t = true;
                } else break;
            }
            if (t)
                res = Math.max(res, count);
        }
        return res;
    }

    // Runtime: 10 ms, Memory: 40.4 MB
    public static int findHLS2(int[] nums) {
        Arrays.sort(nums);
        int lastSize = 0; int lastValue = 0;
        int curSize = 0; int curValue = 0;
        int res = 0;
        for (int num : nums) {
            if (num == curValue)
                curSize++;
            else {
                lastSize = curSize;
                lastValue = curValue;
                curSize = 1;
                curValue = num;
            }
            if (lastSize > 0 && lastValue + 1 == curValue)
                res = Math.max(res, lastSize  + curSize);
        }
        return res;
    }

    // Runtime: 16 ms, Memory: 40 MB
    public static int findHLS3(int[] nums) {
        Map<Integer, Integer> countNumber = new HashMap<>();
        for (int num : nums)
            countNumber.put(num, countNumber.getOrDefault(num, 0) + 1);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countNumber.entrySet()) {
            int min = entry.getKey();
            int max = min + 1;
            if (countNumber.containsKey(max)) {
                res = Math.max(res, countNumber.get(min) + countNumber.get(max));
            }
        }
        return res;
    }
}
