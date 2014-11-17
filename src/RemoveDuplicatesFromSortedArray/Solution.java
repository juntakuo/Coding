package RemoveDuplicatesFromSortedArray;

/**
 * Created by juntakuo on 11/16/14.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int tail = 1;
        for (int i = 1 ; i < A.length ; ++i) {
            int val = A[i];
            if (A[i-1] == val) continue;
            A[tail++] = A[i];
        }
        return tail;
    }
}
