package easy;

/**
 * 413. Arithmetic Slices
 *
 * https://leetcode.com/problems/arithmetic-slices/
 */

public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices1(new int[] {1, 2, 3}));
        System.out.println(numberOfArithmeticSlices2(new int[] {1, 2, 3, 4}));
    }

    // Runtime: 0 ms, Memory: 36.5 MB
    public static int numberOfArithmeticSlices1(int[] a) {
        if (a.length < 3)
            return 0;

        int ans = 0;
        for (int i = 0; i < a.length - 2; i++) {
            int dif = a[i + 1] - a[i];
            for (int j = i + 2; j < a.length; j++) {
                if (a[j] - a[j - 1] == dif) {
                    ans += 1;
                } else break;
            }
        }
        return ans;
    }

    // Runtime: 0 ms, Memory: 36.9 MB
    public static int numberOfArithmeticSlices2(int[] a) {
        int ans = 0;
        int count = 0;
        int dif = a[1] - a[0];
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i - 1] == dif) {
                count += 1;
                ans += count;
            } else {
                dif = a[i] - a[i - 1];
                count = 0;
            }
        }
        return ans;
    }
}
