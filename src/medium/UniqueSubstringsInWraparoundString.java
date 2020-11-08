package medium;

/**
 * 467. Unique Substrings in Wraparound String
 *
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 */

public class UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
    }

    public static int findSubstringInWraproundString(String p) {
        if (p.length() == 0)
            return 0;

        int[] count = new int[26];
        int sum = 1;
        int ans = 0;
        count[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25) {
                sum++;
            } else {
                sum = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], sum);
        }
        for (int value : count) {
            ans += value;
        }
        return ans;
    }
}
