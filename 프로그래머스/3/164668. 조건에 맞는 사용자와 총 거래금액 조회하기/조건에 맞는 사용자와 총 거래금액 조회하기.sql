-- 코드를 입력하세요
SELECT u.user_id, u.nickname, sum(price) as total_sales 
from used_goods_board b join used_goods_user u on b.writer_id = u.user_id 
where b.status = 'DONE' 
group by u.user_id, u.nickname 
having sum(price) >= 700000 
order by total_sales;