import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class subarray_sum_equals_k {
    public int subArraySum(int[] nums, int k) {
        int currSum = 0, result = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return result;
    }

    public int subArraySpace(int[] nums, int k) {
        int result = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public int subArrayEasy(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> sumOccurrencesMap = new HashMap<>();
        sumOccurrencesMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumOccurrencesMap.containsKey(sum-k)) {
                res += sumOccurrencesMap.get(sum-k);
            }
            sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0)+1);
        }
        return res;
    }

    @Test
    public void testSum() {
        int[] testCase1 = {1,1,1};
        int[] testCase2 = {1,2,3};
        int[] testCase3 = {3,4,7,2,-3,1,4,2};

        assertEquals(2, subArrayEasy(testCase1, 2));
        assertEquals(2, subArraySpace(testCase1, 2));
        assertEquals(2, subArraySum(testCase1, 2));
        assertEquals(2, subArrayEasy(testCase2, 3));
        assertEquals(2, subArraySpace(testCase2, 3));
        assertEquals(2, subArraySum(testCase2, 3));
        assertEquals(4, subArrayEasy(testCase3, 7));
        assertEquals(4, subArraySpace(testCase3, 7));
        assertEquals(4, subArraySum(testCase3, 7));
    }
}

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Explanation

Array [1,2,3,4]
Sub Array: {}, {1}, {2}, {3}, {4}, {1,2}, {2,3}, {3,4}
{3,4}, {1,2,3,4}

Brute Force
Find the sum on the go while considering different end points.
Whenever sum equals k, update result.

Time: O(n^2)
Space: O(1)

If the diff does not exist, add a default value of 0. 
Store the current Sum in a hash map with a counter, then add to the result if there is a current sum - k target key.
[3,4,7,2,-3,1,4,2]
7
Res = 4
Sub Array [3,4], [7], [7,2,-3,1] and [1,4,2] are subarrays add up to k

Better Explanation
The HashMap will store with the key being any particular sum, and the value being the number of times it has happened till the current iteration of the loop

k = 26
sub-array sums up to k, then the sum at the end of this sub-array will be sumEnd = sumStart + k
sumStart = sumEnd -k
Suppose at index 10, sum = 50, next 6 numbers are 8, -5, -3, 10, 15,1
At index 13, sum = 50 again, (8 + (-5) + (-3) = 0)
At index 16, sum = 76
sum -k = 76-26 = 50. So if this is the end index of a sub-array(s) which sums up to k, then before this, just before the start of the sub array, the sum should be 50
We found sum =50 at two places before reaching index 16, we have two sub-arrays which sum up to k(26) (index 14 to 16) and indexes 11 to 16

At each sum, if there is a presum exists, then there is a subarray between this sum and presum. 

We put (0,1) for the a possible answer exist right at the start of the array

Time: O(n)
Space: O(n)
*/