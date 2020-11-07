package easy;

/**
 * 409. Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char i: s.toCharArray()) {
            count[i]++;
        }
        int ans = 0;
        for (int i: count) {
            ans += i / 2 * 2;
            if (ans % 2 == 0 && i % 2 != 0)
                ans++;
        }
        return ans;
    }
}
