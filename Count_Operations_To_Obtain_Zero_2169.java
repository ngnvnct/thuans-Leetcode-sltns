import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Count_Operations_To_Obtain_Zero_2169 {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int operation = 0;
        while (true) {
            if (num1 >= num2) {
                num1 = num1 - num2;
                operation++;
            } else {
                num2 = num2 - num1;
                operation++;
            }
            if (num1 == 0 || num2 == 0) {
                break;
            }
        }
        return operation;
    }

    @Test
    public void testCount() {
        assertEquals(3, countOperations(2, 3));
        assertEquals(1, countOperations(10, 10));
    }
}

/*
 * https://leetcode.com/problems/count-operations-to-obtain-zero/
 * Explanation
 * 
 * Do the operation until you can't
 * 
 * Time: O(log(min(num1, num2)))
 * Space: O(1)
 */