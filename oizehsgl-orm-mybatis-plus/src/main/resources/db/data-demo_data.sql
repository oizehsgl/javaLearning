DELETE
FROM demo_data;

INSERT INTO demo_data (id, name, age, email)
VALUES (1, 'Jone', 11, 'test1@baomidou.com'),
       (2, 'Jack', 12, 'test2@baomidou.com'),
       (3, 'Tom', 13, 'test3@baomidou.com'),
       (4, 'Sandy', 14, 'test4@baomidou.com'),
       (5, 'Billie', 15, 'test5@baomidou.com');
INSERT INTO demo_data (id, name, age, email,deleted)
VALUES (11, 'Jone', 1, 'test1@baomidou.com',true),
       (12, 'Jack', 2, 'test2@baomidou.com',true),
       (13, 'Tom', 3, 'test3@baomidou.com',true),
       (14, 'Sandy', 4, 'test4@baomidou.com',false),
       (15, 'Billie', 5, 'test5@baomidou.com',false);
