import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class Product_Of_Array_Except_Self_238 {
    public int[] productExceptSelfMethodOne(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelfMethodTwo(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelfMethodThree(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        
        suffix[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    @Test
    public void testProductSelf() {
        int[] exampleOne = { 1, 2, 3, 4 };
        int[] exampleTwo = { -1, 1, 0, -3, 3 };
        int[] exampleOneExpectedResult = { 24, 12, 8, 6 };
        int[] exampleTwoExpectedResult = { 0, 0, 9, 0, 0 };

        assertArrayEquals(exampleOneExpectedResult, productExceptSelfMethodOne(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, productExceptSelfMethodOne(exampleTwo));

        assertArrayEquals(exampleOneExpectedResult, productExceptSelfMethodTwo(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, productExceptSelfMethodTwo(exampleTwo));

        assertArrayEquals(exampleOneExpectedResult, productExceptSelfMethodThree(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, productExceptSelfMethodThree(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * Explanation
 * 
 * First Position there is no prefix, we put a default value of 1
 * Method 1:
 * Fill the Array with 1, and going the loop calculate the prefix
 * res[0] = prefix = 1
 * prefix *= nums[i] = 1 * 1 = 1
 * res[1] = 1
 * prefix *= nums[i] = 1 * 2 = 2
 * res[2] = 2
 * prefix *= nums[i] = 2 * 3 = 6
 * res[3] = 6
 * res[] = {1,1,2,6} this is the prefix value
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
 * res[] = {1,1,2,6}; this is the prefix value
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