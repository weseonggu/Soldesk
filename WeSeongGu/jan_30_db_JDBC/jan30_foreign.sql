--foreign key 외래키
--CONSTRAINT 조건이름 FOREIGN key (필드명) references 테이블 명(필드명) on delete cascade
create table jan30_product2(
    p_no NUMBER(2) PRIMARY key,
    p_name VARCHAR2(10 char) not null,
    p_cate VARCHAR2(10char) not null,
    p_price NUMBER(5) not null,
    p_r_no number(2) not NULL,
    CONSTRAINT jan30_restarea_destroy2
        FOREIGN key (p_r_no) references jan30_restarea(r_no)
        on delete cascade
);
-- 해석 : p_r_no는 휴개소 테이블에 있는 r_no이고 r_no에 해당하는 휴개소가 삭제 될시 해당 데이터의 헹도 같이 삭제

insert into jan30_product2 VALUES
(jan30_receipt_seq.nextval, '테스트1','테스트1',0,2);
insert into jan30_product2 VALUES
(jan30_receipt_seq.nextval, '테스트2','테스트2',0,2);
insert into jan30_product2 VALUES
(jan30_receipt_seq.nextval, '테스트2','테스트2',0,2);

DELETE from jan30_restarea
where r_no =2;

select * from jan30_restarea;
drop TABLE jan30_restarea;