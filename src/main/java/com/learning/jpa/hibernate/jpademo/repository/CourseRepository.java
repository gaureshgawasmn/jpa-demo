package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional // required for delete, update operations not require for read operations
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    public void deleteById(int id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course){
        if(course.getId()==0){
            //insert
            em.persist(course);
        }else{
            //update
            em.merge(course);
        }
        return course;
    }

    // using JPQL
    public List<Course> getAllCourses(){
        TypedQuery<Course> namedQuery = em.createNamedQuery("query_get_all_courses", Course.class);
        return namedQuery.getResultList();
    }

    // using JPQL
    public List<Course> getAllCoursesWith100(){
        TypedQuery<Course> namedQuery = em.createNamedQuery("query_get_100_Step_courses", Course.class);
        return namedQuery.getResultList();
    }

    // using Native SQL
    public List<Course> getAllCoursesWith100Native(){
        Query nativeQuery = em.createNativeQuery("select * from Course", Course.class);
        return nativeQuery.getResultList();
    }

    // using Native SQL
    public List<Course> getAllCoursesWith100NativeWithParameter(){
        Query nativeQuery = em.createNativeQuery("select * from Course where id = ?", Course.class);
        nativeQuery.setParameter(1, 10001);
        return nativeQuery.getResultList();
    }

    // using Native SQL
    public List<Course> getAllCoursesWith100NativeWithParameter2(){
        Query nativeQuery = em.createNativeQuery("select * from Course where id = :id", Course.class);
        nativeQuery.setParameter("id", 10001);
        return nativeQuery.getResultList();
    }
}
