package easy;

/**
 * 922. Sort Array By Parity II
 *
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */

import java.util.Arrays;

public class SortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII1(new int[] {4, 2, 5, 7})));
        System.out.println(Arrays.toString(sortArrayByParityII3(new int[] {2, 3, 1, 1, 4, 0, 0, 4, 3, 3})));
    }

    // Runtime: 12 ms, Memory: 40.6 MB
    public static int[] sortArrayByParityII1(int[] a) {
        // Наивное решение
        // O(n^2) - по времени, O(1) по дополнительной памяти
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == a[i] % 2)
                continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] % 2 != a[j] % 2 && a[j] % 2 != j % 2) {
                    int swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                    break;
                }
            }
        }
        return a;
    }

    // Runtime: 2 ms, Memory: 42.2 MB
    public static int[] sortArrayByParityII2(int[] a) {
        // Наивное решение (in-place)
        // O(n) - по времени (быстрее уже не будет), O(n) по памяти
        int[] res = new int[a.length];
        int evenIdx = 0;
        int oddIdx = 1;
        for (int i = 0; i< a.length; i++) {
            if (a[i] % 2 == 0) {
                res[evenIdx] = a[i];
                evenIdx += 2;
            } else {
                res[oddIdx] = a[i];
                oddIdx += 2;
            }
        }
        return res;
    }

    // Runtime: 2 ms, Memory: 40.6 MB
    public static int[] sortArrayByParityII3(int[] a) {
        // Продвинутое решение (in-place)
        // O(n) - по времени, O(1) по памяти
        int i = a.length - 2;
        int j = a.length - 1;
        while (true) {
            while (i >= 0 && a[i] % 2 == 0)
                i -= 2;
            while (j >= 0 && a[j] % 2 != 0)
                j -= 2;
            if (i >= 0) {
                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
                i -= 2;
                j -= 2;
            } else break;
        }
        return a;
    }


}
