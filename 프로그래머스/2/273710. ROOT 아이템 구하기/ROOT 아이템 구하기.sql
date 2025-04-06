-- 코드를 작성해주세요
select it.item_id, ii.item_name from item_info ii inner join item_tree it on ii.item_id = it.item_id where it.parent_item_id is null;