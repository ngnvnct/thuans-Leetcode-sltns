import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class max_consecutive_ones {

    public static void main(String[] args) {
        int[] input = new int[] {1,1,0,1,1,1};
        max_consecutive_ones solution = new max_consecutive_ones();
        System.out.println(solution.findMaxConsecutiveOnes(input));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxConsecutive = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxConsecutive = Math.max(maxConsecutive, count);
            } else {
                count = 0;
            }
        }
        return maxConsecutive;
    }

    @Test
    public void testMaxConsecutiveOnes() {
        int[] exampleOne = new int[] {1,1,0,1,1,1};
        int expected = 3;
        assertEquals(expected, findMaxConsecutiveOnes(exampleOne));

        int[] exampleTwo = new int[] {1,0,1,1,0,1};
        expected = 2;
        assertEquals(expected, findMaxConsecutiveOnes(exampleTwo));
    }
}

/*
Explanation:

We keep a counter variable to count the number of 1 that appear consecutively in the array, and  a consecutive variable to save it. The consecutive variable 
will be the maximum value between counter and itself

Time: O(n), loop through the Array
Space: O(1),

*/
