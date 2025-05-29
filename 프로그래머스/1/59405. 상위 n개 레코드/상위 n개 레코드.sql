-- 코드를 입력하세요
# SELECT name
# FROM animal_ins
# ORDER BY datetime limit 1;

SELECT name
FROM animal_ins 
WHERE datetime =
    (SELECT MIN(datetime) 
    FROM animal_ins);