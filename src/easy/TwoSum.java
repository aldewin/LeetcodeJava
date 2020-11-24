package easy;

/**
 * 1. Two Sum
 *
 * https://leetcode.com/problems/two-sum/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    // Runtime: O(n), Memory: O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (sum.containsKey(dif))
                return new int[] {sum.get(dif), i};
            sum.put(nums[i], i);
        }
        return new int[] {};
    }
}
