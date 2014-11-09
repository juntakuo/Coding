package LongestPanlindromicSubstring;

/**
 * Created by juntakuo on 11/8/14.
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    public String longestPalindrome(String s) {
        String ret = s;
        s = preprocessing(s);
        int center = 0, R = 0;
        int[] pos = new int[s.length()];
        for (int i = 0 ; i < s.length() ; ++i) {
            int i_mirror = 2*center - i;
            pos[i] = (R > i) ? Math.min(R-i, pos[i_mirror]) : 0;
            while (i-pos[i] > 0 && i + pos[i] < s.length()-1 && s.charAt(i-pos[i]-1) == s.charAt(i+pos[i]+1)) ++pos[i];

            if (i + pos[i] > R) {
                center = i;
                R = i + pos[i];
            }
        }

        center = 0; R = 0;
        for (int i = 0 ; i < s.length() ; ++i) {
            if (pos[center] < pos[i]) {
                center = i;
                R = pos[i];
            }
        }
        return ret.substring((center-R)/2, (center+R)/2);
    }
    public String preprocessing(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        return sb.toString();
    }
}
