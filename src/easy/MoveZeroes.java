package easy;

/**
 * 283. Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes1(new int[] {0, 1, 0, 3, 12});
        moveZeroes2(new int[] {4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
        moveZeroes3(new int[] {4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
        moveZeroes4(new int[] {4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    // Runtime: 33 ms, Memory: 39.4 MB
    public static void moveZeroes1(int[] nums) {
        while (true) {
            int i = 0;
            while (i < nums.length && nums[i] != 0)
                i++;
            int j = i + 1;
            while (j < nums.length && nums[j] == 0)
                j++;
            if (i < nums.length && j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++; j++;
            } else break;
        }
        System.out.println(Arrays.toString(nums));
    }

    // Runtime: 1 ms, Memory: 39.2 MB
    public static void moveZeroes2(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                q.add(nums[i]);
            else
                count++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty())
                nums[i] = q.poll();
            else
                nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    // Runtime: 0 ms, Memory: 41.8 MB
    public static void moveZeroes3(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[idx++] = nums[i];
        }
        for (int i = idx; i < nums.length; i++)
            nums[i] = 0;
        System.out.println(Arrays.toString(nums));
    }

    // Runtime: 0 ms, Memory: 42 MB
    public static void moveZeroes4(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                idx++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
