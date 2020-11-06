package easy;

/**
 * 169. Majority Element
 *
 * https://www.youtube.com/watch?v=mp9bELFMQn0
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[] {-1,1,1,1,2,1}));
        System.out.println(majorityElement2(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement3(new int[] {3, 2, 3}));
    }

    // Runtime: 8 ms; 12 ms, Memory: 44.1 MB
    public static int majorityElement1(int[] nums) {
        // 1 вариант
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num: nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        }

        // 2 вариант
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num) && map.get(num) + 1 > nums.length / 2) {
                return num;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return nums[0];

    }

    // Runtime: 3 ms, Memory: 42.2 MB
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else
                count = 1;
            if (count > len / 2)
                return nums[i - 1];
        }
        return nums[len - 1];
    }

    // Runtime: 1 ms, Memory: 42.1 MB
    public static int majorityElement3(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num: nums) {
            if (num == ans) {
                count++;
            } else if (count == 0) {
                ans = num;
                count = 1;
            } else {
                count--;
            }
        }
        return ans;
    }
}
