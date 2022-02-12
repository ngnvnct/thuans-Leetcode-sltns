import java.util.HashMap;
import java.util.Map;

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
}

/*
Explanation
If the diff does not exist, add a default value of 0. Store the current Sum in a hash map with a counter, then add to the result if there is a current sum - k target key.

Time: O(n)
Space: O(n)
*/