package easy;

/**
 * 172. Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
    }

    // Time complexity: O(log(n)), Space complexity: O(1)
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
