package medium;

/**
 * 377. Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/
 */

public class CombinationSumIV {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[] {2, 4}, 5));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (i - num >= 0)
                    ways[i] += ways[i - num];
            }
        }
        return ways[target];
    }
}

