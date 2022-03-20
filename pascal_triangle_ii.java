import java.util.ArrayList;
import java.util.List;

public class pascal_triangle_ii {
    
    public static void main(String[] args) {
        pascal_triangle_ii Solution = new pascal_triangle_ii();
        System.out.println(Solution.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) {
            row.add(0,1);
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            res.add(new ArrayList<>(row));
        }
        return res.get(rowIndex);
    }
}

/*abstract
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


at the end we just return res.get(rowIndex) and we get our result

Time: O(n^2)
Space: O(n^2)
*/