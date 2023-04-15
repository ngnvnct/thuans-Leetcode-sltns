/*
https://leetcode.com/problems/combination-sum/
Explanation:
A Dynamic Programming problem

[2,3,6,7]
Take 2, include all the combination that sum up to the target

Decision Tree, [] means we don't include 2
               [2]                     - []
    [2,2]               [2]           [3]    []
[2,2,2]  [2,2]      [2,3] [2]               [6]  []
8    [2,2,3]  [2,2]                             [7]  []

DFS Walk through
candidates: [2,3,6,7]
index: 0
target: 7
current: [], current [2] then dfs call, current [2,2] dfs call, current [2,2,2] dfs call, target is now 1. Now it will increment the index to the last element, the recursion is now finished
we will then execute the line current.remove(current.size()-1) to pop out the last element
current [2,2,3] dfs call, then we will hit the base case, add it into our result and return, then it will remove three, then dfs call and then eventually it will remove 2 [2], now it will try to find a combination
with [2,3], then dfs call will remove everything []
then it will go to 6, and finally 7
res: [[2,2,3]]

Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates

Time: O(N ^ ((T/M) + 1))
Space: O(T/M)
*/

package backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class problem_0039_combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtracking(0, 0, target, candidates, res, curr);
        return res;
    }

    public void backtracking(int currIndex, int total, int target, int[] candidates, List<List<Integer>> result,
            List<Integer> current) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (currIndex >= candidates.length || total > target) {
            return;
        }
        current.add(candidates[currIndex]);
        backtracking(currIndex, total + candidates[currIndex], target, candidates, result, current);
        current.remove(current.size() - 1);
        backtracking(currIndex + 1, total, target, candidates, result, current);
    }

    @Test
    public void testCombinationSum() {
        // Test case 1: Example case
        int[] testCase1 = { 2, 3, 6, 7 };
        int target1 = 7;
        List<List<Integer>> testCase1ExpectedResult = List.of(List.of(2, 2, 3), List.of(7));
        assertEquals(testCase1ExpectedResult, combinationSum(testCase1, target1));

        // Test case 2: Empty candidates array
        int[] testCase2 = {};
        int target2 = 10;
        List<List<Integer>> testCase2ExpectedResult = List.of();
        assertEquals(testCase2ExpectedResult, combinationSum(testCase2, target2));

        // Test case 3: No valid combinations
        int[] testCase3 = { 2, 5, 9 };
        int target3 = 7;
        List<List<Integer>> testCase3ExpectedResult = List.of(List.of(2,5));
        assertEquals(testCase3ExpectedResult, combinationSum(testCase3, target3));

        // Test case 4: Single element in candidates array
        int[] testCase4 = { 1 };
        int target4 = 1;
        List<List<Integer>> testCase4ExpectedResult = List.of(List.of(1));
        assertEquals(testCase4ExpectedResult, combinationSum(testCase4, target4));
    }
}
