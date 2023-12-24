package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.JpaDemoApplication;
import com.learning.jpa.hibernate.jpademo.entity.Course;
import com.learning.jpa.hibernate.jpademo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class )
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;
    @Autowired
    EntityManager em;
    @Test
    @Transactional
    void findById() {
        logger.info("Test findById is running...");
        Course course = repository.findById(10001);
        assertEquals("JPA in 50 Steps", course.getName());
        logger.info("reviews -> {}", course.getReviews());
    }

    @Test
    @Transactional
    void findById_firstLevelCache() {
        // first time only query fire second time not if mark it as transactional if removed this annotation it will call database twice
        // boundary of first level cache is transaction boundary
        Course course = repository.findById(10001);
        logger.info("Course fetch -> {}", course);
        Course course2 = repository.findById(10001);
        logger.info("Course fetch again-> {}", course2);
    }

    @Test
    @DirtiesContext // this annotation will reset the data after the test is run
    @Disabled // need to remove the reviews also before deleting course
    void deleteById() {
        logger.info("Test deleteById is running...");
        repository.deleteById(10001);
        assertNull(repository.findById(10001));
    }

    @Test
    @DirtiesContext // this annotation will reset the data after the test is run
    void save() {
        logger.info("Test save is running...");
        repository.save(new Course("Microservices in 100 Steps"));

        // update test
        Course course = repository.findById(10001);
        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);
        assertEquals("JPA in 50 Steps - Updated", repository.findById(10001).getName());

    }

    @Test
    void getAllCoursesWith100Native() {
        logger.info("Test getAllCoursesWith100Native is running...");
        List<Course> courses = repository.getAllCoursesWith100Native();
        courses.stream().forEach(System.out::println);
        assertEquals(4, courses.size());
    }

    @Test
    void getAllCoursesWith100NativeWithParameter() {
        logger.info("Test getAllCoursesWith100NativeWithParameter is running...");
        List<Course> courses = repository.getAllCoursesWith100NativeWithParameter();
        courses.stream().forEach(System.out::println);
        assertEquals(1, courses.size());
    }

    @Test
    void getAllCoursesWith100NativeWithParameter2() {
        logger.info("Test getAllCoursesWith100NativeWithParameter2 is running...");
        List<Course> courses = repository.getAllCoursesWith100NativeWithParameter2();
        courses.stream().forEach(System.out::println);
        assertEquals(1, courses.size());
    }

    @Test
    @Transactional
    void retrieveReviewsForCourse(){
        Course course = repository.findById(10001);
        logger.info("{}",course.getReviews());
    }

    @Test
    @Transactional
    void retrieveCourseForReview(){
        Review review = em.find(Review.class, 50001);
        logger.info("{}",review.getCourse());
    }
}