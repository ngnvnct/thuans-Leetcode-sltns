public class number_of_one_bits {
   /*
   Note that in some languages, such as Java, there is no unsigned integer type. 
   In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
   In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3
   */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count += 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>>1;
        }
        return count;
    }
}


/*
Explanation

First, >>> is for calcuting unsigned bits, and >> is for signed bits.

Method 3, we take the input n in bit "AND" with 1 (000000000001), and if this operation result is 1, that means the last bit of the input integer is 1. Thus we add it to the 1s count
AND Gate
0 | 0 - 0
0 | 1 - 0
1 | 0 - 0
1 | 1 - 1

Use bit shifting unsigned operation
In Java we need to put attention on the fact that the maximum integer is 2147483647. Integer type in Java is signed and there is no unsigned int. So the input 2147483648 is represented in Java as -2147483648 (in java int type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
This force us to use

n!=0

in the while condition and we cannot use

n>0

because the input 2147483648 would correspond to -2147483648 in java and the code would not enter the while if the condition is n>0 for n=2147483648.

n = 00000000000000000000000000001011
Logical Right Shifts
When shifting right with a logical right shift, the least-significant bit is lost and a 00 is inserted on the other end
1011 >>> 1 -> 0101
1011 >>> 3 -> 0001
For positive numbers, a single logical right shift divides a number by 2, throwing out any remainders

We keep shifting, and "AND" with the 1 bits, eventually we will finish counting all the number of 1.

Time: O(1) because n in this piece of code is a 32-bit integer
Space: O(1)
*/
