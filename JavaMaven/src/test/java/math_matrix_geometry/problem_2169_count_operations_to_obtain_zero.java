/*
 * https://leetcode.com/problems/count-operations-to-obtain-zero/
 * Explanation:
 * 
 * Do the operation until you can't
 * 
 * Time: O(log(min(num1, num2)))
 * Space: O(1)
 */

package math_matrix_geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_2169_count_operations_to_obtain_zero {
    public static int countOperations(int num1, int num2) {
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
        int testCase1Num1 = 2;
        int testCase1Num2 = 3;
        int testCase1ExpectedResult = 3;
        
        int testCase2Num1 = 10;
        int testCase2Num2 = 10;
        int testCase2ExpectedResult = 1;
        
        int testCase3Num1 = 8;
        int testCase3Num2 = 12;
        int testCase3ExpectedResult = 3;
        
        int testCase4Num1 = 15;
        int testCase4Num2 = 25;
        int testCase4ExpectedResult = 4;
        
        int testCase5Num1 = 35;
        int testCase5Num2 = 20;
        int testCase5ExpectedResult = 5;
        
        int testCase6Num1 = 0;
        int testCase6Num2 = 7;
        int testCase6ExpectedResult = 0;
        
        int testCase7Num1 = 10;
        int testCase7Num2 = 0;
        int testCase7ExpectedResult = 0;
        
        assertEquals(testCase1ExpectedResult, countOperations(testCase1Num1, testCase1Num2));
        assertEquals(testCase2ExpectedResult, countOperations(testCase2Num1, testCase2Num2));
        assertEquals(testCase3ExpectedResult, countOperations(testCase3Num1, testCase3Num2));
        assertEquals(testCase4ExpectedResult, countOperations(testCase4Num1, testCase4Num2));
        assertEquals(testCase5ExpectedResult, countOperations(testCase5Num1, testCase5Num2));
        assertEquals(testCase6ExpectedResult, countOperations(testCase6Num1, testCase6Num2));
        assertEquals(testCase7ExpectedResult, countOperations(testCase7Num1, testCase7Num2));
    }
}