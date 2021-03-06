CREATE SEQUENCE seq_member_member_idx;

CREATE TABLE member
(
     member_idx       int,
     member_id        varchar2(100)   not null,
     member_pwd       varchar2(100)   not null,
     member_name      varchar2(45)    not null,
     member_phone     varchar2(45)    not null,
     member_regdate   date            not null
);

ALTER TABLE member
  ADD CONSTRAINT pk_member_member_idx PRIMARY KEY(member_idx);