package easy;

/**
 * 821. Shortest Distance to a Character
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("aaba", 'b')));
    }

    // runtime: 1 ms, Memory: 39.7 MB
    public static int[] shortestToChar(String s, char c) {
        List<Integer> indexChar = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                indexChar.add(i);
        }
        int count = 0;
        int left = indexChar.get(count);
        int right = indexChar.get(count);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Math.min(Math.abs(i - left), Math.abs(right - i));
            if ((i == left || i == right) && count + 1 != indexChar.size()) {
                left = right;
                right = indexChar.get(++count);
            }
        }
        return res;
    }
}
