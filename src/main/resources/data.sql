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

insert into review (id, rating, description) values (50001,'5', 'Great Course');
insert into review (id, rating, description) values (50002,'4', 'Awesome Course');
insert into review (id, rating, description) values (50003,'1', 'Bad Course');
insert into review (id, rating) values (50004,'3');