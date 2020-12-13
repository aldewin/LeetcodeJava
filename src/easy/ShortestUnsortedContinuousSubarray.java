package easy;

/**
 * 581. Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-con
 */

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(20);
    }

    // Time complexity: O(n), SpaceComplexity: O(1)
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                lastIndex = i;
        }
        if (lastIndex == -1)
            return 0;
        int min = Integer.MAX_VALUE;;
        int firstIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                firstIndex = i;
        }
        return lastIndex == firstIndex ? 0 : lastIndex - firstIndex + 1;
    }
}
