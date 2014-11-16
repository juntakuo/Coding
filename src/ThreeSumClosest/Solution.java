package ThreeSumClosest;

import java.util.Arrays;
/**
 * Created by juntakuo on 11/15/14.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = new int[] {0,2,1,-3};
        System.out.println(threeSumClosest(num, 1));
    }
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int ret = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;;
        for (int i = 0 ; i < num.length - 2 ; ) {
            int first = i + 1, last = num.length - 1;
            while (first < last) {
                int sum = num[i] + num[first] + num[last];
                if (diff > Math.abs(target - sum)) {
                    ret = sum;
                    diff = Math.abs(target - sum);
                }
                if (sum < target) {
                    ++first;
                } else {
                    --last;
                }
            }
            do ++i; while (i < num.length - 2 && num[i] == num[i - 1] );
        }
        return ret;
    }
}
