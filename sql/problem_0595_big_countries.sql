/*
 * https://leetcode.com/problems/big-countries/
 * Explanation:
 * 
 * SELECT name, population, area for output
 * FROM the table name
 * WHERE is the condition, we want to get the output if the area is that much OR
 * the population is that big
 * just like if else
 */

SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000