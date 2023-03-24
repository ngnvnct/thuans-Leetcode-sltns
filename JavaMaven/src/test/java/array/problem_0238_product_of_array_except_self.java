/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * Explanation:
 * 
 * First Position there is no prefix, we put a default value of 1
 * Method 1:
 * Fill the Array with 1, and going the loop calculate the prefix sum
 * res[0] = prefix = 1
 * prefix *= nums[i] = 1 * 1 = 1
 * res[1] = 1
 * prefix *= nums[i] = 1 * 2 = 2
 * res[2] = 2
 * prefix *= nums[i] = 2 * 3 = 6
 * res[3] = 6
 * res[] = {1,1,2,6} this is the prefix sum value
 * 
 * postfix = 1
 * res[3] * postfix = 6
 * postfix * nums[3] = 4
 * res[2] * postfix = 8
 * postfix * nums[2] = 12
 * res[1] * postfix = 12
 * postfix * nums[1] = 24
 * res[0] * postfix = 24
 * res[] = {24,12,8,6};
 * 
 * Method 2
 * res[0] = 1
 * res[1] = 1 * nums[0] = 1
 * res[2] = 1 * nums[1] = 2
 * res[3] = 2 * nums[2] = 6
 * res[] = {1,1,2,6}; this is the prefix sum value
 * 
 * postfix = 1
 * res[3] * postfix = 6
 * postfix * nums[3] = 4
 * res[2] * postfix = 8
 * postfix * nums[2] = 12
 * res[1] * postfix = 12
 * postfix * nums[1] = 24
 * res[0] * postfix = 24
 * res[] = {24,12,8,6};
 * 
 * Time: O(n)
 * Space: O(1), output array doesn't count
 */

package array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class problem_0238_product_of_array_except_self {
    public int[] productExceptSelfMethodOne(int[] nums) {
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            productArray[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArray[i] *= postfix;
            postfix *= nums[i];
        }
        return productArray;
    }

    public int[] productExceptSelfMethodTwo(int[] nums) {
        int[] productArray = new int[nums.length];
        productArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productArray[i] = productArray[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productArray[i] *= postfix;
            postfix *= nums[i];
        }
        return productArray;
    }

    public int[] productExceptSelfMethodThree(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
        int[] productArray = new int[nums.length];
        prefixSum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i - 1] * prefixSum[i - 1];
        }
        suffixSum[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = nums[i + 1] * suffixSum[i + 1];
        }
        for (int i = 0; i < productArray.length; i++) {
            productArray[i] = prefixSum[i] * suffixSum[i];
        }
        return productArray;
    }

    @Test
    public void testProductExceptSelf() {
        int[] testCase1 = { 1, 2, 3, 4 };
        int[] testCase2 = { -1, 1, 0, -3, 3 };
        int[] testCase1ExpectedResult = { 24, 12, 8, 6 };
        int[] testCase2ExpectedResult = { 0, 0, 9, 0, 0 };

        assertArrayEquals(testCase1ExpectedResult, productExceptSelfMethodOne(testCase1));
        assertArrayEquals(testCase2ExpectedResult, productExceptSelfMethodOne(testCase2));

        assertArrayEquals(testCase1ExpectedResult, productExceptSelfMethodTwo(testCase1));
        assertArrayEquals(testCase2ExpectedResult, productExceptSelfMethodTwo(testCase2));

        assertArrayEquals(testCase1ExpectedResult, productExceptSelfMethodThree(testCase1));
        assertArrayEquals(testCase2ExpectedResult, productExceptSelfMethodThree(testCase2));
    }
}