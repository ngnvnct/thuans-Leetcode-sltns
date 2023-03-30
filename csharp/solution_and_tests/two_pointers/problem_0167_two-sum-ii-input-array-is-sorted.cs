/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Explantion:
 * 
 * Since the Array is sorted, we can just have a two pointers one at the front
 * and one at the end and shrink the window
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(1)
 */

using NUnit.Framework;

namespace Two_Sum_II_Input_Array_Is_Sorted
{
    class Solution
    {
        public static int[] TwoSum(int[] numbers, int target)
        {
            int leftPointer = 0;
            int rightPointer = numbers.Length - 1;
            while (leftPointer < rightPointer)
            {
                int currSum = numbers[leftPointer] + numbers[rightPointer];
                if (currSum == target)
                {
                    return new int[] { leftPointer + 1, rightPointer + 1 };
                }
                else if (currSum < target)
                {
                    leftPointer++;
                }
                else
                {
                    rightPointer--;
                }
            }
            return null;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 2, 7, 11, 15 }, 9, ExpectedResult = new int[] { 1, 2 })]
        [TestCase(new int[] { 2, 3, 4 }, 6, ExpectedResult = new int[] { 1, 3 })]
        [TestCase(new int[] { -1, 0 }, -1, ExpectedResult = new int[] { 1, 2 })]
        [TestCase(new int[] { 1, 2, 3, 4, 5, 6 }, 7, ExpectedResult = new int[] { 1, 6 })]
        [TestCase(new int[] { -5, -4, -3, -2, -1 }, -8, ExpectedResult = new int[] { 1, 3 })]
        public int[] TestTwoSum(int[] numbers, int target)
        {
            return Solution.TwoSum(numbers, target);
        }
    }
}
