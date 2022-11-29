-- create table studentn
-- (
--     id            int not null auto_increment,
--     name          varchar(20),
--     surename      varchar(20),
--     student_class int,
--     birthday      date,
--     email         varchar(20),
--     courseCode    varchar(20),
--     phone         varchar(20),
--     primary key (id)
-- );


create table users
(

    username varchar(50),
    password varchar(150),
    enabled  int,
    primary key (username)
);


--
INSERT INTO studentn (name, sure_name, student_class, birthday, email, course_code, phone)
VALUES ('eli', 'kerimli',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000'),
       ('nusretin', 'kerimov',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000'),
       ('fikret', 'kerimov',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000'),
       ('adil', 'cabbarli',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000'),
       ('suleyman', 'cabbarli',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000'),
       ('qudret', 'kerimli',2,'2022-10-10','nusret@gmail.com','Myaaa','000-000-0000');




INSERT INTO users (username, password, enabled)
VALUES ('yusif', '{noop}1', 1),
       ('hesen', '{noop}2', 1),
       ('eli', '{noop}3', 1),
       ('huseyn', '{noop}4', 1);

create  table  authorities(
    username varchar(50),
    authority varchar(50)
);


insert into sectors (name)
values ('Az'),
       ('İngilis'),
       ('Alman'),
       ('Fransiz'),
       ('RUs');

insert into programming_languages (name)
values    ('Java'),
          ('Phyton'),
          ('Javascript'),
          ('Go'),
          ('Hack'),
          ('Pascal'),
          ('C'),
          ('Php'),
          ('Scala'),
          ('Perl');




INSERT  INTO  authorities (username, authority)
values ( 'yusif','read:all:students' ),
       ( 'yusif','open:new:student:page' ),
       ( 'yusif','save:student' ),
       ( 'yusif','edit:student' ),
       ( 'yusif','delete:student' ),
       ( 'yusif','search:student' ),


        ( 'hesen','read:all:students' ),
        ( 'hesen','open:new:student:page' ),
        ( 'hesen','save:student' ),

       ( 'eli','read:all:students' ),
       ( 'eli',' open:new:student:page' ),
       ( 'eli','save:student' ),

       ( 'huseyn','read:all:students' ),
       ( 'huseyn','delete:student' ),
       ( 'huseyn','open:new:student:page' ),
       ( 'huseyn','save:student' );




--
-- read:all:students
--     open:new:student:page
--     save:student
--     delete:student
--     edit:student
--     search:student

