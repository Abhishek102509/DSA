# Write your MySQL query statement below
Select activity_date as day,count(Distinct user_id) as active_users
from Activity
WHERE (activity_date > "2019-06-27" AND activity_date <= "2019-07-27")
group by activity_date;