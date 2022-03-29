import java.util.Arrays;

public class sort_colors {
    public static void main(String[] args) {
        int[] one = {2,0,1,0,1,2};
        int[] two = {2,1,0};
        System.out.println("Before sort: " + Arrays.toString(one));
        System.out.println("Before sort: " + Arrays.toString(two));

        sort_colors sol = new sort_colors();
        sol.sortColors(one);
        sol.sortColors(two);

        System.out.println("After sort " + Arrays.toString(one));
        System.out.println("After sort " + Arrays.toString(two));

        one = new int[] {2,0,1,0,1,2};
        two = new int[] {2,1,0};
        System.out.println("Before sort: " + Arrays.toString(one));
        System.out.println("Before sort: " + Arrays.toString(two));

        sol.sortColors2(one);
        sol.sortColors2(two);

        System.out.println("After sort " + Arrays.toString(one));
        System.out.println("After sort " + Arrays.toString(two));
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
        int twoIndex = nums.length-1;

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
Explanation

The two passes solution use counting sort, count the number of 0 and 1 and fill the array with it.

The one pass solution uses two pivot point. We have a current index, a zero index and a two index (end of the array, decrement each time)
if the current num is 0, we swap it with the element at zero index and increment both current and zero
else if the current num is 2, we swap it with the element at two index (end of the array) and ONLY decrement the two index
else the current num is 1, we just increment the current index

Time: O(n)
Space: O(n) if count input array, O(1) otherwise
*/