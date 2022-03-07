

public class reverse_bits {
    public int reverseBits(int n) {
        int res = 0;
        int power = 31;
        while (n != 0) {
            res += (n & 1) << power;
            n = n >>> 1;
            power -= 1;
        }
        return res;
    }
}


/*abstract
Explanation

00000010100101000001111010011100
                               _ 
001.........

How to get bit by bit, take the first bit "AND" with a 1, we want to know if this is a 0 or 1
How to get the next spot, we shift the 1 to the right
if we have a 1, we shift it by 31, and logic "OR" to find what to replace it with, if the bit is "1", OR will keep it

The key idea is that for a bit that is situated at the index i, after the reversion, its position should be 31-i (note: the index starts from zero).
We iterate through the bit string of the input integer, from right to left (i.e. n = n >>> 1). To retrieve the right-most bit of an integer, we apply the bit AND operation (n & 1).
For each bit, we reverse it to the correct position (i.e. (n & 1) << power). Then we accumulate this reversed bit to the final result.
When there is no more bits of one left (i.e. n == 0), we terminate the iteration.

Time: O(1)
Space: O(1)
*/