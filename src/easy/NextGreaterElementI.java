package easy;

/**
 * 496. Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement1(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement2(new int[] {2, 4}, new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(nextGreaterElement3(new int[] {5, 6}, new int[] {5, 6, 7, 8})));
    }

    // Runtime: 10 ms, Memory: 39.4 MB
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            boolean search = false;
            int j = 0;
            while (j < len2) {
                if (search && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                } else if (nums1[i] == nums2[j])
                    search = true;
                j++;
            }
            if (j == len2)
                res[i] = -1;
        }
        return res;
    }

    // Runtime: 2 ms, Memory: 39.6 MB
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len2; i++)
            map.put(nums2[i], i);
        for (int i = 0; i < len1; i++) {
            int j = map.get(nums1[i]) + 1;
            while (j < len2) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                j++;
            }
            if (j == len2)
                res[i] = -1;
        }
        return res;
    }

    // Runtime: 3 ms, Memory: 39.4 MB
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums2[i] > stack.peek())
                stack.pop();
            if (stack.empty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            res[i] = map.get(nums1[i]);
        return res;
    }
}
