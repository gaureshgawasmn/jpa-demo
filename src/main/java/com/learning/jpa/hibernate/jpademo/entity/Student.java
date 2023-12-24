package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY) // fetch type lazy will not load the passport details unless it is asked
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")) // added this to customize the join table
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Passport getPassport() {
        return passport;
    }

    public Student setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student addCourse(Course course) {
        this.courses.add(course);
        return this;
    }

    public Student removeCourse(Course course) {
        this.courses.remove(course);
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
