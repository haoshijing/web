Insert into t_admin(id,userName ,password ,saltPassword,insertTime,lastUpdateTime ,status)
select
 null , 'admin','ec6398c8b6baa541a9602f90b2f69bda','123',  unix_timestamp()*1000, unix_timestamp()*1000,1;