package ContainerWithMostWater;

/**
 * Created by juntakuo on 11/12/14.
 */
public class Solution {
    public int maxArea(int[] height) {
        int first = 0, last = height.length - 1, ret = Integer.MIN_VALUE;
        while (last > first) {
            int result = Math.min(height[first], height[last]) * (last - first);
            ret = Math.max(ret, result);
            if (height[first] <= height[last]) ++first;
            else --last;
        }
        return ret;
    }
}
