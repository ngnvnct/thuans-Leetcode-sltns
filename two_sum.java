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
