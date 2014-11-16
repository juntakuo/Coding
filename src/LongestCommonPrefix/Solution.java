package LongestCommonPrefix;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Created by juntakuo on 11/15/14.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        Arrays.sort(strs, new Comparator<String> () {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        String str = strs[0];
        for (int i = str.length() ; i >= 0 ; --i) {
            String prefix = str.substring(0, i);
            if (isCommonPrefix(prefix, strs)) return prefix;
        }
        return "";
    }

    public boolean isCommonPrefix(String prefix, String[] strs) {
        for (String s : strs) {
            if (!s.startsWith(prefix)) return false;
        }
        return true;
    }
}
