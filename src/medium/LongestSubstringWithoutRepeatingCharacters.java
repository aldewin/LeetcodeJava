package medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int right = 0;
        boolean[] used = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !used[s.charAt(right)]) {
                used[s.charAt(right)] = true;
                right++;
            }
            res = Math.max(res, right - i);
            used[s.charAt(i)] = false;
        }
        return res;
    }
}
