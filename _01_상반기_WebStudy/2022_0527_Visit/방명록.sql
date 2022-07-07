/*

-- 일련번호 관리객체
CREATE SEQUENCE seq_visit_idx;

-- 테이블 생성
CREATE TABLE visit
(
   idx     int,                     --일련번호
   name    varchar2(100)  not null, --이름
   content varchar2(2000) not null, --내용
   pwd     varchar2(100)  not null, --비밀번호
   ip      varchar2(100)  not null, --IP
   regdate date                     --작성일자
)
/

-- 기본키
alter table visit
  add constraint pk_visit_idx primary key(idx);
  
-- sample data
insert into visit values(seq_visit_idx.nextVal, '일길동', '내가 1등이다','1234','192.168.0.9',sysdate);
insert into visit values(seq_visit_idx.nextVal, '이길동', '아쉽네 1등 놓쳤네','2345','192.168.0.9',sysdate);

-- JDBC코드용 편집
insert into visit values(seq_visit_idx.nextVal, ?, ?,?,?,sysdate);
delete from visit where idx = ?;
select * from visit where idx = ?;
update visit set content = ? where idx = ?;
 

-- 조회
SELECT * FROM visit ORDER BY idx DESC

*/