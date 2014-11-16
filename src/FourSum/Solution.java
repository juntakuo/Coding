package FourSum;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by juntakuo on 11/15/14.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = new int [] {1, 0, -1, 0, -2, 2};
        List<List<Integer>> set = fourSum(num, 0);
        for (List<Integer> s : set) {
            System.out.println(s);
        }
    }
    // -2 -1 0 0 1 2
    public static List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < num.length - 3 ;) {
            for (int j = i + 1; j < num.length - 2; ) {
                int first = j + 1, last = num.length - 1;
                while (last > first) {
                    int sum = num[i]+num[j]+num[first]+num[last];
                    if (sum == target) {
                        List<Integer> set = new ArrayList<Integer>();
                        set.add(num[i]);set.add(num[j]);set.add(num[first]);set.add(num[last]);
                        ret.add(set);
                        do ++first; while (first < num.length && last > first && num[first - 1] == num[first]);
                        do --last; while (last > 0 && last > first && num[last] == num[last+1]);
                    } else if (sum > target) {
                        do --last; while (last > 0 && last > first && num[last] == num[last+1]);
                    } else {
                        do ++first; while (first < num.length && last > first && num[first - 1] == num[first]);
                    }
                }
                do ++j; while (j < num.length-2 && num[j-1] == num[j]);
            }
            do ++i; while (i < num.length-2 && num[i-1] == num[i]);
        }
        return ret;
    }
}
