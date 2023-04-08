DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(50) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    version INT(10) NOT NULL DEFAULT 1 COMMENT '乐观锁版本号',
    DELETED INT(10) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    CREATE_TIME DATE COMMENT '创建时间',
    modify_time DATE COMMENT '更新时间',
    PRIMARY KEY (id)
);

DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'a',1,'test1@baomidou.com'),
(2, 'b',2,'est2@baomidou.com'),
(3, 'c', 28, 'test3@baomidou.com'),
(4, 'd', 21, 'test4@baomidou.com'),
(5, 'e', 24, 'test5@baomidou.com');