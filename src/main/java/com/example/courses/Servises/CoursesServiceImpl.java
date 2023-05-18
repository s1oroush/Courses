package com.example.courses.Servises;

import com.example.courses.Entity.Courses;
import com.example.courses.Repositories.CoursesRepositories;
import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepositories coursesRepositories;

    @Override
    public Iterable<Courses> fidnAll(){ return coursesRepositories.findAll(); }
}
