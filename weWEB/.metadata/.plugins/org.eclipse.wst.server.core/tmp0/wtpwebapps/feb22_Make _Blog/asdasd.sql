select * from(
select ROWNUM as rn, bn_no, bn_writer, bn_title, bn_date from (
select bn_no,bn_writer,bn_title,bn_txt,bn_date from bpbascp_notice 
where bn_title like '%d%' or bn_txt like '%d%'
order by bn_date desc)
)where rn >=1 and rn<=10;



select bn_writer, bn_title, bn_date, pm_id, pm_name, pm_photo 
from bpbascp_notice,project_member 
where pm_id = bn_writer and bn_no = 2;