package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY) // fetch type lazy will not load the passport details unless it is asked
    private Passport passport;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
