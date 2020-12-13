package easy;

/**
 * 278. First Bad Version
 *
 * https://leetcode.com/problems/first-bad-version/
 */

public class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
  boolean isBadVersion(int version); */

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    // Time complexity: O(logn),  Space complexity: O(1)
    public static int firstBadVersion(int n) {
        int good = 0;
        int bad = n;
        while (bad > good + 1) {
            int mid = good + (bad - good) / 2;
            if (isBadVersion(mid))
                bad = mid;
            else
                good = mid;
        }
        return bad;
    }

    private static boolean isBadVersion(int n) {
        return true;
    }
}
