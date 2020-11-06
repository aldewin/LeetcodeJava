package easy;

/**
 * 389. Find the Difference
 *
 * https://leetcode.com/problems/find-the-difference/
 */

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference1("abcd", "abcde"));
        System.out.println(findTheDifference2("", "y"));
        System.out.println(findTheDifference3("ae", "aea"));
    }

    // Runtime: 7 ms, Memory: 37.6 MB
    public static char findTheDifference1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return c;
            }
        }
        return '#';
    }

    // Runtime: 1 ms, Memory: 37.9 MB
    public static char findTheDifference2(String s, String t) {
        int sum = 0;
        for (char c: s.toCharArray()) {
            sum -= c;
        }
        for (char c: t.toCharArray()) {
            sum += c;
        }
        return (char) sum;
    }

    // Runtime: 1 ms, Memory: 37.6 MB
    public static char findTheDifference3(String s, String t) {
        char res = 0;
        for (char c: s.toCharArray()) {
            res ^= c;
        }
        for (char c: t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
