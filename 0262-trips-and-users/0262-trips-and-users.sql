# Write your MySQL query statement below
with cte1 as(
    select request_at, count(1) as total_request, 
    sum( case when temp1.status in ('cancelled_by_driver', 'cancelled_by_client') then 1 else 0 end) as cancel_requests
    from (select t.status, t.request_at from trips t
    Join users u on u.users_id = t.client_id 
	Join users d on d.users_id = t.driver_id
    where u.banned = 'NO' and d.banned = 'No' and t.request_at between '2013-10-01' AND '2013-10-03') as temp1
    group by request_at
    )
    select request_at as Day, CAST(1.0 * cancel_requests / total_request AS DECIMAL(10,2)) AS `Cancellation Rate` from cte1;