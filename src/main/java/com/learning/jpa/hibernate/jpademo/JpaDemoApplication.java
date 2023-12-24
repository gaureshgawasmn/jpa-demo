package com.learning.jpa.hibernate.jpademo;

import com.learning.jpa.hibernate.jpademo.entity.Course;
import com.learning.jpa.hibernate.jpademo.entity.Passport;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import com.learning.jpa.hibernate.jpademo.repository.CourseRepository;
import com.learning.jpa.hibernate.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

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
    }
}
