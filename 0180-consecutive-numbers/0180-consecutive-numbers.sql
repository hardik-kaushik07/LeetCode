# Write your MySQL query statement below
with cte as(
select id, num,
lag(num, 1)  over(order by id) as lags1,
lag(num, 2) over(order by id) as lags2
from Logs
group by id, num)

select distinct num as ConsecutiveNums from cte where num = lags1 and num = lags2;

