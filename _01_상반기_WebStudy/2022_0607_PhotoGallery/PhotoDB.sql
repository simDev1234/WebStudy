-- 일련번호 관리객체
create sequence seq_photo_p_idx;

-- table 생성
create table photo
(
   p_idx      int,                       -- 일련번호
   p_subject  varchar2(1000)  not null,  -- 사진제목
   p_content  varchar2(2000)  not null,  -- 사진설명
   p_filename varchar2(1000)  not null,  -- 사진파일명
   p_ip       varchar2(100)   not null,  -- 아이피
   p_regdate  date,                      -- 등록일자
   m_idx      int                        -- 등록사용자 m_idx
);

-- 기본키
alter table photo
  add constraint pk_photo_p_idx primary key(p_idx);
  
-- 외래키 (참조키)
alter table photo
  add constraint fk_photo_m_idx foreign key(m_idx) references member2(m_idx);

-- 내림차순으로 전체 조회
SELECT * FROM photo ORDER BY p_idx DESC

