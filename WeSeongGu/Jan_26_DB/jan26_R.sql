-- 전체 필드의 데이터 조회
select * from jan26_food;

-- 특정 필드만 선택해서 조회
select f_name, f_price from JAN26_food;
select f_name, f_exp from JAN26_food;
-- 필드명 바꿔서 보여주기
select f_name as name, f_exp as food_exp from JAN26_food;
-- 데이터 계산 -> 연산자 사용가능
select f_name, f_price, f_price*0.1 as tax from JAN26_food;
select f_name, f_price, f_price/f_weight as price_per_gram from JAN26_food;
-- 통계 함수 sum(), avg(), max(), min(),count()
select avg(f_price) as food_avg,
avg(f_price)/ avg(f_weight) as food_avg_per_gram,
max(f_price) as food_max,
min(f_price) as food_min,
count(f_price) as food_count
from jan26_food;
-- 제한자 where(조건식)
select f_name, f_price from JAN26_food where f_price < 5000;
select count(f_price) as over from JAN26_food where f_price >= 7000;
select * from JAN26_food where f_name = '한우';
select * from JAN26_food where f_exp < sysdate;

insert into jan26_food values(jan26_food_seq.nextval, '냉면',to_date('2023/01/27 15:50','YYYY/MM/DD HH24:MI'),2200,170);
insert into jan26_food values(jan26_food_seq.nextval, '햄버거',to_date('2023/01/27 10:00','YYYY/MM/DD HH24:MI'),2200,170);
-- to_char(날짜,패턴) 날짜->글자
-- concat(글자, 글자) - 글자글자 (글자 붙여줌)
select * from JAN26_food 
where f_exp < to_date(concat(to_char(sysdate,'YYYYMMDD'),' 23:59:59'),'YYYY/MM/DD HH24:MI:SS');

select * from jan26_food 
where f_exp > to_date('20230127 09:00:00','YYYYMMDD HH24:MI:SS') 
and f_exp <= to_date('20230127 18:00:00','YYYYMMDD HH24:MI:SS')

-- 특정 글자가 문자열에 포함된거 검색
-- 필드명 like 패턴
-- 패턴: %글자 - 글자로 끝나는거 검색, 글자% - 글자로 시작하는, %글자% - 글자가 포함된
select f_name, f_price from JAN26_food where f_name like '%사%';

select f_name, f_price from JAN26_food 
where f_name like '%장%' or f_name like '%우유';

select count(*) from jan26_food 
where f_price >=1000 and f_price <=5000; 

select count(*) as donteat from jan26_food 
where f_exp > to_date('20230127 09:00:00','YYYYMMDD HH24:MI:SS') 
and f_exp <= to_date('20230127 18:00:00','YYYYMMDD HH24:MI:SS');

-- sub query - query안의 query
select f_name, f_exp, f_price from JAN26_FOOD 
where f_price=(select max(f_price) from jan26_food);  

select f_name, f_price, f_price*0.1 as vat from JAN26_FOOD
where f_price >= (select avg(f_price) from JAN26_FOOD );








