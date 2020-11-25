package easy;

/**
 * 53. Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    // Runtime: O(n), Memory: O(1)
    public static int maxSubArray(int[] nums) {
        int cur = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
