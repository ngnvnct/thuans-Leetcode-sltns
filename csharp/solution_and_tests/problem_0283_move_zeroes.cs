using NUnit.Framework;

namespace Move_Zeroes
{
    public class Solution
    {
        public void MoveZeroes(int[] nums)
        {
            int readIndex = 0;
            int writeIndex = 0;

            while (readIndex < nums.Length)
            {
                if (nums[readIndex] == 0)
                {
                    readIndex++;
                    continue;
                }
                if (readIndex != writeIndex)
                {
                    nums[writeIndex] = nums[readIndex];
                    nums[readIndex] = 0;
                }
                writeIndex++;
                readIndex++;
            }
        }

        public int CountMoveZeroesMetaMockInterview(int[] nums)
        {
            int readIndex = 0;
            int writeIndex = 0;
            while (readIndex < nums.Length)
            {
                if (nums[readIndex] == 0)
                {
                    readIndex++;
                    continue;
                }
                if (readIndex != writeIndex)
                {
                    nums[writeIndex] = nums[readIndex];
                    nums[readIndex] = 0;
                }
                writeIndex++;
                readIndex++;
            }
            return writeIndex;
        }
    }

    public class Tests
    {
        Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { 1, 3, 12, 0, 0 }, new int[] { 0, 1, 0, 3, 12 })]
        [TestCase(new int[] { 0 }, new int[] { 0 })]
        public void TestMoveZeroes(int[] expectedResult, int[] nums)
        {
            sol.MoveZeroes(nums);
            Assert.AreEqual(expectedResult, nums);
        }

        [Test]
        [TestCase(new int[] { 0, 1, 0, 3, 12 }, ExpectedResult = 3)]
        [TestCase(new int[] { 0 }, ExpectedResult = 0)]
        public int TestCountMoveZeroes(int[] nums)
        {
            return sol.CountMoveZeroesMetaMockInterview(nums);
        }
    }
}

/*
 * https://leetcode.com/problems/move-zeroes/
 * Explantion
 * We want to loop through an Array and check for index that doesn't have a 0.
 * We keep an index at the start of the Array
 * and only increment it after we swap it with the current element that is not
 * 0.
 * 
 * This method does minimum write
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(1), input array doesn't count, if it does then O(n)
 * 
 * CountMoveZeroes was asked during facebook mock, want to return the number of
 * non-zero element, when writeIndex finish updating, it will be at the next
 * index, then we can return it as it will be
 * the number of non zero element
 * 
 * Ask during facebook mock interview
 */