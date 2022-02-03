import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class two_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        two_sum solution = new two_sum();
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            map.put(target-nums[i], i);
        }
        return ans;
    }

    @Test
    public void testTwoSum() {
        int[] expectedOutput = new int[]{0,1};
        int[] exampleOne = new int[]{2,7,11,15};
        int exampleTarget = 9;
        assertArrayEquals(expectedOutput, twoSum(exampleOne, exampleTarget));

        expectedOutput = new int[]{1,2};
        int[] exampleTwo = new int[]{3,2,4};
        exampleTarget = 6;
        assertArrayEquals(expectedOutput, twoSum(exampleTwo, exampleTarget));

        expectedOutput = new int[]{0,1};
        int[] exampleThree = new int[]{3,3};
        exampleTarget = 6;
        assertArrayEquals(expectedOutput, twoSum(exampleThree, exampleTarget));
    }
}

/*
Explantion:
We want to make a HashMap to keep trace of the difference of the element. First, we have an if-statement asking is the HashMap contains this element
If yes, we return the value of the key-value pair, along with the current index
Else, we put the key as the difference (target-nums[i]), and the value is the current index

Line 18 and 19 can be replace by return new int[] {map.get(nums[i]), i};

Time: O(n), looping through n elements of Array
Space: O(n), storing the Array in HashMap
*/