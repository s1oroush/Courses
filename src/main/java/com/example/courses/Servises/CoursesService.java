package com.example.courses.Servises;

import com.example.courses.Entity.Courses;

public interface CoursesService{

    Iterable<Courses> fidnAll();

    Courses fetchStudentId(long id);

    Courses saveCourse(Courses courses);

    void updateCourseById(Long courseId, Courses courses);
}
