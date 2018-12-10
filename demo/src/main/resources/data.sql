insert into course (id, name, created_date, last_updated_date) values (10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into course (id, name, created_date, last_updated_date) values (10002, 'Spring in 50 steps', sysdate(), sysdate());
insert into course (id, name, created_date, last_updated_date) values (10003, 'Spring Boot in 100 steps', sysdate(), sysdate());

insert into passport (id, number) values (40001, 'PT0191919');
insert into passport (id, number) values (40002, 'PT3534565');
insert into passport (id, number) values (40003, 'PT2345435');

insert into student (id, name, passport_id) values (20001, 'Joao', 40001);
insert into student (id, name, passport_id) values (20002, 'Dri', 40002);
insert into student (id, name, passport_id) values (20003, 'Manel', 40003);



insert into review (id, rating, description, course_id) values (50001, '5', 'Great course', 10001);
insert into review (id, rating, description, course_id) values (50002, '3', 'Humpf', 10002);
insert into review (id, rating, description, course_id) values (50003, '4', 'Nice!', 10001);
insert into review (id, rating, description, course_id) values (50004, '4', 'Muito bom', 10001);
insert into review (id, rating, description, course_id) values (50005, '3', 'Porreiro', 10003);

