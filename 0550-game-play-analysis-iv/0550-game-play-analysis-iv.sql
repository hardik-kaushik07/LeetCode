with cte as(
select *,
DATEDIFF(event_date, lag(event_date,1) over(partition by player_id order by event_date)) as datedifference,
 ROW_NUMBER() OVER(
            PARTITION BY player_id
            ORDER BY event_date
        ) AS rn
from activity
)

select ROUND(Count(distinct case when datedifference=1 and rn = 2 then player_id end) 
/  count(distinct player_id), 2 ) as fraction from cte;
