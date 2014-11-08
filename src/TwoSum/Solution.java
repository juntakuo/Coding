package TwoSum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by juntakuo on 11/8/14.
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    public class NumberWrapper {
        int val;
        int idx;
        public NumberWrapper(int v, int i) {
            this.val = v;
            this.idx = i;
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        NumberWrapper[] numbersWrappers = new NumberWrapper[numbers.length];
        for (int idx = 0; idx < numbers.length ; ++idx) {
            numbersWrappers[idx] = new NumberWrapper(numbers[idx], idx+1);
        }

        Arrays.sort(numbersWrappers, new Comparator<NumberWrapper>() {
                public int compare(NumberWrapper numberWrapper, NumberWrapper numberWrapper2) {
                return numberWrapper.val - numberWrapper2.val;
            }
        });

        int first = 0;
        int last = numbersWrappers.length - 1;
        int [] ret = new int[] {-1, -1};
        while (last > first) {
            int tmp = numbersWrappers[first].val + numbersWrappers[last].val;
            if (tmp == target) {
                if (numbersWrappers[first].idx < numbersWrappers[last].idx) {
                    ret[0] = numbersWrappers[first].idx;
                    ret[1] = numbersWrappers[last].idx;
                } else {
                    ret[0] = numbersWrappers[last].idx;
                    ret[1] = numbersWrappers[first].idx;
                }
                return ret;
            } else if (tmp > target) {
                --last;
            } else {
                ++first;
            }
        }
        return ret;
    }
}
