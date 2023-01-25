/*
 * https://leetcode.com/problems/binary-search/
 * Explanation:
 * 
 * Textbook algorithm based on the idea to compare the target value ot the middle elemnt of the array.
 * If the target value is equal to the middle element - we're done
 * if the target value is smaller - search on the left
 * if the target value is larger - search on the right
 * 
 * Works best when the array is SORTED.
 * Use mid = left + (right - left) / 2 to avoid integer overflow vs left + right / 2
 * 
 * Time: O(log n)
 * Space: O(1)
 */

using NUnit.Framework;

namespace Binary_Search
{
    class Solution
    {
        public int Search(int[] nums, int target)
        {
            int leftPointer = 0;
            int rightPointer = nums.Length - 1;
            while (leftPointer <= rightPointer)
            {
                int midPoint = leftPointer + (rightPointer - leftPointer) / 2;
                if (nums[midPoint] == target)
                {
                    return midPoint;
                }
                else if (nums[midPoint] < target)
                {
                    leftPointer = midPoint + 1;
                }
                else
                {
                    rightPointer = midPoint - 1;
                }
            }
            return -1;
        }
    }

    class Test
    {
        Solution sol;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { -1, 0, 3, 5, 9, 12 }, 9, ExpectedResult = 4)]
        [TestCase(new int[] { -1, 0, 3, 5, 9, 12 }, 2, ExpectedResult = -1)]
        [TestCase(new int[] { 1, 5, 23, 111 }, 111, ExpectedResult = 3)]
        [TestCase(new int[] { 1, 5, 23, 111 }, 5, ExpectedResult = 1)]
        [TestCase(new int[] { 1, 5, 23, 111 }, 35, ExpectedResult = -1)]
        [TestCase(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33, ExpectedResult = 3)]
        [TestCase(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 0, ExpectedResult = 0)]
        [TestCase(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 1, ExpectedResult = 1)]
        public int TestSearch(int[] nums, int target)
        {
            return sol.Search(nums, target);
        }
    }
}
