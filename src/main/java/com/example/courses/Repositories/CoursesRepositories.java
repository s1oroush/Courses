package com.example.courses.Repositories;

import com.example.courses.Entity.Courses;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepositories extends CrudRepository<Courses, Long> {
}
