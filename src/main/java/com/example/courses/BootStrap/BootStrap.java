package com.example.courses.BootStrap;

import com.example.courses.Entity.Courses;
import com.example.courses.Repositories.CoursesRepositories;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class BootStrap implements CommandLineRunner {
    private final CoursesRepositories coursesRepositories;


    @Override
    public void run(String... args) throws Exception {
        Courses compiler= new Courses();
        compiler.setName("compiler");
        compiler.setCourseId("1001");

        Courses dataStructure= new Courses();
        dataStructure.setName("DataStructure");
        dataStructure.setCourseId("1002");

        Courses algorithm= new Courses();
        algorithm.setName("Algorithm");
        algorithm.setCourseId("1003");

        Courses compilerSaved =coursesRepositories.save(compiler);
        Courses dataStructureSaved =coursesRepositories.save(dataStructure);
        Courses algorithmSaved =coursesRepositories.save(algorithm);

        coursesRepositories.save(compilerSaved);
        coursesRepositories.save(dataStructureSaved);
        coursesRepositories.save(algorithmSaved);

        System.out.println(" IN BootStrap");
        System.out.println("Courses count: "+ coursesRepositories.count());
    }
}
