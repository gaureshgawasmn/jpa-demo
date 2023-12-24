package com.learning.jpa.hibernate.jpademo;

import com.learning.jpa.hibernate.jpademo.entity.*;
import com.learning.jpa.hibernate.jpademo.repository.CourseRepository;
import com.learning.jpa.hibernate.jpademo.repository.EmployeeRepository;
import com.learning.jpa.hibernate.jpademo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // this can be use to test any particular scenario when server start up
        // testing save student with passport
        // studentRepository.saveStudentWithPassport(new Student("Mike"),new Passport("E12349D"));

		/*int courseId = 10001;
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5","Good course. Liked it!!!"));
		reviews.add(new Review("4","Good explanation"));
		courseRepository.addCourseReview(courseId, reviews);*/

        // testing add student and course to check the join table populating data
        // studentRepository.addStudentAndCourse(new Student("Tushar"), new Course("Microservice with hands on"));

        /*Employee employee = new PartTimeEmployee("Sham", BigDecimal.valueOf(25));
        employeeRepository.insert(employee);
        Employee employee2 = new FullTimeEmployee("Ram", BigDecimal.valueOf(25000));
        employeeRepository.insert(employee2);

        // logger.info("All Employees -> {}",employeeRepository.retrieveAllEmployee());

        logger.info("All Full time Employees -> {}",employeeRepository.retrieveAllFullTimeEmployee());
        logger.info("All Part time Employees -> {}",employeeRepository.retrieveAllPartTimeEmployee());*/
    }
}
