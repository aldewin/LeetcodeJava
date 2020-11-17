package medium; /**
 * 56. Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                new int[] {1, 3},
                new int[] {2, 6},
                new int[] {8, 10},
                new int[] {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return intervals;

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        res.add(new int[] {left, right});
        return res.toArray(new int[0][]);
    }
}
