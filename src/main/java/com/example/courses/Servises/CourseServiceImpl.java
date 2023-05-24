package com.example.courses.Servises;

import com.example.courses.Entity.Course;
import com.example.courses.Repositories.CourseRepositories;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Data
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepositories courseRepositories;

    public CourseServiceImpl(CourseRepositories courseRepositories) {
        this.courseRepositories = courseRepositories;
    }


    @Override
    public Course saveCourse(Course course) {
        Course saveCourse = course.builder()
                .courseId(course.getCourseId())
                .name(course.getName())
                .build();
        return courseRepositories.save(saveCourse);
    }

    @Override
    public void updateCourseById(Long courseId, Course course) {
        Optional<Course> optionalCourses = courseRepositories.findById(courseId);
        if (optionalCourses.isPresent()) {
            Course existing = optionalCourses.get();
            existing.setName(course.getName());
            existing.setCourseId(course.getCourseId());
            courseRepositories.save(existing);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Iterable<Course> findAll() {
        return courseRepositories.findAll();
    }

    @Override
    public Course fetchCourseByCourseId(String courseId) {
        Course course = courseRepositories.findAllByCourseId(courseId);
        return course;
    }

    @Override
    public void deleteByCourseId(String courseId) {
        courseRepositories.deleteByCourseId(courseId);
    }

    @Override
    public void patchCourseById(String courseId, Course course) {
        Course existing = courseRepositories.findByCourseId(courseId);
        if (StringUtils.hasText(course.getName())) {
            existing.setName(course.getName());
        }

        courseRepositories.save(saveCourse(course));
    }

    @Override
    public Course fetchCourseById(long id) {
        return courseRepositories.findById(id).get();
    }


}
