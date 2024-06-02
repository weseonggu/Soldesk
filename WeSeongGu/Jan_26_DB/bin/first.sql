-- 주석
-- 관리자 기능 x
-- sqlplus의 명령어 사용 못함

-- 여러줄 살행 alt+x 한줄 alt+s
create table snack(
	name char(3),
	price number(4)
);

select * from SNACK;
-- 프로젝트에 sql파일 만들어서 연습
-- 출시할때 sql파일 삭제
-- sql파일은 하나만 열고 하기 줄이 여러개 블록 되면 화면에없어도 실행됨

drop table snack cascade constraint purge;


-- 테이블을 만들고 데이터 넣기
-- field(열 column) record(행 row)
-- 자료형
-- 글자 char(용량) varchar2(용량)
-- 용량 - 바이트 단위 (만약 크기 보다 작으면 억지로 채워서 넣음) -> 빠름 - 사용 예시 성별(모든데이터의 글자수가 같은경우)
--     -  2 char (2글자)(사이즈보다작으면 크기를 자동으로 줄임 (느림)) - 주로 이거 사용 -> 개선 - varchar2 - 사용예시 이름 (데이터의 글자 수가 제각각인경우)

-- 숫자 number(용량) - 용량 적을만큼의 자릿수 표현 가능 - (5,3) 일경우(전체 자릿수, 소수점 자릿수)

-- 날짜/시간: date

create table jan26_snack(
--  필드명 자료형         옵션, 
	s_name varchar2(10 char),
	s_price number(5)
);



drop table jan26_snack cascade constraint purge;-- 테이블 삭제

-- 데이터 추가
insert into jan26_snack(s_name, s_price)
values ('초코송이',1500);
-- 처음 select는 안나옴 종료후 다시 시작 하고 다시 연결 하면 정상 작동 

insert into jan26_snack(s_price,s_name)
values(700,'젤리');

-- null값 가능 하지만 사용은 안함
insert into jan26_snack(s_name)
values('감자칩');

insert into jan26_snack values('빈츠',5000); -- 주로 이거 사용함
insert into jan26_snack values('초코파이',5000);
insert into jan26_snack values('몽쉘',5000);
-- 옵션:
--	not null : 비우지 못함
--	primary key : not null + 중복 데이터 못 넣음
	-- 그 데이터를 대표하는 값 
	-- 겁색 삭제에 유용
	-- 테이블다 하나의 primary key는 있어야함
create table jan26_snack (
	s_name varchar2(10 char) primary key,
	s_price number(5)not null
);

create table jan26_student (
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_kor number(3)not null,
	s_eng number(3)not null,
	s_mat number(3)not null
);
-- 테이븧 수정 실전에서는 사용 못함 100000명이 들록 되었는데 새로운 필드를 추가하면 데이터가 비기 때문에 사용안함


insert into JAN26_student values(1,'홍길동',80,90,95);
insert into JAN26_student values(2,'김길동',82,70,65);
insert into JAN26_student values(3,'이길동',40,62,89);
-- 번호 자동 중가 -> sequence 태이블과는 상관이 없음  독립적인 존재
-- insert 실패해도 숫자 증가함 하나로 여러 테이블에서 사용 가능
-- create sequence 시퀀스명;
create sequence jan26_student_seq;
-- 사용  insert 할떄 데이터 들어갈 위치에 시퀀스명.nextval 입력
insert into JAN26_student values(jan26_student_seq.nextval,'홍길동',80,90,95);
insert into JAN26_student values(jan26_student_seq.nextval,'김길동',82,70,65);
insert into JAN26_student values(jan26_student_seq.nextval,'이길동',40,62,89);
-- 시퀀스 삭제
drop sequence jan26_student_seq;

select * from jan26_student;
drop table jan26_student cascade constraint purge;
select * from jan26_snack;



-- 날짜 시간
-- java에서 데이터 객체를 넣으면 됨
create sequence jan26_food_seq;

create table jan26_food (
	f_no number(2) primary key,
	f_name varchar2(10 char) not null,
	f_exp date not null,
	f_price number(5) not null,
	f_weight number(6,2) not null
);
-- sysdate 현재 시간 
-- to_date('날짜', '패턴') YYYY MM DD HH or HH24 MI SS 
insert into jan26_food values(jan26_food_seq.nextval, '우유',sysdate,3000,500.12);
insert into jan26_food values(jan26_food_seq.nextval, '요구르트',to_date('2020/02/20 10:50','YYYY/MM/DD HH24:MI'),700,100);
insert into jan26_food values(jan26_food_seq.nextval, '사과',to_date('2020/01/30 10:50','YYYY/MM/DD HH24:MI'),8000,120);
insert into jan26_food values(jan26_food_seq.nextval, '햄',to_date('2020/11/15 10:50','YYYY/MM/DD HH24:MI'),5600,620);
insert into jan26_food values(jan26_food_seq.nextval, '배',to_date('2020/10/27 10:50','YYYY/MM/DD HH24:MI'),5500,400);
insert into jan26_food values(jan26_food_seq.nextval, '포도',to_date('2020/12/28 10:50','YYYY/MM/DD HH24:MI'),4400,700);
insert into jan26_food values(jan26_food_seq.nextval, '생선',to_date('2020/10/27 10:50','YYYY/MM/DD HH24:MI'),8410,800);
insert into jan26_food values(jan26_food_seq.nextval, '삼겹살',to_date('2020/11/23 10:50','YYYY/MM/DD HH24:MI'),650,260);
insert into jan26_food values(jan26_food_seq.nextval, '한우',to_date('2020/10/12 10:50','YYYY/MM/DD HH24:MI'),4500,100);
insert into jan26_food values(jan26_food_seq.nextval, '랍스타',to_date('2020/12/13 10:50','YYYY/MM/DD HH24:MI'),8100,450);
insert into jan26_food values(jan26_food_seq.nextval, '감자칩',to_date('2020/01/11 10:50','YYYY/MM/DD HH24:MI'),1500,500);
insert into jan26_food values(jan26_food_seq.nextval, '요플레',to_date('2020/03/12 10:50','YYYY/MM/DD HH24:MI'),6200,480);
insert into jan26_food values(jan26_food_seq.nextval, '요거트',to_date('2020/03/14 10:50','YYYY/MM/DD HH24:MI'),4500,190);
insert into jan26_food values(jan26_food_seq.nextval, '사이다',to_date('2020/05/12 10:50','YYYY/MM/DD HH24:MI'),1100,110);
insert into jan26_food values(jan26_food_seq.nextval, '라면',to_date('2020/06/12 10:50','YYYY/MM/DD HH24:MI'),2200,170);
insert into jan26_food values(jan26_food_seq.nextval, '카레',to_date('2020/07/15 10:50','YYYY/MM/DD HH24:MI'),7800,800);
insert into jan26_food values(jan26_food_seq.nextval, '초콜릿',to_date('2020/09/25 10:50','YYYY/MM/DD HH24:MI'),9900,900);
insert into jan26_food values(jan26_food_seq.nextval, '콜라',to_date('2020/08/27 10:50','YYYY/MM/DD HH24:MI'),5100,700);
insert into jan26_food values(jan26_food_seq.nextval, '상추',to_date('2020/05/24 10:50','YYYY/MM/DD HH24:MI'),4200,500);
insert into jan26_food values(jan26_food_seq.nextval, '된장',to_date('2020/04/25 10:50','YYYY/MM/DD HH24:MI'),6600,500);


select * from jan26_food;
drop table jan26_food cascade constraint purge;
drop sequence jan26_food_seq;




