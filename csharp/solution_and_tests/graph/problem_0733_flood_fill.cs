/*
 * https://leetcode.com/problems/flood-fill/
 * Explanation:
 * 
 * This is a graph problem similar to number of Islands.
 * sr is starting row, and sc is starting column, and from there we want to fill
 * it with new color.
 * 
 * Three things to consider if a question can be solved using DFS
 * 1. The base case (return condition)
 * 2. Mark that node as visit
 * 3. Node operations
 * 
 * For 1. the current node cannot exit the matrix bounding condition, different
 * from the base color, be a node that we already visit
 * For 2. we set the image[sr][sc] = newColor means we already visit that cell
 * For 3. Recursion call stack to our adjacent cell
 * 
 * Time: O(n) number of pixels in the image
 * Space: O(n) is the size of the call stack
 */

using NUnit.Framework;

namespace Flood_Fill
{
    class Solution
    {
        public int[][] FloodFill(int[][] image, int sr, int sc, int newColor)
        {
            if (image[sr][sc] == newColor)
            {
                return image;
            }
            Fill(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        private void Fill(int[][] image, int sr, int sc, int floodFillColor, int newColor)
        {
            if (sr < 0 || sr >= image.Length || sc < 0 || sc >= image[0].Length || image[sr][sc] != floodFillColor)
            {
                return;
            }
            image[sr][sc] = newColor;
            Fill(image, sr + 1, sc, floodFillColor, newColor);
            Fill(image, sr - 1, sc, floodFillColor, newColor);
            Fill(image, sr, sc + 1, floodFillColor, newColor);
            Fill(image, sr, sc - 1, floodFillColor, newColor);
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
        [TestCase(1, 1, 2)]
        public void TestFloodFill(int sr, int sc, int newColor)
        {
            int[][] testCase1 = new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 } };
            int[][] testCase1ExpectedResult = new int[][] { new int[] { 2, 2, 2 }, new int[] { 2, 2, 0 }, new int[] { 2, 0, 1 } };

            Assert.AreEqual(testCase1ExpectedResult, sol.FloodFill(testCase1,sr,sc,newColor));
        }

        [Test]
        [TestCase(0, 0, 0)]
        public void TestFloodFill2(int sr, int sc, int newColor)
        {
            int[][] testCase2 = new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 } };
            int[][] testCase2ExpectedResult = new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 } };

            Assert.AreEqual(testCase2ExpectedResult, sol.FloodFill(testCase2, sr, sc, newColor));
        }
    }
}
