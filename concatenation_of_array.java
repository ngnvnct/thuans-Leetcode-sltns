public class concatenation_of_array {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i % nums.length];
        }
        return res;
    }
}

/*
https://leetcode.com/problems/concatenation-of-array/
Explanation

Time: O(n)
Space: O(n) for output array
*/