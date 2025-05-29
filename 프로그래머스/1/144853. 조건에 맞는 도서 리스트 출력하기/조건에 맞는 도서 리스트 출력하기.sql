-- 코드를 입력하세요
SELECT book_id, date_format(published_date, '%Y-%m-%d')
FROM book
WHERE category = '인문'
AND published_date < '2022-01-01' 
AND published_date >= '2021-01-01' 
ORDER BY published_date