package easy;

/**
 * 888. Fair Candy Swap
 *
 * https://leetcode.com/problems/fair-candy-swap/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap1(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(fairCandySwap2(new int[]{2}, new int[]{1, 3})));
    }

    // Runtime: 202 ms, Memory: 40.5 MB
    public static int[] fairCandySwap1(int[] a, int[] b) {
        int sum1 = 0;
        for (int value : a) sum1 += value;
        int sum2 = 0;
        for (int value : b) sum2 += value;
        int delta = (sum1 - sum2) / 2;
        for (int value : a) {
            for (int i : b) {
                if (value - i == delta) {
                    return new int[]{value, i};
                }
            }
        }
        return new int[]{};
    }

    // Runtime: 7 ms, Memory: 40.9 MB
    public static int[] fairCandySwap2(int[] a, int[] b) {
        int sum1 = 0;
        for (int value : a) sum1 += value;
        int sum2 = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int value : b) {
            set2.add(value);
            sum2 += value;
        }
        int delta = (sum1 - sum2) / 2;
        for (int aValue : a) {
            int bValue = aValue - delta;
            if (set2.contains(bValue))
                return new int[]{aValue, bValue};
        }
        return new int[]{};
    }
}
