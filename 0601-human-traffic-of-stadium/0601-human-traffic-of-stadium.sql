select id, visit_date, people from (
select *, row_number() over(order by id) as rn,
id-row_number() over(order by id) as grp
from stadium
where people>= 100) t
where grp in (
select grp from (
select *, row_number() over(order by id) as rn,
id-row_number() over(order by id) as grp
from stadium
where people>= 100) t1
group by grp
having count(grp)>=3);