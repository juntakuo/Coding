package PalindromeNumber;

/**
 * Created by juntakuo on 11/12/14.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {
    public static void main (String[] args) {
        System.out.println(isPalindrome(0));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int pow = 1;
        while (x/pow > 9) pow *= 10;

        while (x > 0) {
            if (x/pow != x % 10) return false;
            x %= pow;
            x /= 10;
            pow /= 100;
        }
        return true;
    }
}
