package StringToInteger;

/**
 * Created by juntakuo on 11/9/14.
 */
public class Solution {
    public static void main(String args[]) {
        System.out.println("result = "+ atoi("        -234567898765432x"));
    }
    public static int atoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1, idx = 0;
        if (str.charAt(0) == '+') {
            ++idx;
        } else if (str.charAt(0) == '-') {
            sign = -1; ++idx;
        }
        int ret = 0, maxDiv10 = Integer.MAX_VALUE/10;
        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            int digit = Character.getNumericValue(str.charAt(idx));
            if (ret > maxDiv10 || ret == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = ret * 10 + digit;
            ++idx;
        }
        return sign*ret;

    }
}
