/*
 * https://leetcode.com/problems/sort-colors/
 * Explanation:
 * 
 * The one pass solution uses two pivot point. We have a current index, a zero
 * index and a two index (end of the array, decrement each time)
 * if the current num is 0, we swap it with the element at zero index and
 * increment both current and zero
 * else if the current num is 2, we swap it with the element at two index (end
 * of the array) and ONLY decrement the two index
 * else the current num is 1, we just increment the current index
 * 
 * Time: O(n)
 * Space: O(n) if count input array, O(1) otherwise
 */

using NUnit.Framework;

namespace Sort_Colors
{
    class Solution
    {
        public void SortColors(int[] nums)
        {
            int zeroIndex = 0;
            int currIndex = 0;
            int twoIndex = nums.Length - 1;
            while (currIndex <= twoIndex)
            {
                if (nums[currIndex] == 0)
                {
                    int temp = nums[currIndex];
                    nums[currIndex++] = nums[zeroIndex];
                    nums[zeroIndex++] = temp;
                }
                else if (nums[currIndex] == 2)
                {
                    int temp = nums[currIndex];
                    nums[currIndex] = nums[twoIndex];
                    nums[twoIndex--] = temp;
                }
                else
                {
                    currIndex++;
                }
            }
        }

        public int[] TestSortColor(int[] nums)
        {
            SortColors(nums);
            return nums;
        }
    }

    class Tests
    {
        Solution sol;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { 2, 0, 2, 1, 1, 0 }, ExpectedResult = new int[] { 0, 0, 1, 1, 2, 2 })]
        [TestCase(new int[] { 2, 0, 1 }, ExpectedResult = new int[] { 0, 1, 2 })]
        public int[] TestSortColor(int[] nums)
        {
            return sol.TestSortColor(nums);
        }
    }
}
