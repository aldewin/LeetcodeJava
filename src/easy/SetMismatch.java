package easy;

/**
 * 645. Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch/
 */

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums1(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums2(new int[]{3, 2, 2})));
    }

    // Time complexity: O(n), Space complexity: O(1)
    public static int[] findErrorNums1(int[] nums) {
        int ans = 0;
        for (int i: nums) {
            if (nums[Math.abs(i) - 1] < 0)
                ans = Math.abs(i);
            else
                nums[Math.abs(i) - 1] *= -1;
        }
        int missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing  = i + 1;
        }
        return new int[] {ans, missing};
    }

    // Time complexity: O(n), Space complexity: O(1)
    public static int[] findErrorNums2(int[] nums) {
        int ans = 0;
        for (int i: nums) {
            if (nums[Math.abs(i) - 1] < 0)
                ans = Math.abs(i);
            else
                nums[Math.abs(i) - 1] *= -1;
        }
        int missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing  = i + 1;
        }
        return new int[] {ans, missing};
    }
}
