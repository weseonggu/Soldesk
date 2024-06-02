create sequence convenience_store_seq;

create table convenience_store(
	c_no  number(2) primary key,
	c_brand varchar2 (7 char ) not null,
	c_jijum varchar2(5 char ) not null,
	c_location varchar2(10 char) not null
);

insert into convenience_store values(convenience_store_seq.nextval,'gs25','수락점','슈락산123');
insert into convenience_store values(convenience_store_seq.nextval,'cu','노원점','노원123');
insert into convenience_store values(convenience_store_seq.nextval,'gs25','잠실점','잠실123');
insert into convenience_store values(convenience_store_seq.nextval,'7','홍대점','홍대123');
insert into convenience_store values(convenience_store_seq.nextval,'cu','강대점','강대123');

select * from convenience_store;

create sequence store_product_seq;

create table store_product(
	s_no number(3) primary key,
	s_exp date not null,
	s_name varchar2(10 char) not null,
	s_price number(4) not null,
	s_c_no number(2) not null,    
	CONSTRAINT convenience_store
        FOREIGN key (s_c_no) references convenience_store(c_no)
        on delete cascade
); 
select * from store_product;
drop table store_product;

insert into store_product values (store_product_seq.nextval, to_date('2023-05-05','YYYY-MM-DD'),'초코송이', 1000, 1);
insert into store_product values (store_product_seq.nextval, to_date('2023-06-20','YYYY-MM-DD'),'불닭볶음면', 1700, 4);
insert into store_product values (store_product_seq.nextval, to_date('2023-07-19','YYYY-MM-DD'),'핫바', 2000, 2);
insert into store_product values (store_product_seq.nextval, to_date('2023-08-17','YYYY-MM-DD'),'케익', 3500, 3);
insert into store_product values (store_product_seq.nextval, to_date('2023-09-20','YYYY-MM-DD'),'햄버거', 3500, 4);
insert into store_product values (store_product_seq.nextval, to_date('2023-10-21','YYYY-MM-DD'),'삼각김밥', 1200, 1);
insert into store_product values (store_product_seq.nextval, to_date('2023-11-14','YYYY-MM-DD'),'사탕', 700, 2);
insert into store_product values (store_product_seq.nextval, to_date('2023-03-15','YYYY-MM-DD'),'오감자', 1500, 4);
insert into store_product values (store_product_seq.nextval, to_date('2023-04-15','YYYY-MM-DD'),'진라면', 1200, 2);
insert into store_product values (store_product_seq.nextval, to_date('2023-11-25','YYYY-MM-DD'),'콜라', 1700, 3);

select * from(
	select rownum as rn, s_exp, s_name, s_price from(
		select * from STORE_PRODUCT 
	)
)
where rn>=1 and rn <=5;







select * from(
	select rownum as rn, c_brand, c_jijum, c_no, c_location from(
		select c_brand, c_jijum, c_no, c_location 
		from convenience_store
		where c_location like '%홍대%' 
	)
)
where rn>=1 and rn <=5;

select * from(
	select rownum as rn, c_brand, c_jijum, s_name, s_price from(
		select * from CONVENIENCE_STORE, STORE_PRODUCT 
		where c_no = s_c_no and s_name like '%홍대%'
	) 
) where rn>=1 and rn <=5;

