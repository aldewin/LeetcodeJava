package easy;

/**
 * 290. Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/
 */

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    // Time complexity: O(n)
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;

        HashMap map = new HashMap();
        for (Integer i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];

            if (!map.containsKey(p))
                map.put(p, i);
            if (!map.containsKey(w))
                map.put(w, i);

            if (map.get(p) != map.get(w))
                return false;
        }
        return true;
    }
}
