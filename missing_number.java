import java.util.Arrays;

public class missing_number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int nSum = (n*(n+1)) /2;
        int sumArray = 0;
        for (int num : nums) {
            sumArray += num;
        }
        return nSum-sumArray;
    }

    public int missingNumberBit(int[] nums) {
        int bitWise = nums.length;
        for (int i = 0; i < nums.length; i++) {
            bitWise = bitWise ^ nums[i] ^ i;
        }
        return bitWise;
    }

    public int missingNumberNoFormula(int[] nums) {
        int sumArray = 0;
        for (int num : nums) {
            sumArray += num;
        }
        int n = nums.length;
        int nSum = 0;
        for (int i = 0; i <= n; i++) {
            nSum += i;
        }
        return nSum-sumArray;
    }

    public int missingNumberBinarySearch(int[] nums) {
        // Assuming the Array is sorted already, follow up
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/*
Explanation

Sum from [0....n] can be written as n(n+1) / 2
So we can just calculate the sum of the array, and take the sum from 0 to n subtract by the sum array

Bit Manipulation
XOR 
Input - Output
0 | 0 - 0
0 | 1 - 1
1 | 0 - 1
1 | 1 - 1

[9,6,4,2,3,5,7,0,1] XOR with [0,1,3,4,5,6,7,8,9], everything will be cancel out except for the missing number

9 ^ 9 ^ 0 = 0
0 ^ 6 ^ 1 = 0110 ^ 0001 = 0111 = 7
7 ^ 4 ^ 2 = 0011 ^ 0010 = 0001 = 1
1 ^ 2 ^ 3 = 0011 ^ 0011 = 0000 = 0
0 ^ 3 ^ 4 = 0011 ^ 0100 = 0111 = 7
7 ^ 5 ^ 5 = 0010 ^ 0101 = 0110 = 7
7 ^ 7 ^ 6 = 0000 ^ 0110 = 0110 = 6
6 ^ 0 ^ 7 = 0110 ^ 0111 = 0001 = 1
1 ^ 1 ^ 8 = 0000 ^ 1000 = 1000 = 8

Time: O(n)
Space: O(1)

Hypothetical, the array is sorted, we can do binary search then the idea is to find the first number such that index != nums[index]
[0,1,2,3,4,5,6,7,9]
Binary search will go left = 7, right = 8
mid = 7 + (8-7) / 2 = 7
is nums[7] == 7, yes then left = 8 
mid = 8 
is nums[8] == 8, 9 != 8, we decrement right, the loop break
we return the left pointer and get our missing number

Time: O(logn)
Space: O(1)
*/

