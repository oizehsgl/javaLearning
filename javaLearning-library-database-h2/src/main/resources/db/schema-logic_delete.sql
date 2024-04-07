drop table if exists logic_delete;

create table logic_delete
(
	id int auto_increment not null comment 'id',
	data varchar default '' comment 'data',
	deleted_datetime datetime comment 'deleted_datetime',
	deleted_integer int default 0 comment 'deleted_integer',
	deleted_boolean boolean default false comment 'deleted_boolean'
);