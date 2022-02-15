import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, color, newColor);
        dfs(image, sr - 1, sc, color, newColor);
        dfs(image, sr, sc + 1, color, newColor);
        dfs(image, sr, sc - 1, color, newColor);
    }

    @Test
    public void testFillColor() {
        int[][] exampleOne = {{1,1,1}, {1,1,0}, {1,0,1}};
        int[][] exampleTwo = {{0,0,0}, {0,0,0}};
        int[][] expectedOne = {{2,2,2}, {2,2,0}, {2,0,1}};
        int[][] expectedTwo = {{2,2,2}, {2,2,2}};
        assertArrayEquals(expectedOne, floodFill(exampleOne,1,1,2));
        assertArrayEquals(expectedTwo, floodFill(exampleTwo,0,0,2));
    }
}

/*abstract
Explanation
This is a graph problem similar to number of Islands. 
sr is starting row, and sc is starting column, and from there we want to fill it with new color. 

Three things to consider if a question can be solved using DFS
1. The base case (return condition)
2. Mark that node as visit
3. Node operations

For 1. the current node cannot exit the matrix bounding condition, different from the base color, be a node that we already visit
For 2. we set the image[sr][sc] = newColor means we already visit that cell
For 3. Recursion call stack to our adjacent cell
*/