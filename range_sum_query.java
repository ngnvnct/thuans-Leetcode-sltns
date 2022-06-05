public class range_sum_query {
    private int[] prefixSum;

    public range_sum_query(int[] nums) {
        prefixSum = new int[nums.length+1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1] - prefixSum[left];
    }

    public static void main(String[] args) {
        range_sum_query numArray = new range_sum_query(new int[] {-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

class range_sum_query_2 {
    private int[] sum;

    public range_sum_query_2(int[] nums) {
        sum = nums;
    }

    public int sumRange(int left, int right) {
        int currSum = 0;
        for (int i = left; i <= right; i++) {
            currSum += sum[left];
        }
        return currSum;
    }

    public static void main(String[] args) {
        range_sum_query numArray = new range_sum_query(new int[] {-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

/*
https://leetcode.com/problems/range-sum-query-immutable/
Explanation

Brute Force Method 2 : each time sumRange is called we run a loop to sum each individual element from index left to right; 
Time: O(n) per query, Space: O(1), sum is a reference to nums and is not a copy of it, and O(n) for input

Caching: imagine if we called sumRange a thousand times, with the exact same arguments sumRange(5), sumRange(5),... we can speed it up by caching it.
We use a method called prefix sum, we insert a dummy 0 as the first element in the prefixSum array, saves a conditional check in sumRange function

Array Input[-2,0,3,-5,2,-1]
Prefix Sum [0,-2,-2,1,-4,-2,-3]

sumRange(0,2) = prefixSum(right+1) - prefixSum(left) = prefixSum(3) - prefixSum(0) = 1
sumRaneg(2,5) = prefixSum(6) - prefixSum(2) = -3 -(-2) = -1
sumRange(0, 5) = prefixSum(6) - prefixSum(0) = -3 - 0 = -3
*/