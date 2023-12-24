package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.entity.Passport;
import com.learning.jpa.hibernate.jpademo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional // required for delete, update operations not require for read operations
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public void deleteById(int id){
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student){
        if(student.getId()==0){
            //insert
            em.persist(student);
        }else{
            //update
            em.merge(student);
        }
        return student;
    }

    public Student saveStudentWithPassport(Student student, Passport passport){
        student.setPassport(passport);
        em.persist(passport);
        em.persist(student);
        return student;
    }

    // using JPQL
    public List<Student> getAllStudents(){
        TypedQuery<Student> namedQuery = em.createNamedQuery("query_get_all_students", Student.class);
        return namedQuery.getResultList();
    }

    // using JPQL
    public List<Student> getAllStudentsWith100(){
        TypedQuery<Student> namedQuery = em.createNamedQuery("query_get_100_Step_students", Student.class);
        return namedQuery.getResultList();
    }

    // using Native SQL
    public List<Student> getAllStudentsWith100Native(){
        Query nativeQuery = em.createNativeQuery("select * from Student", Student.class);
        return nativeQuery.getResultList();
    }

    // using Native SQL
    public List<Student> getAllStudentsWith100NativeWithParameter(){
        Query nativeQuery = em.createNativeQuery("select * from Student where id = ?", Student.class);
        nativeQuery.setParameter(1, 10001);
        return nativeQuery.getResultList();
    }

    // using Native SQL
    public List<Student> getAllStudentsWith100NativeWithParameter2(){
        Query nativeQuery = em.createNativeQuery("select * from Student where id = :id", Student.class);
        nativeQuery.setParameter("id", 10001);
        return nativeQuery.getResultList();
    }
}
