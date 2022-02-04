public class move_zeroes {
    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[currentIndex];
                nums[currentIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

/*
Explantion:
We want to loop through an Array and check for index that doesn't have a 0. We keep an index at the start of the Array
and only increment it after we swap it with the current element that is not 0.

Time: O(n), looping through n elements of Array
Space: O(1), input array doesn't count
*/