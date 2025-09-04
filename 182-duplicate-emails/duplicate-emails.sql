# Write your MySQL query statement below
SELECT Email from person 
GROUP BY email
HAVING COUNT(email)>1;