import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        triangle sol = new triangle();
        System.out.println(sol.minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1]; // last row of 0

        // Bottom Up
        for (int level = triangle.size()-1; level>= 0; level--) {
            for (int j = 0; j < triangle.get(level).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(level).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for (int level = triangle.size()-1; level >= 0; level--) {
            for (int j = 0; j < triangle.get(level).size(); j++) {
                dp[level][j] = Math.min(dp[level+1][j], dp[level+1][j+1]) + triangle.get(level).get(j);
            }
        }

        return dp[0][0];
    }

    @Test
    public void testTriangle() {
        List<List<Integer>> testCase1 = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        int testCase1ExpectedResult = 11;
        List<List<Integer>> testCase2 = List.of(List.of(-10));
        int testCase2ExpectedResult = -10;

        assertEquals(testCase1ExpectedResult, minimumTotal(testCase1));
        assertEquals(testCase2ExpectedResult, minimumTotal(testCase2));
        assertEquals(testCase1ExpectedResult, minimumTotal2(testCase1));
        assertEquals(testCase2ExpectedResult, minimumTotal2(testCase2));
    }
}

/* 
https://leetcode.com/problems/triangle/
Explanation

Time: O(n^2)
Space: O(n) or O(n^2)
*/