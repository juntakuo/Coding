package ThreeSum;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by juntakuo on 11/15/14.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = new int[] {-1, -1, -1, 0, 1, 2, 2, 2, -1, -4, -4};
        List<List<Integer>> ret = threeSum(num);
        for (List<Integer> list : ret) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < num.length - 2; ) {
            while (i > 0 && i < num.length - 2 && num[i-1] == num[i]) ++i;

            int first = i + 1, last = num.length - 1;
            while (first < last) {
                int sum = num[i] + num[first] + num[last];
                if (sum == 0) {
                    ArrayList<Integer> set = new ArrayList<Integer>();
                    set.add(num[i]); set.add(num[first]);set.add(num[last]);
                    if (!ret.contains(set))ret.add(set);
                    do ++first; while (first < num.length - 1  && first < last && num[first] == num[first - 1]);
                    do --last; while (last > 0 && first < last && num[last + 1] == num[last]);
                } else if (sum > 0) {
                    do --last; while (last > 0 && first < last && num[last + 1] == num[last]);
                } else {
                    do ++first; while (first < num.length - 1 && first < last && num[first] == num[first - 1] );
                }
            }
            do ++i; while (i < num.length - 2 && num[i] == num[i - 1] );
        }
        return ret;
    }
}
