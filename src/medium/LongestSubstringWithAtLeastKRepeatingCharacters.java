package medium;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String s, int k) {
        int maxLength = 0;
        char[] word = s.toCharArray();
        for (int i = 0; i < word.length; i++) {
            int[] count = new int[26];
            int n1 = 0;
            int n2 = 0;
            for (int j = i; j < word.length; j++) {
                char c = word[j];
                int d = c - 'a';
                if (count[d] == 0)
                    n1++;
                count[d]++;
                if (count[d] == k)
                    n2++;
                if (n1 == n2) {
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }
}
