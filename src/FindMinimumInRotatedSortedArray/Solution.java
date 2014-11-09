package FindMinimumInRotatedSortedArray;

/**
 * Created by juntakuo on 11/8/14.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1) return num[0];

        int first = 0, last = num.length - 1;
        while (first < last) {
            int mid = (first + last)/2;
            if (mid == first) break;
            if (num[mid] > num[last]) {
                // right side is not sorted => search right
                first = mid;
            } else if (num[mid] < num[first]) {
                // left side is not sorted => search left
                last = mid;
            } else {
                // sorted
                return num[0];
            }

        }
        return Math.min(num[first], num[first+1]);
    }
}
