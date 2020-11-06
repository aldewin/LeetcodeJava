package medium;

/**
 * 334. Increasing Triplet Subsequence
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {1, 2, 3, 4, 5}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        for (int i: nums) {
            if (i < max1)
                max1 = i;
            if (i > max1)
                max2 = Math.min(max2, i);
            if (i > max2)
                return true;
        }
        return false;
    }
}
