using System;
using Two_Sum;

namespace Leetcode
{
    class Program
    {
        static void Main(string[] args)
        {
            Array.ForEach(Solution.TwoSum(new int[] { 0, 1, 2 }, 3), Console.WriteLine);
        }
    }
}
