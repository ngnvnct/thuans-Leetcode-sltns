using System;
using Two_Sum_0001;

namespace Leetcode
{
    class Program
    {
        static void Main(string[] args)
        {
            Solution sol = new Solution();
            Array.ForEach(sol.TwoSum(new int[] { 0, 1, 2 }, 3), Console.WriteLine);
        }
    }
}
