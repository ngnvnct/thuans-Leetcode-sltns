import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Find_Peak_Element_162 {
    public static void main (String[] args) {
        int[] test = new int[] {1,2,1,3,5,6,4};
        Find_Peak_Element_162 sol = new Find_Peak_Element_162();
        System.out.println(sol.findPeakElementsLinear(test));
    }

    public int findPeakElementsLinear(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public int findPeakElementsBinary(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findPeakElementsRecursive(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    public int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right-left) / 2;
        if (nums[mid] > nums[mid+1]) {
            return search(nums, left, mid);
        }
        return search(nums, mid+1, right);
    }

    @Test (timeout = 100)
    public void testPeak() {
        assertEquals(2, findPeakElementsBinary(new int[] {1,2,3,1}));
        assertEquals(2, findPeakElementsLinear(new int[] {1,2,3,1}));
        assertEquals(2, findPeakElementsRecursive(new int[] {1,2,3,1}));
        assertEquals(5, findPeakElementsBinary(new int[] {1,2,1,3,5,6,4}));
        //Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
        assertEquals(1, findPeakElementsLinear(new int[] {1,2,1,3,5,6,4})); 

        assertEquals(5, findPeakElementsRecursive(new int[] {1,2,1,3,5,6,4}));
        assertEquals(3, findPeakElementsBinary(new int[] {2,3,4,5,1}));
        assertEquals(3, findPeakElementsLinear(new int[] {2,3,4,5,1}));
        assertEquals(3, findPeakElementsRecursive(new int[] {2,3,4,5,1}));
    }
}

/*
https://leetcode.com/problems/find-peak-element/
Explanation

Linear Scan is simple, when nums[i] > nums[i+1], return
else it is a rising peak (last element will be the peak)

Binary Search, 3 cases
element [5,4,3,2,1]
index   [0,1,2,3,4]
mid = 3, index 2, because it is on a falling slope, nums[mid] will be bigger than everything on the left
so set set right = mid and continue our search, eventually the peak will be at the 0-indexed

Case 2
Rising slope, nums[mid] will be smaller than everything on its right, so left = mid + 1

Case 3, the peak is somewhere in the middle
If middle is on a rising slope, then we know the peak lies toward its right
element [2,3,4,5,1]
index   [0,1,2,3,4]

This problem is not asking for the highest peak, it is asking for a peak, linear near is good if it is a downward slope
it is not good when it is a rising slope since it will be O(n) to look for the peak

Time: O(n) for linear, O(log n ) for binary search
Space: O(1)
*/