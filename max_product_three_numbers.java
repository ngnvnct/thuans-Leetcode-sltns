import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class max_product_three_numbers {
    public int maxProductSort(int[] nums) {
        Arrays.sort(nums);
        int threeLargest = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        int twoSmallest = nums[0] * nums[1] * nums[nums.length-1];
        return Math.max(threeLargest, twoSmallest);
    }

    public int maxProductScan(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num <= secondSmallest) {
                secondSmallest = num;
            }
            if (num >= largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            } else if (num >= secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num >= thirdLargest) {
                thirdLargest = num;
            }
        }
        return Math.max(thirdLargest*secondLargest*largest, largest * smallest * secondSmallest);
    }

    @Test
    public void testProduct() {
        assertEquals(6, maxProductScan(new int[] {1,2,3}));
        assertEquals(24, maxProductScan(new int[] {1,2,3,4}));
        assertEquals(-6, maxProductScan(new int[] {-1,-2,-3}));
        assertEquals(6, maxProductSort(new int[] {1,2,3}));
        assertEquals(24, maxProductSort(new int[] {1,2,3,4}));
        assertEquals(-6, maxProductSort(new int[] {-1,-2,-3}));
    }
}

/*
Explanation

Simple problem with one edge case. There can be 2 negative number that when multiply can give a bigger product.
So in the sorting method, we find the max of the 3 largest number, and the product of 2 smallest number multiply by the largest number to get the max product.

In the linear scan, we would have 5 variables to keep track of all of them

Follow Up: What if we want to find the product of 50 numbers. Solution: use Heap

Time: O(nlogn) for sorting, O(n) for linear scan
Space: O(1) since we are not using any extra space beside input array
*/