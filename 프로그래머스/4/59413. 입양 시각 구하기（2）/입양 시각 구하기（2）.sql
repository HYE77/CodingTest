WITH RECURSIVE hours AS (
SELECT 0 as hours
UNION ALL
SELECT hours + 1
FROM hours
WHERE hours < 23) 
SELECT h.hours HOUR, COALESCE(o.COUNT, 0) COUNT
FROM hours h LEFT JOIN (SELECT HOUR(DATETIME) HOUR, COUNT(*) COUNT
                        FROM ANIMAL_OUTS
                        GROUP BY 1
                        ORDER BY 1) o ON h.hours = o.HOUR