import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class paint_house {
    public int paintHouse(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[] dp = new int[3];
        for (int i = 0; i < costs.length; i++) {
            int firstHouse = costs[i][0] + Math.min(dp[1], dp[2]);
            int secondHouse = costs[i][1] + Math.min(dp[0], dp[2]);
            int thirdhouse = costs[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = firstHouse;
            dp[1] = secondHouse;
            dp[2] = thirdhouse; 
        }
        return Math.min(Math.min(dp[0],dp[1]), dp[2]);
    }

    @Test
    public void testPaintHouse() {
        int[][] one = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] two = {{7,6,2}};
        assertEquals(10, paintHouse(one));
        assertEquals(2, paintHouse(two));
    }
}


/*abstract
Exlpanation
DP Appoarch
[17,2,17]
[16,16,5]
[14,3,19]]

    0    1  2
0  17   2  17
1  18  33   7
2  21  10  37
First row, we paint 17,2,17
Second Row, we paint 16 plus the minimum of the previous row, we choose 2, 18, then if we paint the 2nd house with 16, then the minimum will be 33, and so on
At the last row, we take the minimum of the last grid
Notice, we only need to care about the previous row, we can just keep a 1-D array, and update it using the previous row information

Time: O(n * 3), O(n)
Space: O(n * 3), O(3), O(1)
*/