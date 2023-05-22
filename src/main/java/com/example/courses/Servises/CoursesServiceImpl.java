package com.example.courses.Servises;

import com.example.courses.Entity.Courses;
import com.example.courses.Repositories.CoursesRepositories;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepositories coursesRepositories;

    @Override
    public Iterable<Courses> fidnAll(){ return coursesRepositories.findAll(); }

    @Override
    public Courses fetchStudentId(long id) {
            return coursesRepositories.findById(id).get();
    }

    @Override
    public Courses saveCourse(Courses courses) {
        Courses saveCourse =courses.builder()
                .courseId(courses.getCourseId())
                .name(courses.getName())
                .build();
        coursesRepositories.save(saveCourse);
        return saveCourse;
    }

    @Override
    public void updateCourseById(Long courseId, Courses courses) {
        Optional<Courses> optionalCourses = coursesRepositories.findById(courseId);
        if (optionalCourses.isPresent()) {
            Courses existing = optionalCourses.get();
            existing.setName(courses.getName());
            existing.setCourseId(courses.getCourseId());
            coursesRepositories.save(existing);
        } else {
            throw new RuntimeException();
        }
    }


}
