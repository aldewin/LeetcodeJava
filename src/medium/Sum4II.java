package medium;

import java.util.HashMap;
import java.util.Map;

public class Sum4II {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(fourSumCount(a, b, c, d));
    }

    public static int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> countSum = new HashMap<>();

        for (int valA : a) {
            for (int valB : b) {
                countSum.put(valA + valB, countSum.getOrDefault(valA+valB, 0) + 1);
            }
        }

        int count = 0;
        for (int valC : c) {
            for (int valD : d) {
                int sum = valC + valD;
                count += countSum.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}
