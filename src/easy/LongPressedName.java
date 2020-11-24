package easy;

/**
 * 925. Long Pressed Name
 *
 * https://leetcode.com/problems/long-pressed-name/
 */

public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
    }

    //Runtime: O(name + typed), Memory: O(1)
    public static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed))
            return true;
        int iName = 0;
        int typedLength = typed.length();
        int nameLength = name.length();
        for (int i = 0; i < typedLength; i++) {
            if (name.charAt(iName) != typed.charAt(i) && (i == 0 || typed.charAt(i) != typed.charAt(i - 1)))
                return false;
            if (name.charAt(iName) == typed.charAt(i) && iName != nameLength - 1)
                iName++;
        }
        return name.charAt(iName) == typed.charAt(typed.length() - 1);
    }
}
