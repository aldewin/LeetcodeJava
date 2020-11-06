package easy;

/**
 * 125. Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome1("abba"));
        System.out.println(isPalindrome2("abcd"));
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <=  'Z') || (c >= '0' && c <= '9');
    }

    // Runtime :2 ms, Memory: 39.7 MB
    public static boolean isPalindrome1(String s) {
        if (s.length() == 0)
            return true;
        char[] word = s.toLowerCase().toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (true) {
            while (i < j && !isLetter(word[i]))
                i++;
            while (i < j && !isLetter(word[j]))
                j--;
            if (i < j) {
                if (word[i] != word[j])
                    return false;
                i++;
                j--;
            } else return true;
        }
    }

    // Runtime: 3 ms, Memory: 39.3 MB
    public static boolean isPalindrome2(String s) {
        if (s.length() == 0)
            return true;
        char[] word = s.toLowerCase().toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (true) {
            while (i < j && !Character.isLetter(word[i]) && !Character.isDigit(word[i]))
                i++;
            while (i < j && !Character.isLetter(word[j]) && !Character.isDigit(word[j]))
                j--;
            if (i < j) {
                if (word[i] != word[j])
                    return false;
                i++;
                j--;
            } else return true;
        }
    }
}
