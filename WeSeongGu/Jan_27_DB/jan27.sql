select * from jan27_run;
select * from jan27_restaurant;
select * from jan27_ceo;
select * from jan27_menu;

select r_name, r_jijum  from JAN27_RESTAURANT 
where r_no in (select m_r_no from JAN27_MENU 
where m_price = (select max(m_price)from jan27_menu));
-- 최연소 사장님 가계의 매뉴 가격
SELECT m_name, m_price from jan27_menu 
    where m_r_no in (select r_r_no from jan27_run 
        where r_c_no = (select c_no from jan27_ceo 
            where c_date in (select max(c_date) from jan27_ceo)));
            
-- 식당명, 지점명, 메뉴명, 가격 -> 필드가 다 다른 테이블에 있음 -> 테이블을 함처야함
-- join 
-- outer join -> 모든 경우의 수를 다 붙여서 보여줌
-- 램에 부담이 크기 때문에 가급벅이면 사용하지 말자 subquery사용하는게 램에 부담을 줄여줌
select * from jan27_restaurant, jan27_menu; 

select r_name, jan27_restaurant.r_jijum, jan27_menu.m_name, jan27_menu.m_price from jan27_restaurant, jan27_menu
where r_no = m_r_no;

select * from jan27_ceo, jan27_restaurant, jan27_run 
where jan27_ceo.c_no = r_c_no and r_r_no = jan27_restaurant.r_no;

select * from jan27_restaurant, jan27_menu
where r_no = m_r_no  and m_price > (select avg(m_price) from jan27_menu);
-- 정렬 order by 1차 기준 필드, 2차 기준 필드
select c_name, r_name, r_jijum, m_name, m_price 
from jan27_ceo, jan27_restaurant, jan27_menu, jan27_run
where c_no = jan27_run.r_c_no and jan27_restaurant.r_no = jan27_run.r_r_no and r_r_no = m_r_no
ORDER by m_name, jan27_menu.m_price;

select m_name,m_price from jan27_menu 
order by m_price DESC , m_name;

select * from j an27_restaurant, jan27_menu where r_no = m_r_no 
and m_price > (select avg(m_price)from jan27_menu)
order by r_name , m_name;


-- rownum
-- select 할때마다 부여되는 가상 필드
-- *랑 같이 못씀
-- order by 보다 먼저 부여되는 문제 발생
-- 1번 부터 써야하는 문제
select ROWNUM, m_no,m_name,m_price from jan27_menu
order by m_name, m_price;
-- order by 보다 먼저 부여되는 문제 해결 방법
select ROWNUM, m_no,m_name,m_price 
from (
select * 
from jan27_menu
order by m_name, m_price
)
where rownum >=4 and rownum <= 6;
-- 1번 부터 써야하는 문제 해결 방법
select *
from(
    select ROWNUM as rn, m_no,m_name,m_price 
    from (
        select m_no,m_name,m_price  
        from jan27_menu
        order by m_name, m_price
    )
)
where rn >=4 and rn<=6;
select *
from(
select rownum as rn, c_name, r_name , r_jijum, m_name, m_price
from(
select c_name, r_name , r_jijum, m_name, m_price
from jan27_ceo, jan27_run, jan27_restaurant, jan27_menu
where c_no = r_c_no
and r_r_no = jan27_restaurant.r_no
and jan27_restaurant.r_no=M_r_no
order by m_name, m_price
)
);





