package com.learning.jpa.hibernate.jpademo;

import com.learning.jpa.hibernate.jpademo.entity.Course;
import com.learning.jpa.hibernate.jpademo.entity.Passport;
import com.learning.jpa.hibernate.jpademo.entity.Review;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import com.learning.jpa.hibernate.jpademo.repository.CourseRepository;
import com.learning.jpa.hibernate.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this can be use to test any particular scenario when server start up
		/*Student student = new Student("Mike");
		Passport passport = new Passport("E12349D");
		repository.saveStudentWithPassport(student,passport);*/
		int courseId = 10001;
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5","Good course. Liked it!!!"));
		reviews.add(new Review("4","Good explanation"));
		courseRepository.addCourseReview(courseId, reviews);
	}
}
