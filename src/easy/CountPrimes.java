package easy;

import java.util.Arrays;

/**
 * 204. Count Primes
 *
 * https://leetcode.com/problems/count-primes/
 */

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    // Time complexity: O(n*log(log(n))), Time complexity: O(n)
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }
        return count;
    }
}
