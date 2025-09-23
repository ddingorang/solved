-- 코드를 입력하세요
SELECT category, sum(bs.sales) as total_sales 
from book b join book_sales bs on b.book_id = bs.book_id 
where year(sales_date) = 2022 and month(sales_date) = 1
group by b.category order by category;