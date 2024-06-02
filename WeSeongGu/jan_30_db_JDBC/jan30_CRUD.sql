CREATE SEQUENCE jan30_rest_seq;
create SEQUENCE jan30_receipt_seq;

CREATE TABLE jan30_restarea(
    r_no number(2)PRIMARY key,
    r_name VARCHAR2(10 char) not null,
    r_direction VARCHAR2(10 char) not null,
    r_location VARCHAR2(10 char) not null,
    r_park NUMBER(4) not NULL
);

CREATE TABLE jan30_product (
    p_no NUMBER(2) PRIMARY key,
    p_name VARCHAR2(10 char) not null,
    p_cate VARCHAR2(10char) not null,
    p_price NUMBER(5) not null,
    p_r_no number(2) not NULL
);

insert into jan30_restarea VALUES
(jan30_rest_seq.nextval, '안동휴개소','상행', '양양고속도로',300);
insert into jan30_restarea VALUES
(jan30_rest_seq.nextval, '안동휴개소','하행', '양양고속도로',300);
insert into jan30_restarea VALUES
(jan30_rest_seq.nextval, '속초휴개소','상행', '아무고속도로',300);
insert into jan30_restarea VALUES
(jan30_rest_seq.nextval, '속초휴개소','하행', '아무고속도로',300);
insert into jan30_restarea VALUES
(jan30_rest_seq.nextval, '구리휴개소','하행', '남부고속도로',200);

insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '호두과자','간식',2000,1);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '소떡소떡','간식',3000,2);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '닭꼬치','간식',5000,3);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '휴지','편의점',500,4);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '감튀','간식',1500,1);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '라면','푸드코트',5000,2);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '핫도그','간식',2500,3);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '회오리감자','간식',4500,4);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '타꼬야끼','간식',8000,1);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '치킨','간식',10000,2);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '컵밥','푸드코트',4500,3);
insert into jan30_product VALUES
(jan30_receipt_seq.nextval, '음료수','편의점',1500,4);

select * from jan30_restarea;
SELECT * from jan30_product;



select p_name, p_price from jan30_product
ORDER by p_name, p_price;

select count(p_name)as snak_kind from jan30_product
where p_cate like '간식';

select avg(p_price) from jan30_product
where p_r_no in (select r_no from jan30_restarea where r_name like '안동%');

select r_name, r_direction, r_location, p_name,p_price 
from jan30_product, jan30_restarea 
where r_no = p_r_no;

select * from(
    SELECT rownum as rn, p_name , p_price from(
        select p_name, P_price 
        from jan30_product
        order by p_name, p_price
    )
)
where rn >=2 and rn<=6;

-- group by 필드명, 필드명,....
select p_cate,avg(p_price) 
from jan30_product 
GROUP by p_cate;

select r_direction,avg(r_park) 
from jan30_restarea 
group by r_direction; 

select r_name, max(p_price) 
from jan30_product, jan30_restarea 
where r_no = p_r_no
group by r_name;


select r_name, min(p_price) 
from jan30_product, jan30_restarea 
where r_no = p_r_no
group by r_name, p_cate
order by r_name, p_cate;

select  r_direction ,p_cate, avg(p_price) 
from jan30_product, jan30_restarea 
where r_no = p_r_no
group by p_cate, r_direction;

select p_cate, avg(p_price) 
from jan30_product 
where p_price >= 3000 
group by p_cate;


-- having 조건식 group by하고나서 보기 싫은거 지우는거
select p_cate, avg(p_price) 
from jan30_product  
group by p_cate
having avg(p_price) >= 3000;

select r_name, count (p_cate) from 
jan30_restarea, jan30_product
where r_no = p_r_no
group by r_name , p_cate
having count(p_cate) >=2;

-- 데이터 수정 update
-- update 테이블명 set 필드명 = 값, 필드명 = 값, ..... where 조건식;
update jan30_product set p_price = 1000 where p_name like '%소떡%';

update jan30_product 
set p_price = 0 
where p_cate ='간식' and p_r_no in 
(
select r_no from jan30_restarea 
where r_name like '안동%' and r_direction like '하행'
);

update jan30_product
set p_price = p_price+ p_price*0.1 
where p_cate like '간식';

update jan30_product
set p_price =  p_price*0.8
where p_r_no in 
    (
    select r_no from jan30_restarea 
    where r_park=
        (select max(r_park)from jan30_restarea)
    ) 
and 
    p_price > 
        (select avg(p_price) from jan30_product); 


-- 삭제 d
-- delete from 테이블명 where 조건식;
delete from jan30_product
where p_price = 0;

delete from jan30_restarea
where r_park = (select min(r_park) from jan30_restarea);


select * from jan30_restarea;
SELECT * from jan30_product;

-- 휴개소에서 팔던 상품도 지워야하는데 이미 휴개소 데이터를 지워서 상품의 데이터를 지울 수가 없음









