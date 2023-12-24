package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.JpaDemoApplication;
import com.learning.jpa.hibernate.jpademo.entity.Passport;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class )
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional // this will make entire test transactional if removed it will fail for last line
    public void retrieveStudentAndPassport() {
        Student student = em.find(Student.class, 20001);
        logger.info("Student =>" + student);
        logger.info("Passport =>" + student.getPassport());
    }

    @Test
    @Transactional // this will make entire test transactional if removed it will fail for last line
    public void retrievePassportAndStudent() {
        Passport passport = em.find(Passport.class, 40001);
        logger.info("passport =>" + passport);
        logger.info("Student =>" + passport.getStudent());
    }
}