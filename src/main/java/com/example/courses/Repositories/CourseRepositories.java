package com.example.courses.Repositories;

import com.example.courses.Entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepositories extends CrudRepository<Course, Long> {

        Course findByCourseId(String courseId);
        void deleteByCourseId(String parseLong);

        Course findAllByCourseId(String courseId);
}
