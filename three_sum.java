import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {

    public static void main (String[] args) {
        int[] exampleOne = {-1,0,1,2,-1,-4};
        int[] exampleTwo = new int[] {};
        int[] exampleThree = {0};
        int[] exampleFour = {-3,-3,1,2,3,4};
        int[] exampleFive = {-2,-2,0,0,2,2};
        three_sum Solution = new three_sum();
        System.out.println(Arrays.toString(Solution.threeSum(exampleOne).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleTwo).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleThree).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleFour).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleFive).toArray()));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {  // SKip same result
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            int target = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum < target) {
                    left++;
                } else if (twoSum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    //right--;
                    while (left < right && nums[left] == nums[left-1]) { // skip same result
                        left++;
                    }
                    //while (left < right && nums[right] == nums[right+1]) { // skip same result
                    //    right++;
                   // }
                }
            }
        }
        return res;
    }    
}

/*abstract
Explanation
Sort the array, iterate through the list and use another two pointers (two sum) to apporach the target

In the else statement
It is equal to 0, we add it to the result. Then we have to update the pointer.
[-2,-2,0,0,2,2], we find the solution already, we increment left, we find a dupe, we increment left again, then our loop will shift in the if statement
We only have to update one pointer, and the conditions above will update the other pointers

Time: O(n^2)
Space: O(1) or O(n) depend on sort library
*/