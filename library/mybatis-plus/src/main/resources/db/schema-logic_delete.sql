drop table if exists logic_delete;

create table logic_delete
(
	id int auto_increment not null comment 'id',
	data varchar default '' comment 'data',
	deleted boolean default false comment 'deleted'
);