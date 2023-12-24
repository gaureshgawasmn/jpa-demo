package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.JpaDemoApplication;
import com.learning.jpa.hibernate.jpademo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class )
class NativeQuriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void getAllCourses() {
        logger.info("Test getAllCourses is running...");
        List<Course> courses = repository.getAllCourses();
        courses.stream().forEach(System.out::println);
        assertEquals(5, courses.size());
    }

    @Test
    void getAllCoursesWith100() {
        logger.info("Test getAllCoursesWith100 is running...");
        List<Course> courses = repository.getAllCoursesWith100();
        courses.stream().forEach(System.out::println);
        assertEquals(1, courses.size());
    }
}