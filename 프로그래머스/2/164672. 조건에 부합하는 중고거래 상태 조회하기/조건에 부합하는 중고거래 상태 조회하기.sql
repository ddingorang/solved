-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, CASE
WHEN STATUS LIKE 'DONE' THEN '거래완료'
WHEN STATUS LIKE 'SALE' THEN '판매중'
ELSE '예약중'
END AS STATUS
from used_goods_board where created_date = '2022-10-05' order by board_id desc;