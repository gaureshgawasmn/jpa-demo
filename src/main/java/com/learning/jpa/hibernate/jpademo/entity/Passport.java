package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") // mappedBy represent the field in student class for mapping the relation
    private Student student;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public Passport setId(int id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Passport setNumber(String number) {
        this.number = number;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Passport setStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
