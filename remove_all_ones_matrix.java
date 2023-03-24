import org.junit.jupiter.api.Test;

public class remove_all_ones_matrix {
    public boolean removesOnes(int[][] grid) {
        for (int[] g : grid) {
            for (int i = 0; i < g.length; i++) {
                if ((g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testRemoveOnes() {

    }
}

/*
Explanation
[[0,1,0],[1,0,1],[0,1,0]]

int[] g = [0, 1, 0]
[1, 0, 1]
[0, 1, 0]

index 0 g[i] is 0 grid[0][i] is 0
Math abs first if 0
Math abs second part 0
index 1 g[i] is 1 grid[0][i] is 1
Math abs first if 0
Math abs second part 0
index 2 g[i] is 0 grid[0][i] is 0
Math abs first if 0
Math abs second part 0
index 0 g[i] is 1 grid[0][i] is 0
Math abs first if 1
Math abs second part 1
index 1 g[i] is 0 grid[0][i] is 1
Math abs first if 1
Math abs second part 1
index 2 g[i] is 1 grid[0][i] is 0
Math abs first if 1
Math abs second part 1
index 0 g[i] is 0 grid[0][i] is 0
Math abs first if 0
Math abs second part 0
index 1 g[i] is 1 grid[0][i] is 1
Math abs first if 0
Math abs second part 0
index 2 g[i] is 0 grid[0][i] is 0
Math abs first if 0
Math abs second part 0

Both rows have to follow the same patterns for us to be able to flip them into all 0s.
and by the same patterns, I mean for any two rows, they either have to be

Exactly the same
Exactly opposite
If there exists a pair of two rows that do not meet the requirements above, we can't flip the table into all 0s.
Reason being that we will want to perform column flip if there are two rows that don't meet the requirement above, 
but when we do col flip, all rows have 1 element flipped as well, so no matter what we do, it won't be doable.

An easy way to check if two rows meet the pattern above is pick a fixed row, comparing the difference between the first element of the two rows, 
and all the other pairs of elements on these two rows have to have the same difference.

*/
