package MedianofTwoSortedArrays;

/**
 * Created by juntakuo on 11/8/14.
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if (length % 2 != 0)
            return findKthElement(A, 0, A.length, B, 0, B.length, length/2+1);
        else
            return (findKthElement(A, 0, A.length, B, 0, B.length, length/2) +
                    findKthElement(A, 0, A.length, B, 0, B.length, length/2+1))/2;
    }
    public double findKthElement(int[] A, int start1, int len1, int[]B,  int start2, int len2, int k) {
        if (len1 > len2) return findKthElement(B, start2, len2, A, start1, len1, k);

        if (len1 == 0) return B[k-1];
        if (len2 == 0) return A[k-1];
        if (k == 1) return Math.min(A[start1], B[start2]);

        int aMid = Math.min(k/2, len1);
        int bMid = k - aMid;
        if (A[start1+aMid-1] > B[start2+bMid-1]) {
            return findKthElement(A, start1, len1, B, start2+bMid , len2-bMid, k-bMid);
        } else return findKthElement(A, start1+aMid, len1-aMid, B, start2 , len2, k-aMid);
    }
}
