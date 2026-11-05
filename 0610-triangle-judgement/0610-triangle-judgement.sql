# Write your MySQL query statement below
SELECT *, CASE WHEN x+y>z AND z+y>x AND z+x>y THEN 'Yes' ELSE 'No'END as triangle
FROM Triangle