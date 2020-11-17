package medium;

/**
 * 376. Wiggle Subsequence
 *
 * https://leetcode.com/problems/wiggle-subsequence/
 */

public class WiggleSubsequence {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[] {1, 7, 4, 9 ,2, 5}));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;

        int ans = 1;
        boolean next = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && (ans == 1 || next)) {
                ans += 1;
                next = false;
            } else if (nums[i] < nums[i - 1] && (ans == 1 || !next)) {
                ans += 1;
                next = true;
            }
        }
        return ans;
    }
}
