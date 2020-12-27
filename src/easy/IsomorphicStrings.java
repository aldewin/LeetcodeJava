package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/
 */

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic1("ab", "aa"));
        System.out.println(isIsomorphic2("paper", "title"));
    }

    public static boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char w = t.charAt(i);

            if (!map.containsKey(c)) {
                if (map.containsValue(w))
                    return false;
                map.put(c, w);
            } else if (map.get(c) != w) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] sToT = new int[128];
        int[] tToS = new int[128];
        Arrays.fill(sToT, -1);
        Arrays.fill(tToS, -1);
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sToT[sc] == tc && tToS[tc] == sc) {
                //ok
            } else if (sToT[sc] == -1 && tToS[tc] == -1) {
                sToT[sc] = tc;
                tToS[tc] = sc;
            } else {
                return false;
            }
        }
        return true;
    }
}
