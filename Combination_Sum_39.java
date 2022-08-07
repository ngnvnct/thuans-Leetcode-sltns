import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    public void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                dfs(candidates, i, target-candidates[i], current, res);
                current.remove(current.size()-1);
            }
        }
    }
}

/*
https://leetcode.com/problems/combination-sum/
Explanation
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