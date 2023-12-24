package com.learning.jpa.hibernate.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@NamedQuery(name = "query_get_all_courses", query = "select c from Course c")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_100_Step_courses", query = "select c from Course c where name like '%100 Steps'")
})
// @Cacheable // added to use second level caching using ehcache
public class Course {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "course") // one to many is by default lazy fetch hence no need to add
    @JsonIgnore // added to ignore while forming json object
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany(mappedBy = "courses") // making owning side of relationship to student
    @JsonIgnore // added to ignore while forming json object
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Course setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Course addReviews(Review review) {
        this.reviews.add(review);
        return this;
    }

    public Course removeReview(Review review) {
        this.reviews.remove(review);
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course addStudent(Student student) {
        this.students.add(student);
        return this;
    }

    public Course removeStudent(Student student) {
        this.students.remove(student);
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
