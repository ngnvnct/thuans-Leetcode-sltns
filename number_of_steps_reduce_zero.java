import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class number_of_steps_reduce_zero {
    public int numberOfSteps(int num) {
        int count = 0;
        //System.out.println(Integer.toBinaryString(num));
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }

    public int numberOfStepsRecursion(int num) {
        if (num == 0) {
            return 0;
        } else if(num % 2 == 0) {
            return (numberOfStepsRecursion(num/2) + 1);
        } else if (num % 2 == 1) {
            return (numberOfStepsRecursion(num-1) + 1);
        }
        return 0;
    }

    public int numberOfStepsBinary(int num) {
        String binary = Integer.toBinaryString(num);
        //System.out.println(binary);
        int count = 0;
        for (char s : binary.toCharArray()) {
            if (s == '1') {
                count += 2;
            } else {
                count += 1;
            }
        }
        return count-1;
    }

    @Test
    public void testNumber() {
        assertEquals(6, numberOfSteps(14));
        assertEquals(6, numberOfStepsBinary(14));
        assertEquals(6, numberOfStepsRecursion(14));
        assertEquals(4, numberOfSteps(8));
        assertEquals(4, numberOfStepsBinary(8));
        assertEquals(4, numberOfStepsRecursion(8));
    }
}

/*abstract
Explanation
Simulation and Recursive are simple enough.

Counting Bits
At each step, we either subtract 1 from num, or divide num by 2. Odd number in binary always have a last bit of 1. 
Subtracting 1 from an odd number changes the last bit from 1 to 0.
Dividing by 2 removes the last bit from the number.
The 0's took one step to remove, and the 1's took two steps to remove
To get our answer, we can add two steps for every 1, and add one step for every 0 for each bit in the binary representation

210: 1101 0010, divide by 2
105: 0110 1001, subtract 1
104: 0110 1000, divide by 2
52:  0011 0100, divide by 2
26:  0001 1010, divide by 2
13:  0000 1101, subtract by 1
12:  0000 1100, divide by 2
6:   0000 0110, divide by 2
3:   0000 0011, subtract 1
2:   0000 0010, divide by 1
1:   0000 0001, subtract by 1
0:   0000 0000, Done
One thing to be careful, we don't want to count the last bit as two steps, we can subtract 1 from our final steps count.

Time: O(logn), n is halved at every step
Space: O(1), O(log n) for recursion
*/