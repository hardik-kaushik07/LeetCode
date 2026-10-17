# Write your MySQL query statement below
WITH cte1 as(SELECT  s.sales_id, o.order_id as order_id, s.name as name, o.com_id as com_id FROM SalesPerson s
left join Orders o
ON s.sales_id = o.sales_id),
cte2 as(
    SELECT c.name as name from cte1 c
    left join Company cmpni
    on c.com_id = cmpni.com_id
    WHERE cmpni.name = 'RED'
)
SELECT name as name from Salesperson 
WHERE name not in (SELECT name from cte2);