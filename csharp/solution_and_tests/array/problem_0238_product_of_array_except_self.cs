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

using NUnit.Framework;

namespace Product_of_Array_Except_Self
{
    class Solution
    {
        public static int[] ProductExceptSelf(int[] nums)
        {
            int[] productArray = new int[nums.Length];
            productArray[0] = 1;
            for (int i = 1; i < nums.Length; i++)
            {
                productArray[i] = productArray[i - 1] * nums[i - 1];
            }
            int postfix = 1;
            for (int i = nums.Length - 1; i >= 0; i--)
            {
                productArray[i] *= postfix;
                postfix *= nums[i];
            }
            return productArray;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = new int[] { 24, 12, 8, 6 })]
        [TestCase(new int[] { -1, 1, 0, -3, 3 }, ExpectedResult = new int[] { 0, 0, 9, 0, 0 })]
        public int[] TestProductExceptSelf(int[] nums)
        {
            return Solution.ProductExceptSelf(nums);
        }
    }
}
