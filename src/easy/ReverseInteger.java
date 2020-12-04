package easy;

/**
 * 7. Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse( -2147483647));
    }

    public static int reverse(int x) {
        int ans = 0;
        int sign = 1;
        if (x < 0) {
            x = -x;
            sign = -1;
        }
        while (x != 0) {
            int peek = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && peek > 7))
                return 0;
            ans = ans * 10 + peek;
            x /= 10;
        }
        return ans * sign;
    }
}
