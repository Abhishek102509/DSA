# Write your MySQL query statement below
select customer_id from  customer 
group by customer_id
Having count(distinct product_key) = 
(select count(product_key) from product);