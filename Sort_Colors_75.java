import java.util.Arrays;

public class Sort_Colors_75 {
    public static void main(String[] args) {
        int[] exampleOne = { 2, 0, 1, 0, 1, 2 };
        int[] exampleTwo = { 2, 1, 0 };
        System.out.println("Before sort: " + Arrays.toString(exampleOne));
        System.out.println("Before sort: " + Arrays.toString(exampleTwo));

        Sort_Colors_75 sol = new Sort_Colors_75();
        sol.sortColors(exampleOne);
        sol.sortColors(exampleTwo);

        System.out.println("After sort " + Arrays.toString(exampleOne));
        System.out.println("After sort " + Arrays.toString(exampleTwo));

        exampleOne = new int[] { 2, 0, 1, 0, 1, 2 };
        exampleTwo = new int[] { 2, 1, 0 };
        System.out.println("Before sort: " + Arrays.toString(exampleOne));
        System.out.println("Before sort: " + Arrays.toString(exampleTwo));

        sol.sortColors2(exampleOne);
        sol.sortColors2(exampleTwo);

        System.out.println("After sort " + Arrays.toString(exampleOne));
        System.out.println("After sort " + Arrays.toString(exampleTwo));
    }

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;

        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int zeroIndex = 0;
        int currIndex = 0;
        int twoIndex = nums.length - 1;

        while (currIndex <= twoIndex) {
            if (nums[currIndex] == 0) {
                int temp = nums[currIndex];
                nums[currIndex++] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            } else if (nums[currIndex] == 2) {
                int temp = nums[currIndex];
                nums[currIndex] = nums[twoIndex];
                nums[twoIndex--] = temp;
            } else {
                currIndex++;
            }
        }
    }
}

/*
 * https://leetcode.com/problems/sort-colors/
 * Explanation
 * 
 * The two passes solution use counting sort, count the number of 0 and 1 and
 * fill the array with it.
 * 
 * The one pass solution uses two pivot point. We have a current index, a zero
 * index and a two index (end of the array, decrement each time)
 * if the current num is 0, we swap it with the element at zero index and
 * increment both current and zero
 * else if the current num is 2, we swap it with the element at two index (end
 * of the array) and ONLY decrement the two index
 * else the current num is 1, we just increment the current index
 * 
 * Time: O(n)
 * Space: O(n) if count input array, O(1) otherwise
 */