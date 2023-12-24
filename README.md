## Overview

### Models
#### Course
A course can have many student associated with it.

And a course can also have many reviews associated with it. 

A course have OneToMany relationship with Review as a course can have many reviews


#### Student
A student can enroll multiple courses.

A student have a passport associated with it which is unique. In current code case Student is owning the relationship.

#### Passport
A passport is unique per student.

The passport to student relationship is owned by student class , and we are proving mappedBy field name to indicate that in the field Student in passport class.

#### Review 
A review is unique to a course.

A review have Many-to-one relationship with course as one course can have many reviews