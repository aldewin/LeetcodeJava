package easy;

/**
 * 168. Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title/
 */

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }

    // Time complexity: O(logn), Space complexity: O(n)
    public static String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append((char) (--n % 26 + 'A'));
            n /= 26;
        }
        ans.reverse();
        return ans.toString();
    }
}
