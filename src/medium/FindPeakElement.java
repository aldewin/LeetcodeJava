package medium;

/**
 * 162. Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/
 */

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeekElement(new int[] {1, 2, 1, 3, 5, 6, 4}));
    }

    public static int findPeekElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
