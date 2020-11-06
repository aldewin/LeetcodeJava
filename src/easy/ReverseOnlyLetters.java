package easy;

/**
 * 917. Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/submissions/
 */

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters1("ab-bc"));
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <=  'Z');
    }

    // Runtime: 1 ms, Memory: 39.3 MB
    public static String reverseOnlyLetters1(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length() - 1;
        while (true) {
            while (i < j && !isLetter(sb.charAt(i)))
                i++;
            while (i < j && !isLetter(sb.charAt(j)))
                j--;
            if (i < j) {
                char swap = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, swap);
                i++;
                j--;
            } else break;
        }
        return String.valueOf(sb);
    }

    // Runtime: 1 ms, Memory: 39.2 MB
    public static String reverseOnlyLetters2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (!isLetter(sb.charAt(i)))
                continue;
            while (!isLetter(sb.charAt(count)))
                count--;
            sb.setCharAt(count, s.charAt(i));
            count--;
        }
        return String.valueOf(sb);
    }
}
