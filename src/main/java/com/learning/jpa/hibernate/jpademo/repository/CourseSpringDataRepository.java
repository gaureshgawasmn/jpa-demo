package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses") // to use the spring data rest otherwise not needed , this will expose this repo at given path
public interface CourseSpringDataRepository extends JpaRepository<Course, Integer> {

    List<Course> findByName(String name);
    @Query(value = "select c from Course c where name like '%100 Steps'")
    List<Course> getAllCoursesUsingLike();
    @Query("SELECT c FROM Course c WHERE name LIKE %:searchTerm%")
    List<Course> getAllCoursesUsingLikeWithParam(@Param("searchTerm") String searchTerm);
    @Query(value = "select * from Course c where name like '%100 Steps'", nativeQuery = true)
    List<Course> getAllCoursesUsingLikeNativeQuery();
    @Query(name = "query_get_100_Step_courses")
    List<Course> getAllCoursesUsingLikeNamedQuery();
}
