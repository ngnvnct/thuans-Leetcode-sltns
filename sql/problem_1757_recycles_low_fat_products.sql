/*
 * https://leetcode.com/problems/recyclable-and-low-fat-products/
 * Explanation:
 * 
 * SELECT prints the SQL output
 * FROM the table name
 * WHERE is the condition, we want the enum to be both 'Y'
 * ORDER BY is optional, sort the output in ascending order
 */
 
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y' ORDER BY 1 ASC;