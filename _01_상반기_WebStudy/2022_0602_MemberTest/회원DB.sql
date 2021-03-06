/*
 
-- 일련번호 관리객체
create sequence seq_member2_m_idx
  
-- 테이블 생성
create table member2
(
   m_idx      int,                          -- 일련번호
   m_name     varchar2(100)  not null,      -- 이름
   m_id       varchar2(100)  not null,      -- 아이디
   m_pwd      varchar2(100)  not null,      -- 비밀번호
   m_zipcode  varchar2(100),                -- 우편번호
   m_addr     varchar2(500),                -- 주소
   m_grade    varchar2(100)  default '일반',  -- 회원등급
   m_ip       varchar2(100),                 -- ip
   m_regdate  date                           -- 가입일자
)

select * from member2

-- 기본키 생성
alter table member2
  add constraint pk_member2_m_idx primary key(m_idx);
  
-- 아이디 unique
alter table member2
  add constraint unique_member2_m_id unique(m_id);
  
-- 회원등급의 체크제약
alter table member2
  add constraint ck_member2_m_grade check(m_grade in ('일반','관리자'));
  
-- sample data
insert into member2 values(seq_member2_m_idx.nextVal, '일길동', 'one', '1234', '12345', '서울시 마포구 노고산동','일반','192.168.0.5',sysdate);
insert into member2 values(seq_member2_m_idx.nextVal, '홍관리', 'admin', '1234', '12345', '서울시 마포구 노고산동','관리자','192.168.0.6',sysdate);

commit;

-- JDBC용 insert
insert into member2 values(seq_member2_m_idx.nextVal, ?, ?, ?, ?, ?,?,?,sysdate);

   
*/