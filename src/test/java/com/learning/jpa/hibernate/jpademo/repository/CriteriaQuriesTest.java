package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.JpaDemoApplication;
import com.learning.jpa.hibernate.jpademo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class )
class CriteriaQuriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void all_courses() {
        // select c from Course c
        //1. Use criteria builder to create criteria query returning the expected object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for the table which are involve in the queries
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define predicate etc. using criteria builder
        //4. Add predicates using criteria query
        //5. Build the type query using em and cb
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courseList = query.getResultList();
        logger.info("Courses -> {}", courseList);
    }

    @Test
    void all_courses_like_100_step() {
        // select c from Course c where name like '%100 Steps'
        //1. Use criteria builder to create criteria query returning the expected object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for the table which are involve in the queries
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define predicate etc. using criteria builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
        //4. Add predicates using criteria query
        cq.where(like100Steps);
        //5. Build the type query using em and cb
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courseList = query.getResultList();
        logger.info("Courses with 100 steps-> {}", courseList);
    }

    @Test
    void all_courses_without_students() {
        // select c from Course c where c.students is empty
        //1. Use criteria builder to create criteria query returning the expected object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for the table which are involve in the queries
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define predicate etc. using criteria builder
        Predicate studentListIsEmpty = cb.isEmpty(courseRoot.get("students"));
        //4. Add predicates using criteria query
        cq.where(studentListIsEmpty);
        //5. Build the type query using em and cb
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courseList = query.getResultList();
        logger.info("Courses without students -> {}", courseList);
    }

    @Test
    void courses_join_students() {
        // Select c,s from Course c JOIN c.students s
        //1. Use criteria builder to create criteria query returning the expected object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for the table which are involve in the queries
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define predicate etc. using criteria builder
        Join<Object, Object> join = courseRoot.join("students");
        //4. Add predicates using criteria query
        //5. Build the type query using em and cb
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courseList = query.getResultList();
        logger.info("Courses without students -> {}", courseList);
    }

    @Test
    void courses_left_join_students() {
        // Select c,s from Course c LEFT JOIN c.students s
        //1. Use criteria builder to create criteria query returning the expected object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        //2. Define roots for the table which are involve in the queries
        Root<Course> courseRoot = cq.from(Course.class);
        //3. Define predicate etc. using criteria builder
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
        //4. Add predicates using criteria query
        //5. Build the type query using em and cb
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courseList = query.getResultList();
        logger.info("Courses without students -> {}", courseList);
    }
}