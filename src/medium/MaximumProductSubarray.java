package medium;

/**
 * Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 */

public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {-1, 2, 3}));
    }

    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int p = 0;

        for (int num : nums) {
            if (p == 0)
                p = num;
            else
                p *= num;

            res = Math.max(p, res);
        }

        p = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (p == 0)
                p = nums[i];
            else
                p *= nums[i];

            res = Math.max(res, p);
        }

        return res;
    }
}
