import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class majority_element {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    @Test
    public void testMajority() {
        int[] exampleOne = {3,2,3};
        assertEquals(3, majorityElement(exampleOne));

        int[] exampleTwo = {2,2,1,1,1,2,2};
        assertEquals(2, majorityElement(exampleTwo));
    }
}

/*
Explanation
The Boyer-Moore voting algorithm is one of the popular optimal algorithms which is used to find the majority element among the given elements that have more than N/ 2 occurrences. 
This works perfectly fine for finding the majority element which takes 2 traversals over the given elements, which works in O(N) time complexity and O(1) space complexity.

First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes. 
Otherwise, decrease the votes if votes become 0, select another new element as the new candidate.

Time: O(n)
Space: O(1)
*/