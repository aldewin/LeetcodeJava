package easy;

/**
 * 219. Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/
 */

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            else
                map.put(nums[i], i);
        }
        return false;
    }
}
