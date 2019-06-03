--회원관리DB
create table yadata_memT(
y_id varchar2(50) primary key--총 회원아이디
,y_pwd varchar2(50)--총 회원 비밀번호
,y_name varchar2(10)--이름
,y_email varchar2(50)--이메일
,y_regdate date--y_regdate는 컬럼명이라한다.
);
alter table yadata_memT modify(y_name varchar2(50));


select * from YADATA_MEMT where y_id='q';

delete from yadata_memT where y_id ='q';

--관리자 회원등록 DB
create table yadatamanageT( --memT
 y_id varchar2(20) primary key 
 ,y_pwd varchar2(50) 
 ,y_name varchar2(50)  
 ,y_e_mail varchar2(300) 
 ,y_regdate date --가입날짜 ,date는 오라클 날짜 타입(자료형)
);
 

--자동차 예약리스트
create table reserT(
y_pdate varchar2(30)
,y_rdate varchar2(30)
,y_ploc varchar2(30)
,y_rloc varchar2(30)
,y_carkind varchar2(30)
,y_carprice varchar2(30)
,y_insurprice varchar2(30)
,y_id varchar2(30)
,y_name varchar2(30)
,y_birth varchar2(30)
,y_email varchar2(30)
,y_licencek varchar2(30)
,y_licencenum varchar2(30)
,y_totalp varchar2(30)
); 
			
select * from reserT order by y_id asc;

drop table reserT;


--관리자 로그인 테이블
create table adminT(
y_id varchar2(50)
,y_pwd varchar2(50)
);



create table memo (
memo varchar2(50)
,year varchar2(50)
,month varchar2(50)
,day varchar2(50)
);

create table carT (
y_carkind varchar2(30)primary key
,y_carnum varchar2(30)
,y_id varchar2(30) 
,y_regdate varchar2(30)
,y_carreser varchar2(30)
,y_carprice number(10)
);



insert into carT (y_carkind,y_carnum,y_carprice) values ('엑센트(소형)','1563','7000'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('모닝(소형)','4732','7400'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('스파크(소형)','1203','10000'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('기아레이(소형)','1234','15200'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('미니쿠퍼(소형)','2013','12000'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('트위지(소형)','3920','13400'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('볼보(소형)','2313','27600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('클리오(소형)','4390','17600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('쏘나타(중형)','7730','12600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('말리부(중형)','8921','15600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('K5(중형)','3309','17600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('마세라티(중형)','1212','30600'); 
insert into carT (y_carkind,y_carnum,y_carprice) values ('SM6(중형)','9971','24100'); 

select * from carT order by y_carkind asc;
drop table yadata_memT -- 테이블 삭제
drop table yadataT -- 테이블 삭제
drop table yadatamanageT -- 테이블 삭제
drop table reserT
drop table carT

select * from yadata_memT order by y_id asc;
select * from reserT order by y_id;
select * from licenseT order by y_kind asc;
select * from carT order by y_carkind;
select sysdate from dual;

select y_name,y_pwd, y_email from yadata_memT where c;

insert into yadataT values('aaa','aaa','홍길동','23','남자','서울시','서울시',sysdate);
insert into reserT values('aa','adf','adf','adf',',daf','aa','adf','adf','adf',',daf','adf','adf','adf','adf');
insert into licenseT values('1종','200249','20191231');
insert into yadataT values('aaa','aaa','홍길동','sss',sysdate);

insert into carT values('''''''''''''''''''''');
select * from yadatamanageT --where y_id='a'