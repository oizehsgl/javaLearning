drop table if exists id_type;

create table id_type
(
    int_id    int auto_increment comment 'int_id',
    string_id varchar comment 'string_id',
    data      varchar comment 'data'
);