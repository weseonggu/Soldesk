-- RDB 계열

-- NoSQL 계열

-- RDBMS

-- 관계형DB: 테이블을 나눠서 다자인 ->  테이블 간의 관계를 중점으로 나눔

create sequence jan_run_seq;
drop sequence jan_run_seq;

create table jan27_run (
	r_no number(3) primary key,
	r_c_no number(3) not null,
	r_r_no number(3) not null
);

create table jan27_ceo(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_date date not null,
	c_home varchar2( 10 char) not null
);

create table jan27_restaurant (
	r_no number(3) primary key,
	r_name varchar2(10 char) not null,
	r_jijum varchar2(10 char ) not null,
	r_addr varchar2(10 char) not null,
	r_table number(3) not null
);

create table jan27_menu(
	m_no number(3) primary key,
	m_name varchar2(10 char ) not null,
	m_price number(4) not null,
	m_r_no number(3) not null
);


drop table jan27_run;
drop table jan27_ceo;
drop table jan27_restaurant;
drop table jan27_menu;


insert into jan27_ceo values(jan_run_seq.nextval,'홍길동',to_date('19990101','YYYYMMDD'),'수원');
insert into jan27_ceo values(jan_run_seq.nextval,'김길동',to_date('19980303','YYYYMMDD'),'안양');
insert into jan27_ceo values(jan_run_seq.nextval,'이길동',to_date('20081103','YYYYMMDD'),'노원');

insert into jan27_restaurant values(jan_run_seq.nextval,'김밥천국','강남점','서초',10);
insert into jan27_restaurant values(jan_run_seq.nextval,'김밥천국','종로점','종각',30);
insert into jan27_restaurant values(jan_run_seq.nextval,'김밥천국','강남점','잠실',20);

insert into jan27_menu values(jan_run_seq.nextval,'야채김밥',4000,4);
insert into jan27_menu values(jan_run_seq.nextval,'야채김밥',4000,6);
insert into jan27_menu values(jan_run_seq.nextval,'제육김밥',3500,5);
insert into jan27_menu values(jan_run_seq.nextval,'돈까스김밥',3700,4);
insert into jan27_menu values(jan_run_seq.nextval,'라면',5000,6);

insert into jan27_menu values(jan_run_seq.nextval,'쫄면',5500,6);
insert into jan27_menu values(jan_run_seq.nextval,'우동',5800,6);
insert into jan27_menu values(jan_run_seq.nextval,'돈까스',6500,6);
insert into jan27_menu values(jan_run_seq.nextval,'카레',4000,6);
insert into jan27_menu values(jan_run_seq.nextval,'김치찌개',3700,6);
insert into jan27_menu values(jan_run_seq.nextval,'된장찌개',6500,5);

insert into jan27_run values(jan_run_seq.nextval,2,4);
insert into jan27_run values(jan_run_seq.nextval,3,5);
insert into jan27_run values(jan_run_seq.nextval,1,6);

select * from jan27_run;
select * from jan27_restaurant;
select * from jan27_ceo;
select * from jan27_menu;

select m_name, m_price from JAN27_MENU where m_name like '%밥%';
-- sub query에서 =을 사용하면 결과는 하나만 나와야 한다. 하지만 하나 또는 두개 이상의 데이터가 나온다면 in을 쓰면 실행된다.
select r_name, r_jijum, r_addr from JAN27_RESTAURANT
where r_no in (select r_r_no from jan27_run 
where r_c_no in (select c_no from jan27_ceo 
where c_name like '홍길동'));

-- 하나 또는 두개 이상의 데이터가 온다면 in사용
select r_name, r_jijum  from JAN27_RESTAURANT 
where r_no in (select m_r_no from JAN27_MENU 
where m_price = (select max(m_price)from jan27_menu));


-- 최연소 사장님 가계의 매뉴 가격
SELECT m_name, m_price from jan27_menu 
    where m_r_no in (select r_r_no from jan27_run 
        where r_c_no = (select c_no from jan27_ceo 
            where c_date in (select min(c_date) from jan27_ceo)));



























