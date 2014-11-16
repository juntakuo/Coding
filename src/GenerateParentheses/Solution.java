package GenerateParentheses;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by juntakuo on 11/16/14.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * n = 3
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * n = 2
 * "()()", "(())"
 * n = 1
 * "()"
 */
public class Solution {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if (n > 0) {
            generateParenthesis(ret, "", 0, 0, n);
        }
        return ret;
    }
    public static void generateParenthesis(List<String> ret, String s, int l , int r, int n) {
        if (l == n) {
            for (int i = 0 ; i < n -r ; ++i) s += ")";
            ret.add(s);
            return;
        }
        generateParenthesis(ret, s + "(", l+1, r, n);
        if (l > r) generateParenthesis(ret , s + ")", l, r + 1, n);
    }
}
