package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.JpaDemoApplication;
import com.learning.jpa.hibernate.jpademo.entity.Course;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class )
class JPQLQuriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Autowired
    CourseRepository repository;

    @Test
    void getAllCourses() {
        logger.info("Test getAllCourses is running...");
        List<Course> courses = repository.getAllCourses();
        courses.stream().forEach(System.out::println);
        assertEquals(4, courses.size());
    }

    @Test
    void getAllCoursesWith100() {
        logger.info("Test getAllCoursesWith100 is running...");
        List<Course> courses = repository.getAllCoursesWith100();
        courses.stream().forEach(System.out::println);
        assertEquals(1, courses.size());
    }

    @Test
    void JPQL_courses_without_student(){
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> courseList = query.getResultList();
        logger.info("Courses without students -> {}",courseList);
    }

    @Test
    void JPQL_courses_with_atLeast2_student(){
        TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >=2 ", Course.class);
        List<Course> courseList = query.getResultList();
        logger.info("Courses -> {}",courseList);
    }

    @Test
    void JPQL_courses_with_orderBy_student(){
        TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> courseList = query.getResultList();
        logger.info("Courses -> {}",courseList);
    }

    @Test
    void JPQL_student_with_passport_in_certain_pattern(){
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> studentList = query.getResultList();
        logger.info("Student -> {}",studentList);
    }

    // JOIN => Select c,s from Course c JOIN c.students s
    // LEFT JOIN => Select c,s from Course c LEFT JOIN c.students s
    // CROSS JOIN => Select c,s from Course c, Student s
    @Test
    void join(){
        Query query = em.createQuery("Select c,s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result List size={}", resultList.size());
        for(Object[] object: resultList){
            logger.info("Course {}",object[0]);
            logger.info("Student {}",object[1]);
        }
    }

    @Test
    void left_join(){
        Query query = em.createQuery("Select c,s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result List size={}", resultList.size());
        for(Object[] object: resultList){
            logger.info("Course {}",object[0]);
            logger.info("Student {}",object[1]);
        }
    }

    @Test
    void cross_join(){
        Query query = em.createQuery("Select c,s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result List size={}", resultList.size());
        for(Object[] object: resultList){
            logger.info("Course {}",object[0]);
            logger.info("Student {}",object[1]);
        }
    }
}