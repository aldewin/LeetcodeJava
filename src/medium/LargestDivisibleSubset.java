package medium;

/**
 * 368. Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[] {3, 4, 16, 8}));
    }

    //Runtime: 78 ms, Memory: 39.3 MB
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] len = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0)
                    len[i] = Math.max(len[i], len[j] + 1);
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (len[i] == maxLen && (ans.isEmpty() || ans.get(ans.size() - 1) % nums[i] == 0)) {
                ans.add(nums[i]);
                maxLen--;
            }
        }
        return ans;
    }
}
