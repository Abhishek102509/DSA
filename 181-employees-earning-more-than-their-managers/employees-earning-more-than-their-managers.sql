# Write your MySQL query statement below
Select e2.name as Employee from employee e1,employee e2 where e1.id = e2.managerId and e1.salary<e2.salary;