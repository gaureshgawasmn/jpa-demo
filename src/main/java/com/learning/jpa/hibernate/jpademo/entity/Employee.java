package com.learning.jpa.hibernate.jpademo.entity;

import jakarta.persistence.*;

@MappedSuperclass // when we use mapped super class annotation we can not mark it as entity and no table will be created for Employee
                // we have to retrieve both full time and part-time employee with seperate query unlike for below three we were using common query to retrieve
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // single table strategy for inheritance single table created for all the subclasses // problem nullable column
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // for each concrete class table will be created // problem column are repeated
//@Inheritance(strategy = InheritanceType.JOINED) // for each class table will be created and for subclass table will be created with additional fields and foreign key for base class table
public abstract class Employee {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    protected Employee() {
    }

    protected Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
