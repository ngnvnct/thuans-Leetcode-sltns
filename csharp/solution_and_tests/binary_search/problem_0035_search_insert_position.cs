/*
 * https://leetcode.com/problems/search-insert-position/
 * Explanation:
 * 
 * Similar to Binary Search https://leetcode.com/problems/binary-search/
 * 
 * Time: O(logn)
 * Space: O(1)
 */

using NUnit.Framework;

namespace Search_Insert_Position
{
    public class Solution
    {
        public static int SearchInsert(int[] nums, int target)
        {
            int leftPointer = 0;
            int rightPointer = nums.Length - 1;
            while (leftPointer <= rightPointer)
            {
                int mid = leftPointer + (rightPointer - leftPointer) / 2;
                if (nums[mid] == target)
                {
                    return mid;
                }
                else if (nums[mid] < target)
                {
                    leftPointer = mid + 1;
                }
                else
                {
                    rightPointer = mid - 1;
                }
            }
            return leftPointer;
        }
    }
    public class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 3, 5, 6 }, 5, ExpectedResult = 2)]
        [TestCase(new int[] { 1, 3, 5, 6 }, 2, ExpectedResult = 1)]
        [TestCase(new int[] { 1, 3, 5, 6 }, 7, ExpectedResult = 4)]
        public int TestSearchInsert(int[] nums, int target)
        {
            return Solution.SearchInsert(nums, target);
        }
    }
}