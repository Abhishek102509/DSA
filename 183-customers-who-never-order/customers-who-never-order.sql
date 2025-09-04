-- # Write your MySQL query statement below
-- select c.name as Customers from  Orders o,customers c where c.id =o.customerId; 


-- SELECT name AS Customers
-- FROM Customers
-- WHERE id NOT IN (
--     SELECT customerId FROM Orders
-- );

SELECT name AS Customers
FROM Customers c
WHERE NOT EXISTS (
    SELECT *
    FROM Orders o
    WHERE o.customerId = c.id
);
