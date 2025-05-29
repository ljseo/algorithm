-- 코드를 입력하세요
SELECT pt_name, pt_no, gend_cd, age, IFNULL(tlno, 'NONE') tlno
FROM patient
WHERE gend_cd = 'W' 
AND age BETWEEN 0 AND 12
ORDER BY age DESC, pt_name;