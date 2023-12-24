## Overview

### Models
#### Course
A course can have many student associated with it.

And a course can also have many reviews associated with it. 

A course have OneToMany relationship with Review as a course can have many reviews

A course has ManyToMany relationship with student.

#### Student
A student can enroll multiple courses.

A student have a passport associated with it which is unique. In current code case Student is owning the relationship.

A student has ManyToMany relationship with course.
#### Passport
A passport is unique per student.

The passport to student relationship is owned by student class , and we are proving mappedBy field name to indicate that in the field Student in passport class.

#### Review 
A review is unique to a course.

A review have Many-to-one relationship with course as one course can have many reviews

#### Employee
Employee is an abstract class having two concrete implementations FullTimeEmployee and PartTimeEmployee which are used to showcase options available for inheritance with JPA and Hibernate


### Spring Data JPA 
Using spring data jpa exposed the CourseSpringDataRepository at path /courses you can try it http://localhost:8081/courses

This will expose all the url with operations on courses. Helpful in prototype phase not recommended for production.