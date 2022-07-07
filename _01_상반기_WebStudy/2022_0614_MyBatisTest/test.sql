-- 입사연도별 조회
select * from sawon
  where to_number(to_char(sahire,'YYYY')) between 1988 and 1993