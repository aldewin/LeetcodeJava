package easy;

/**
 * 696. Count Binary Substrings
 *
 * https://leetcode.com/problems/count-binary-substrings/
 */

public class CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings1("00110011"));
        System.out.println(countBinarySubstrings2("10101"));
    }

    // Runtime: 8 ms, 39.6 MB
    public static int countBinarySubstrings1(String s) {
        int[] group = new int[s.length()];
        int idx = 0;
        group[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i))
                group[++idx] = 1;
            else
                group[idx]++;
        }
        int res = 0;
        for (int i = 1; i <= idx; i++)
            res += Math.min(group[i - 1], group[i]);
        return res;
    }

    // Runtime: 9 ms, Memory: 39 MB
    public static int countBinarySubstrings2(String s) {
        int prev = 0;
        int curr = 1;
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else
                curr++;
        }
        return ans + Math.min(prev, curr);
    }
}
