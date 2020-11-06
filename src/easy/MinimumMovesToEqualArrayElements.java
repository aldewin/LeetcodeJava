package easy;

/**
 * 453. Minimum Moves to Equal Array Elements
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {

    }

    // Runtime: 1 ms, Memory: 39.1 MB
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i: nums) {
            sum += i;
            if (i < min)
                min = i;
        }
        return sum - min * nums.length;
    }
}
