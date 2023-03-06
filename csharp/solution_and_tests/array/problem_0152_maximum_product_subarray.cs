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
 * 1, because we might have to make a new subarray after 0. This is optional
 * 
 * Use temp to re-use the old currMax value
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System;
using System.Linq;
using NUnit.Framework;

namespace Maximum_Product_Subarray
{
    class Solution
    {
        public static int MaxProduct(int[] nums)
        {
            int maxProduct = nums[0];
            int currMin = 1;
            int currMax = 1;
            foreach (int num in nums)
            {
                // You don't need the if condition here
                if (num == 0)
                {
                    currMin = 1;
                    currMax = 1;
                }
                int tempMax = currMax * num;
                currMax = Math.Max(Math.Max(tempMax, num * currMin), num);
                currMin = Math.Min(Math.Min(tempMax, num * currMin), num);
                maxProduct = Math.Max(maxProduct, currMax);
            }
            return maxProduct;
        }

        public static int MaxProductSwap(int[] nums)
        {
            int currMax = nums[0];
            int currMin = nums[0];
            int maxProduct = nums[0];
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] < 0)
                {
                    int temp = currMax;
                    currMax = currMin;
                    currMin = temp;
                }
                currMax = Math.Max(nums[i], currMax * nums[i]);
                currMin = Math.Min(nums[i], currMin * nums[i]);
                maxProduct = Math.Max(maxProduct, currMax);
            }
            return maxProduct;
        }

        public static int MaxProductMethodThree(int[] nums)
        {
            int maxProduct = nums.Max();
            (int currMin, int currMax) = (1, 1);
            foreach(int num in nums)
            {
                int tempMax = currMax * num;
                currMax = new int[] { num, num * currMin, tempMax }.Max();
                currMin = new int[] { num, num * currMin, tempMax }.Min();
                maxProduct = Math.Max(maxProduct, currMax);
            }
            return maxProduct;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 2, 3, -2, 4 }, ExpectedResult = 6)]
        [TestCase(new int[] { -2, 0, -1 }, ExpectedResult = 0)]
        public int TestMaxProduct(int[] nums)
        {
            return Solution.MaxProduct(nums);
        }

        [Test]
        [TestCase(new int[] { 2, 3, -2, 4 }, ExpectedResult = 6)]
        [TestCase(new int[] { -2, 0, -1 }, ExpectedResult = 0)]
        public int TestMaxProductSwap(int[] nums)
        {
            return Solution.MaxProductSwap(nums);
        }

        [Test]
        [TestCase(new int[] { 2, 3, -2, 4 }, ExpectedResult = 6)]
        [TestCase(new int[] { -2, 0, -1 }, ExpectedResult = 0)]
        public int TestMaxProductMethodThree(int[] nums)
        {
            return Solution.MaxProductMethodThree(nums);
        }
    }
}
