/*
 * https://leetcode.com/problems/swap-salary/
 * Explanation:
 * 
 * Two ways to do this using IF or CASE WHEN
 * 
 * UPDATE statemnet is used to modify the existing records in a table
 * 
 * IF function returns a value of a condition is TRUE, else FALSE
 * IF(condition, value_if_true, value_if_false)
 * 
 * SET command is used with UPDATE to specify which columns
 * and values that should be updated in a table
 * https://www.w3schools.com/sql/sql_ref_set.asp
 * 
 * CASE statement goes through conditions and returns a value
 * when the first condition is met (just like if-else), and ends with an END
 * https://www.w3schools.com/sql/sql_case.asp
 */

UPDATE Salary SET sex= IF(sex='m','f', 'm')

UPDATE Salary
SET sex=
CASE 
   WHEN sex='m' THEN 'f' 
   WHEN sex='f' THEN 'm' 
END;