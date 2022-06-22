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
            for (int j = 0; j <= triangle.get(level).size(); j++) {
                dp[level][j] = Math.min(dp[level+1][j], dp[level+1][j+1]) + triangle.get(level).get(j);
            }
        }

        return dp[0][0];
    }

    @Test
    public void testTriangle() {
        List<List<Integer>> exampleOne = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        List<List<Integer>> exampleTwo = List.of(List.of(-10));
        assertEquals(11, minimumTotal(exampleOne));
        assertEquals(-10, minimumTotal(exampleTwo));
        assertEquals(11, minimumTotal2(exampleOne));
        assertEquals(-10, minimumTotal2(exampleTwo));
    }
}

/* 
https://leetcode.com/problems/triangle/
Explanation

Time: O(n^2)
Space: O(n) or O(n^2)
*/