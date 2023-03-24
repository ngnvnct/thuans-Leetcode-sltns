import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class knights_moves {
    public static void main(String[] args) {
        knights_moves sol = new knights_moves();
        System.out.println(sol.minSteps(4, 4, 4, 8, 9));
        System.out.println(sol.minSteps(5, 1, 0, 5, 6));
        System.out.println(sol.minSteps(0, 0, 0, 2, 10));
    }

    static class position {
        int x, y, distance;
        position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public boolean isValid(int x, int y, int n) {
        if (x >= 0 && x < n && y >=0 && y < n) {
            return true;
        }
        return false;
    }

    public int minSteps(int startRow, int startCol, int endRow, int endCol, int n) {
        int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};

        Queue<position> queue = new LinkedList<position>();
        queue.add(new position(startRow, startCol, 0));
        position pos;
        int a, b;
        boolean visited[][] = new boolean[n][n];
        for (int i =0; i< n; i++) {
            Arrays.fill(visited[i], false);
        }

        visited[startRow][startCol] = true;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            if (pos.x == endRow && pos.y == endCol)  {
                return pos.distance;
            }

            for (int i = 0; i < 8; i++) {
                a = pos.x + x[i];
                b = pos.y + y[i];
                if (isValid(a,b,n) && !visited[a][b]) {
                    visited[a][b] = true;
                    queue.add(new position(a,b,pos.distance+1));
                }
            }
        }
        return -1;
    }

    @Test
    public void testKnightMoves() {
        assertEquals(2, minSteps(4,4,4,8,9));
        assertEquals(3, minSteps(5,1,0,5,6));
        assertEquals(2, minSteps(0,0,0,2,10));
    }
}



/*abstract
Given a chess board of n rows (top to bottom) and n columns
In each move, a knight moves either 2 column positions and 1 row position
w row position and 1 colukn position

Given a starting position A and ending position B, calculate the minimum number of moves needed by the knight to move from A to B if it is possible
return -1 otherwise.

n =9, startRow = 4, endRow = 4, endCol = 8 
Size 9 x 9
Step 1: from (4,4) to (3,6) or (5,6)
Step 2: to (4,8)
Minimum number is 2


The idea is to use bfs to find the minimum steps
Run bfs on all 8 directions, if it is reachable and it is not already visited we push it to the queue

This is an x and y axis
int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};

a knight can moves to the left of the x axis 2, and down y 1, valid move
*/