package easy;

/**
 * 350. Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            if (map.containsKey(i) && map.get(i) >= 1) {
                map.put(i, map.get(i) - 1);
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
