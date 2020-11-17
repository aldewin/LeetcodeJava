package easy;

/**
 * 844. Backspace String Compare
 *
 * https://leetcode.com/problems/backspace-string-compare/
 */

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ad#c", "ab#c"));
    }

    public static boolean backspaceCompare(String s, String t) {
        int j = t.length() - 1;
        int countJ = 0;
        int i = s.length() - 1;
        int countI = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    countI++;
                    i--;
                } else if (countI != 0) {
                    i--;
                    countI--;
                } else break;
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    j--;
                    countJ++;
                } else if (countJ != 0) {
                    j--;
                    countJ--;
                } else break;
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            if ((i >= 0 && j < 0) || (j >= 0 && i < 0))
                return false;

            i--;
            j--;
        }
        return true;
    }
}
