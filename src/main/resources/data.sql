insert into Course (id, name, last_updated_date, created_date) values (10001, 'JPA in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into Course (id, name, last_updated_date, created_date) values (10002, 'Spring in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into Course (id, name, last_updated_date, created_date) values (10003, 'Hibernate in 100 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into Course (id, name, last_updated_date, created_date) values (10004, 'Spring Boot in 50 Steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- passport insert we are doing early because we need this passport id for student table
insert into Passport (id, number) values (40001,'E12345D');
insert into Passport (id, number) values (40002,'E12346D');
insert into Passport (id, number) values (40003,'E12347D');
insert into Passport (id, number) values (40004,'E12348D');

insert into Student (id, name, passport_id) values (20001,'Jay',40001);
insert into Student (id, name, passport_id) values (20002,'Sham',40002);
insert into Student (id, name, passport_id) values (20003,'Ram',40003);
insert into Student (id, name, passport_id) values (20004,'Vijay',40004);

insert into review (id, rating, description, course_id) values (50001,'5', 'Great Course',10001);
insert into review (id, rating, description, course_id) values (50002,'4', 'Awesome Course',10001);
insert into review (id, rating, description, course_id) values (50003,'1', 'Bad Course',10004);
insert into review (id, rating, course_id) values (50004,'3',10003);

insert into student_course (student_id, course_id) values (20001, 10001);
insert into student_course (student_id, course_id) values (20001, 10002);
insert into student_course (student_id, course_id) values (20001, 10004);
insert into student_course (student_id, course_id) values (20002, 10001);
insert into student_course (student_id, course_id) values (20002, 10003);
insert into student_course (student_id, course_id) values (20003, 10004);
insert into student_course (student_id, course_id) values (20004, 10003);