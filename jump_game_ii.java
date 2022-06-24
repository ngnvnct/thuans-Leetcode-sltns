import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class jump_game_ii {
    public int jump(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length-1) {
            int farthest = 0;
            for (int i = left; i < right+1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right+1;
            right = farthest;
            res += 1;
        }
        return res;
    }

    public int jump2(int[] nums) {
        int res = 0;
        int prevFarthest = 0;
        int currFarthest = 0;
        for (int i = 0; i < nums.length-1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == prevFarthest) {
                res++;
                prevFarthest = currFarthest;
            }
        }
        return res;
    }

    @Test
    public void testJump() {
        int[] exampleOne = {2,3,1,1,4};
        assertEquals(2, jump(exampleOne));
        assertEquals(2, jump2(exampleOne));
    }
}

/*
https://leetcode.com/problems/jump-game-ii/
Explanation
Jump1 is also a greedy BFS solution, the level tells how many step you need to reach each level. Left and right is a window. and the for loop will check for the farthest jump.

Jump2 is a bfs solution, i == curEnd means I visited all the items on the current level, increment res++ is like incrementing the level you are on. currEnd = currFarthest is getting queue size
for the next level I am traversing

...3 [5 2 1] 4 1 6 2
    start end
If you are at 3, you can jump to 5 2 1, which would you choose. "Greedy" jump may end up in a place with small jump power
We have to determine which place will take us the farthest in the next jump


Time: O(n)
Space: O(1)
*/