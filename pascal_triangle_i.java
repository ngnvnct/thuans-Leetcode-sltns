import java.util.ArrayList;
import java.util.List;

public class pascal_triangle_i {

    public static void main (String[] args) {
        pascal_triangle_i Solution = new pascal_triangle_i();
        Solution.generate(6);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            //System.out.println(row.toString());
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            res.add(new ArrayList<>(row));
            System.out.println("row " + i + " value " + res.get(i)); // keep this line
        }
        return res;
    }
}

/*
Explanation
row 0 value [1]
row 1 value [1, 1]
row 2 value [1, 2, 1]
row 3 value [1, 3, 3, 1]
row 4 value [1, 4, 6, 4, 1]
row 5 value [1, 5, 10, 10, 5, 1]

row 0, we add 1 into it, and add it into our result
row 1, we add 1 into index 0, row now has [1,1]. J loop doesn't run yet
row 2, we add 1 into index 0, row now has [1,1,1]. J loop starts running, row.set to replace the element at index (j), and change it to 1+1 = 2 and add a new one to the arraylist [1,2,1]
row 3, we add 1 into index 0, row now has [1,1,2,1]. J Loop starts, row.set to replace the element at index (j), 1+2 = 3, 2 + 1 = 3, and add a new one to the arraylist [1,3,3,1]
row 4, we add 1 into index 0, row now has [1,1,3,3,1]. J Loops start.....
row 5, we add 1 into index 0, row now has [1,1,4,6,4,1]. J loops start....

Time: O(n)
Space: O(n)
*/