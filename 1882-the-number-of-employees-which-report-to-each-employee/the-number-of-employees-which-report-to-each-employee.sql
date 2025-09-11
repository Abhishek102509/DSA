# Write your MySQL query statement below
select e2.employee_id , e2.name  , 
count(e1.employee_id) as reports_count ,
round(Avg(e1.age),0) as average_age from Employees e1 
join employees e2 on e1.reports_to = e2.employee_id
group by employee_id
order by employee_id