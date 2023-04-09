drop table if exists `t_simple_demo`;
create table `t_simple_demo`
(
    id              bigint      auto_increment comment '主键',
    name            varchar(50) comment '姓名',
    age             int         comment '年龄',
    create_user     varchar(50) comment '创建用户',
    update_user     varchar(50) comment '更新用户',
    create_datetime datetime    comment '创建时刻',
    update_datetime datetime    comment '更新时刻',
    deleted         boolean     comment '删除状态',
    delete_datetime boolean     comment '删除时刻',
    version         bigint      comment '版本',
    primary key (id)
) COMMENT = '简单示例表';
