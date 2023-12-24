package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private int id;
    private String rating;
    private String description;

    public Review() {
    }

    public Review(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Review setId(int id) {
        this.id = id;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public Review setRating(String rating) {
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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
