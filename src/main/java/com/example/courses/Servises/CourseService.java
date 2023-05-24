package com.example.courses.Servises;

import com.example.courses.Entity.Course;

public interface CourseService {

    Iterable<Course> findAll();

    Course fetchCourseById(long id);

    Course saveCourse(Course course);

    void updateCourseById(Long courseId, Course course);

    Course fetchCourseByCourseId(String courseId);

    void deleteByCourseId(String courseId);

    void patchCourseById(String courseId, Course course);
}
