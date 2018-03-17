drop TABLE IF EXISTS t_admin;
create table t_admin
(
id int primary key auto_increment comment '主键id',
userName varchar(200) comment '用户名',
password varchar(200) comment '密码',
saltPassword varchar(200) comment '加密盐值',
insertTime bigint comment '写入时间',
lastUpdateTime bigint comment '最后修改时间',
status int comment '账号状态'
) comment '管理员表';

drop TABLE IF EXISTS t_menu;
create table t_menu(
id int primary key auto_increment comment '主键id',
menuName varchar(200) comment '菜单名称',
parentId int comment '上级菜单id',
sort int comment '排序值',
status int comment '是否关闭',
insertTime bigint comment '写入时间',
lastUpdateTime bigint comment '最后修改时间'
) comment '管理员表';

drop TABLE IF EXISTS t_content;
create table t_content(
id int primary key auto_increment comment '主键id',
url varchar(200) comment '内容链接',
image varchar(200) comment '内容图片',
sort int comment '排序值',
menuId int comment '属于哪个菜单',
name varchar(200) comment '网站名称',
status int comment '是否关闭',
insertTime bigint comment '写入时间',
lastUpdateTime bigint comment '最后修改时间'
);


alter table t_content add column webPrice int comment '网站价格' DEFAULT 0;
