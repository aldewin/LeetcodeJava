package easy;

/**
 * 989. Add to Array-Form of Integer
 *
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayFormInteger {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[] {1, 2, 0, 0}, 34));
    }

    public static List<Integer> addToArrayForm(int[] a, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = a.length - 1;
        while (n >= 0 || k > 0) {
            if (n >= 0)
                k += a[n];
            ans.add(k % 10);
            n--;
            k /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
