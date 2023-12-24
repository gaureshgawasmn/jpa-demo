package com.learning.jpa.hibernate.jpademo.repository;

import com.learning.jpa.hibernate.jpademo.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional // required for delete, update operations not require for read operations
public class EmployeeRepository {

    @Autowired
    EntityManager em;

    // insert employee
    public void insert(Employee employee) {
        em.persist(employee);
    }

    // Retrieve all employee
    // only work in case of
    // @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    // @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    // @Inheritance(strategy = InheritanceType.JOINED)
    /*public List<Employee> retrieveAllEmployee() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }*/

    // need to fetch full-time and part-time separately in case of MapperSupperClass
    public List<FullTimeEmployee> retrieveAllFullTimeEmployee() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployee() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

}
