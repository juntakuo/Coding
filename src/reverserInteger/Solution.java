package reverserInteger;

/**
 * Created by juntakuo on 11/9/14.
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(901000));
    }

    public static int reverse(int x) {
        int ret = 0;
        while (Math.abs(x) > 0) {
            int digit = x % 10;
            if (ret != 0 && Math.abs(Integer.MAX_VALUE / ret) < 10) {
                System.out.println(Math.abs(Integer.MAX_VALUE / ret));
                throw new RuntimeException();
            }
            ret = 10*ret + digit;
            x /= 10;
        }
        return ret;
    }
}
