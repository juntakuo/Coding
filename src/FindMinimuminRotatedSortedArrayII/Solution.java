package FindMinimuminRotatedSortedArrayII;

/**
 * Created by juntakuo on 11/9/14.
 * <p/>
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p/>
 * Would this affect the run-time complexity? How and why?
 */
public class Solution {
    public int findMin(int[] num) {

        int first = 0, last = num.length - 1;
        while (last > first && num[first] >= num[last]) {
            int mid = (first + last) / 2;
            if (num[mid] > num[last]) {
                first = mid + 1;
            } else if (num[mid] < num[first]) {
                last = mid;
            } else {
                ++first;
            }
        }
        return num[first];
    }
}
