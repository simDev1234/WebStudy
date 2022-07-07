/*

-- �Ϸù�ȣ ������ü
CREATE SEQUENCE seq_visit_idx;

-- ���̺� ����
CREATE TABLE visit
(
   idx     int,                     --�Ϸù�ȣ
   name    varchar2(100)  not null, --�̸�
   content varchar2(2000) not null, --����
   pwd     varchar2(100)  not null, --��й�ȣ
   ip      varchar2(100)  not null, --IP
   regdate date                     --�ۼ�����
)
/

-- �⺻Ű
alter table visit
  add constraint pk_visit_idx primary key(idx);
  
-- sample data
insert into visit values(seq_visit_idx.nextVal, '�ϱ浿', '���� 1���̴�','1234','192.168.0.9',sysdate);
insert into visit values(seq_visit_idx.nextVal, '�̱浿', '�ƽ��� 1�� ���Ƴ�','2345','192.168.0.9',sysdate);

-- JDBC�ڵ�� ����
insert into visit values(seq_visit_idx.nextVal, ?, ?,?,?,sysdate);
delete from visit where idx = ?;
select * from visit where idx = ?;
update visit set content = ? where idx = ?;
 

-- ��ȸ
SELECT * FROM visit ORDER BY idx DESC

*/