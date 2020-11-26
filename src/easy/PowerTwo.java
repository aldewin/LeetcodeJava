package easy;

/**
 * 231. Power of Two
 *
 * https://leetcode.com/problems/power-of-two/
 */

public class PowerTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(64));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }
}
