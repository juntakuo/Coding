package LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

/**
 * Created by juntakuo on 11/8/14.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        int begin = 0, ret = 0;
        for (int i = 0 ; i < s.length() ; ++i) {
            begin = Math.max(begin, pos[s.charAt(i)]+1);
            pos[s.charAt(i)] = i;
            ret = Math.max(ret, i - begin + 1);
        }
        return ret;
    }
}
