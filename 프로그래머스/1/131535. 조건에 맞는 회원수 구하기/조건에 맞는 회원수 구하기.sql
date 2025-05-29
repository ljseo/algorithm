-- 코드를 입력하세요
SELECT count(*) users 
FROM user_info 
WHERE age <= 29 AND age >= 20 
AND YEAR(joined) = 2021;