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
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;
    @Autowired
    EntityManager em;

    @Test
    void findById() {
        Optional<Course> course = repository.findById(10001);
        assertTrue(course.isPresent());
    }

    @Test
    void findById_notPresent() {
        Optional<Course> course = repository.findById(20001);
        assertFalse(course.isPresent());
    }


    @Test
    @DirtiesContext // this annotation will reset the data after the test is run
    @Disabled
        // need to remove the reviews also before deleting course
    void deleteById() {
        logger.info("Test deleteById is running...");
        repository.deleteById(10001);
        assertNull(repository.findById(10001));
    }

    @Test
    void playing_around_with_Spring_DATA_JPA() {
        Course course = new Course("New Course for spring data jpa test");
        repository.save(course);
        course.setName("New Course for spring data jpa test Updated");
        repository.save(course);
        logger.info("Courses -> {}", repository.findAll());
        logger.info("Courses count -> {}", repository.count());
    }

    @Test
    void playing_around_with_Spring_DATA_JPA_sort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        logger.info("Sorted Courses -> {}", repository.findAll(sort));
        logger.info("Courses count -> {}", repository.count());
    }

    @Test
    void playing_around_with_Spring_DATA_JPA_pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Pages Courses -> {}", firstPage.getContent());

        Pageable second = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(second);
        logger.info("Second Pages Courses -> {}", secondPage.getContent());
    }

    @Test
    void custom_queries() {
        List<Course> courses = repository.findByName("JPA in 50 Steps");
        logger.info("Courses -> {}", courses);
        logger.info("Courses getAllCoursesUsingLike -> {}", repository.getAllCoursesUsingLike());
        logger.info("Courses getAllCoursesUsingLikeWithParam -> {}", repository.getAllCoursesUsingLikeWithParam("50 Steps"));
        logger.info("Courses getAllCoursesUsingLikeNativeQuery -> {}", repository.getAllCoursesUsingLikeNativeQuery());
        logger.info("Courses getAllCoursesUsingLikeNamedQuery -> {}", repository.getAllCoursesUsingLikeNamedQuery());
    }
}