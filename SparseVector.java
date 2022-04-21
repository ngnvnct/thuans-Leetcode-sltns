import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    private int[] array;
    Map<Integer, Integer> mapping;

    SparseVector(int[] nums) {
        array = nums;
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                mapping.put(i, nums[i]);
            }
        }
        System.out.println(mapping);
    }

    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i] * vec.array[i];
        }
        return res;
    }

    public int dotProductSet(SparseVector vec) {
        int res = 0;
        for (Integer i : this.mapping.keySet()) {
            if (vec.mapping.containsKey(i)) {
                res += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,0,0,2,3};
        int[] num2 = {0,3,0,4,0};

        SparseVector v1 = new SparseVector(num1);
        SparseVector v2 = new SparseVector(num2);
        System.out.println(v1.dotProduct(v2));
        System.out.println(v1.dotProductSet(v2));
    }
}

/*abstract
Explanation

A sparse vector is a vector that has mostly zero values, while a dense vector is a vector where most of the elements are non-zero. 
It is inefficient to store a sparse vector as a one-dimensional array

nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Approach 1: 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

Approach 2: Use a hashmap to store the non-zero values, map the index (key) to the non-zero element (value)
Iterate through each non-zero element and update the dot product is the corresponding index has a non-zero value in the other vector

n is the length of input array, m is the number of non-zero elements
Time: O(n) to create the hashmap, O(m) to calculate the dot product
Space: O(L), for creating the hashmap and we only store non-zero elements, O(1) for calculating the dot product
*/