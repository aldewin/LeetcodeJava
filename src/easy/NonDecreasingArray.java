package easy;

/**
 * 665. Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/
 */

public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[] {4, 2, 3}));
    }

    // Time complexity: O(n), Space complexity: O(1)
    public static boolean checkPossibility(int[] nums) {
        int border = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                border = i;
                break;
            }
        }
        if (border == -1)
            return true;
        for (int i = border + 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        if (border == 0 || border == nums.length - 2)
            return true;
        return nums[border - 1] <= nums[border + 1] || nums[border] <= nums[border + 2];
    }
}
