# -- 코드를 입력하세요
SELECT title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, DATE_FORMAT(ugr.created_date,'%Y-%m-%d') created_date
FROM USED_GOODS_BOARD ugb 
JOIN USED_GOODS_REPLY ugr
ON ugb.BOARD_ID = ugr.BOARD_ID
AND ugb.created_date < '2022-11-01'
AND ugb.created_date >= '2022-10-01'
ORDER BY ugr.created_date, title ;

