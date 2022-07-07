/*

--- ����Ŭ�� �Ϸù�ȣ ���� ��ü (������)
CREATE SEQUENCE seq_sungtb_idx


--- ���̺� ����
CREATE TABLE sungtb
(
    idx   INT,      -- �Ϸú�ȣ
    name  CHAR(4 char) NOT NULL, --�̸�
    kor   INT,      -- ����
    eng   INT,      -- ����
    mat   INT      -- ����
);


--- �������� 
ALTER TABLE sungtb 
  ADD CONSTRAINT pk_sungtb_idx PRIMARY KEY(idx)


--- üũ����(����/����/����) : 0 ~ 100
ALTER TABLE sungtb 
  ADD CONSTRAINT ck_sungtb_kor check(kor between 0 and 100)
  
ALTER TABLE sungtb 
  ADD CONSTRAINT ck_sungtb_eng check(eng between 0 and 100)
  
ALTER TABLE sungtb 
  ADD CONSTRAINT ck_sungtb_mat check(mat between 0 and 100)
  
  
--- SAMPLE DATA
INSERT INTO sungtb VALUES(seq_sungtb_idx.nextVal, '�ϱ浿', 90, 80, 70);
INSERT INTO sungtb VALUES(seq_sungtb_idx.nextVal, '�̱浿', 80, 80, 80);
INSERT INTO sungtb VALUES(seq_sungtb_idx.nextVal, '��浿', 90, 100, 90);

-- ����
DELETE FROM sungtb WHERE idx = 21;

-- ����
UPDATE sungtb SET name = '�ϱ浿', kor = 100, eng = 100, mat = 100 WHERE idx = 1;

COMMIT


--- ��ȸ �� �ʿ��� �並 ����

CREATE OR REPLACE VIEW sungtb_view
AS
	SELECT
	   s.*, 
	   (kor + eng + mat) as tot,  --- tot�� SQL���� ������ ������ �� �����.
	   ROUND((kor + eng + mat) / 3, 1) as avg,
	   RANK() OVER(ORDER BY (kor + eng + mat) desc) as rank
	FROM (SELECT * FROM sungtb) s
	ORDER BY idx


SELECT * FROM sungtb_view;


*/