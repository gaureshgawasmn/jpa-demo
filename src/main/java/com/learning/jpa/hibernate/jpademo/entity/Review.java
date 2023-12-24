package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private ReviewRating rating;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)  // **ToOne type is always eager fetching hence provided the lazy type
    private Course course;

    public Review() {
    }

    public Review(ReviewRating rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Review setId(int id) {
        this.id = id;
        return this;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public Review setRating(ReviewRating rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Review setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Review setCourse(Course course) {
        this.course = course;
        return this;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
