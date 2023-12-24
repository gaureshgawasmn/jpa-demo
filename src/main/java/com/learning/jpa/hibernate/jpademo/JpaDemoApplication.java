package com.learning.jpa.hibernate.jpademo;

import com.learning.jpa.hibernate.jpademo.entity.Passport;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import com.learning.jpa.hibernate.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this can be use to test any particular scenario when server start up
		/*Student student = new Student("Mike");
		Passport passport = new Passport("E12349D");
		repository.saveStudentWithPassport(student,passport);*/
	}
}
