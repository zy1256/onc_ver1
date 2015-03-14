create table adm_user (
                      user_no number(10),
                      user_id varchar2(20),
                      user_pw varchar2(20),
                      user_name varchar2(20),
                      user_adm number(10)
                      );
create SEQUENCE admin_user_seq start with 1 INCREMENT by 1;
insert into adm_user values (admin_user_seq.nextval,'sys','sys','admin','1');

create table LIST_RESER(
  order_no number(10) not null,
  o_date date,
  p_name varchar2(100),
  p_count number(10),
  p_price number(15),
  p_pic varchar2(200),
  p_costmer varchar2(20),
  p_state number(2),
  user_no number(10),
  p_outprice number(15)
);
create SEQUENCE order_no_seq start with 1 INCREMENT by 1;

select user_no,user_id,user_pw,user_name,user_adm from adm_user where user_id='sys';

select ORDER_NO,o_date,p_name,p_count,p_price,p_pic,p_costmer,p_state,user_no from LIST_RESER where user_no=1 and p_state<4 order by o_date desc;

select * from list_reser where user_no=1 and p_costmer like '%%' order by o_date desc;
select * from list_reser where user_no=1 and p_state between 1 and 3 and p_costmer like '%t%' order by o_date desc;