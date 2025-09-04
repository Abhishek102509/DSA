# Write your MySQL query statement below
Select d.name as Department,
e.name as Employee,
e.salary as Salary
 from Department d,Employee e where e.departmentId = d.id
 and e.salary =(select max(salary)
 from Employee 
 where departmentId = e.DepartmentId);