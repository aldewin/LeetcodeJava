package easy;

/**
 * 852. Peak Index in a Mountain Array
 *
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray1(new int[] {0, 1, 0}));
        System.out.println(peakIndexInMountainArray2(new int[] {0, 2, 1, 0}));
    }

    // Runtime: 0 ms, Memory: 39.6 MB
    public static int peakIndexInMountainArray1(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return i;
            i++;
        }
        return 1;
    }

    // Runtime: 0 ms, Memory:  39.7 MB
    public static int peakIndexInMountainArray2(int[] arr) {
        // Двочиный поиск - сложность O(logn)
        int left = 0;
        int right = arr.length;
        while (right - left > 2) {
            int mid = left + (right - left) / 2;
            if (arr[mid + 1] > arr[mid])
                left = mid;
            else
                right = mid + 1;
        }
        return right - 1;
    }
}
