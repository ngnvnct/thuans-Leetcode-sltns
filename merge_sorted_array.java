import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        merge_sorted_array sol = new merge_sorted_array();
        sol.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1,2,3,0,0,0};
        int[] nums4 = {1,1,1};
        m = 3;
        n = 3;

        sol.merge2(nums3,m,nums4,n);
        System.out.println(Arrays.toString(nums3));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int last = m + n -1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[last--] = nums2[p2--];
            } else {
                nums1[last--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[last--] = nums2[p2--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // last index nums1
        int lastIndex = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[lastIndex] = nums1[m-1];
                m -= 1;
            } else {
                nums1[lastIndex] = nums2[n-1];
                n -= 1;
            }
            lastIndex -= 1;
        }
        // fill nums1 with leftover nums2 element
        while (n > 0) {
            nums1[lastIndex] = nums2[n-1];
            n -= 1;
            lastIndex -= 1;
        }
    }
}

/*
https://leetcode.com/problems/merge-sorted-array/
Explanation

We know m is the length of nums1, and n is length of nums2, so the last index of nums1 is m-1, and nums2 is n-1
the last index of nums1 (with enough space for m + n) is m+n-1.

Three Pointers
We just fill it from the end of the array
If the current nums1 is bigger than nums2, since both are sorted we know it is the biggest one, we put it at the end of the array and decrement the lastIndex by one, and nums1 index by 1 (p1)
and the opposite if num2 element is bigger

One edge case is we have leftover in nums2
fill it while there is leftover, we know everything from this point on is smaller than nums1
nums1 [2,3,3,0,0,0]
nums2 [1,1,1,1]

Time: O(m + n)
Space: O(1)
*/