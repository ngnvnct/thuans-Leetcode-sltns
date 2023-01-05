using NUnit.Framework;
using solution;

namespace tests
{
    public class Tests
    {
        solution.Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        public void TestTwoSum()
        {
            //Assert.AreEqual(new int[] { 1, 2 }, sol.TwoSum(new int[] { 0, 1, 2 }, 3));
           // Assert.AreNotEqual(new int[] { 0, 2 }, sol.TwoSum(new int[] { 0, 1, 2 }, 3));
        }
    }
}