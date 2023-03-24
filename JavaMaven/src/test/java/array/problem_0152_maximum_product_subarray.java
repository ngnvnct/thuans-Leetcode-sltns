/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * Explanation:
 * 
 * We have to take account for 0 value, and odd/even number of negative numbers.
 * Multiplying with negative number max will become min and min will become max,
 * as soon as we encounter a negative element we swap max and min.
 * 
 * Case1: All the elements are positive. Then your answer will be product of
 * all the elements in the array.
 * Case2: Array have positive and negative elements both :
 * If the number of negative elements is even then again your answer will be
 * complete array because on multiplying all the negative numbers it will become
 * positive.
 * If the number of negative elements is odd then you have to remove just one
 * negative element and for that u need to check your subarrays to get the max
 * product.
 * Case3 : Array also contains 0. We just make the currMin and currMax equals
 * 1, because we might have to make a new subarray after 0
 * 
 * Use temp to re-use the old currMax value
 * 
 * Time: O(n)
 * Space: O(1)
 */

package array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0152_maximum_product_subarray {
    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Swapping min and max
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);
            ans = Math.max(ans, currMax);
        }
        return ans;
    }

    public int maxProductMethodTwo(int[] nums) {
        int n = nums.length;
        int leftPointer = 1;
        int rightPointer = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            // if any of left or right become 0 then update it to 1
            leftPointer = leftPointer == 0 ? 1 : leftPointer;
            rightPointer = rightPointer == 0 ? 1 : rightPointer;

            leftPointer *= nums[i]; // prefix product
            rightPointer *= nums[n - 1 - i]; // suffix product
            ans = Math.max(ans, Math.max(leftPointer, rightPointer));

        }
        return ans;
    }

    public int maxProductMethodThree(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;
        for (int num : nums) {
            if (num == 0) {
                currMin = 1;
                currMax = 1;
            }
            int tempMax = currMax * num;
            currMax = Math.max(Math.max(tempMax, num * currMin), num);
            currMin = Math.min(Math.min(tempMax, num * currMin), num);
            res = Math.max(res, currMax);
        }
        return res;
    }

    @Test
    public void testMaxProduct() {
        int[] testCase1 = { 2, 3, -2, 4 };
        int testCase1ExpectedResult = 6;
        int[] testCase2 = { -2, 0, -1 };
        int testCase2ExpectedResult = 0;
        int[] testCase3 = { 2, 3, -2, 4, -1 };
        int testCase3ExpectedResult = 48;
        int[] testCase4 = { -2, -3, -4 };
        int testCase4ExpectedResult = 12;
        int[] testCase5 = { 2 };
        int testCase5ExpectedResult = 2;
    
        assertEquals(testCase1ExpectedResult, maxProduct(testCase1));
        assertEquals(testCase2ExpectedResult, maxProduct(testCase2));
        assertEquals(testCase3ExpectedResult, maxProduct(testCase3));
        assertEquals(testCase4ExpectedResult, maxProduct(testCase4));
        assertEquals(testCase5ExpectedResult, maxProduct(testCase5));

        assertEquals(testCase1ExpectedResult, maxProductMethodTwo(testCase1));
        assertEquals(testCase2ExpectedResult, maxProductMethodTwo(testCase2));
        assertEquals(testCase3ExpectedResult, maxProductMethodTwo(testCase3));
        assertEquals(testCase4ExpectedResult, maxProductMethodTwo(testCase4));
        assertEquals(testCase5ExpectedResult, maxProductMethodTwo(testCase5));
        
        assertEquals(testCase1ExpectedResult, maxProductMethodThree(testCase1));
        assertEquals(testCase2ExpectedResult, maxProductMethodThree(testCase2));
        assertEquals(testCase3ExpectedResult, maxProductMethodThree(testCase3));
        assertEquals(testCase4ExpectedResult, maxProductMethodThree(testCase4));
        assertEquals(testCase5ExpectedResult, maxProductMethodThree(testCase5));
    }
}