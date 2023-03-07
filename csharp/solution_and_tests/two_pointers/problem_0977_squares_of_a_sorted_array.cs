/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 * Explanation:
 * 
 * The key take away is the array is sorted. So the start and the end element
 * have the potential to be the largest.
 * We take the absolute value of the start and end element and use Two Pointers
 * approach
 * Then we compare it with each other, and insert the bigger one square at the
 * end of our result array.
 * 
 * Time: O(n), where n is the array
 * Space: O(n), where n is the array input
 */

using System;
using NUnit.Framework;

namespace Squares_of_a_Sorted_Array
{
    class Solution
    {
        public static int[] SortedSquares(int[] nums)
        {
            int leftPointer = 0;
            int rightPointer = nums.Length - 1;
            int[] sortedSquareArray = new int[nums.Length];
            int sortedSquareIndex = nums.Length - 1;
            while (leftPointer <= rightPointer)
            {
                int currLeftValue = Math.Abs(nums[leftPointer]);
                int currRightValue = Math.Abs(nums[rightPointer]);
                if (currLeftValue < currRightValue)
                {
                    sortedSquareArray[sortedSquareIndex--] = currRightValue * currRightValue;
                    rightPointer--;
                }
                else
                {
                    sortedSquareArray[sortedSquareIndex--] = currLeftValue * currLeftValue;
                    leftPointer++;
                }
            }
            return sortedSquareArray;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { -4, -1, 0, 3, 10 }, ExpectedResult = new int[] { 0, 1, 9, 16, 100 })]
        [TestCase(new int[] { -7, -3, 2, 3, 11 }, ExpectedResult = new int[] { 4, 9, 9, 49, 121 })]
        public int[] TestSortedSquares(int[] nums)
        {
            return Solution.SortedSquares(nums);
        }
    }
}
