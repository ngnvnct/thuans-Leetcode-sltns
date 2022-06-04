SELECT name
FROM Customer
WHERE referee_id <> 2 OR referee_id IS NULL;

/*
https://leetcode.com/problems/find-customer-referee/
Explanation

SELECT name for the output
FROM Customer table
WHERE is the condition, use <> for not equal too and not !=, OR referee_ID IS NULL
IS NULL to check for NULL, or IS NOT NULL

Some pitfall
SELECT name FROM customer WHERE referee_Id <> 2;
this doesn't check NULL value

SELECT name FROM customer WHERE referee_id = NULL OR referee_id <> 2;
referee_id = NULL is wrong
*/