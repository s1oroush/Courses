package com.example.courses.BootStrap;

import com.example.courses.Entity.Course;
import com.example.courses.Repositories.CourseRepositories;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class BootStrap implements CommandLineRunner {
    private final CourseRepositories courseRepositories;


    @Override
    public void run(String... args) throws Exception {
        Course compiler= new Course();
        compiler.setName("compiler");
        compiler.setCourseId("1001");


        Course dataStructure= new Course();
        dataStructure.setName("DataStructure");
        dataStructure.setCourseId("1002");


        Course algorithm= new Course();
        algorithm.setName("Algorithm");
        algorithm.setCourseId("1003");


        Course computerPrograming= new Course();
        computerPrograming.setName("Computer Programing");
        computerPrograming.setCourseId("1004");


        Course mathematics= new Course();
        mathematics.setName("Mathematics");
        mathematics.setCourseId("1005");


        Course java= new Course();
        java.setName("Java");
        java.setCourseId("1006");


        Course python= new Course();
        python.setName("Python");
        python.setCourseId("1007");


        Course physics= new Course();
        physics.setName("Physics");
        physics.setCourseId("1008");


        Course jUnit= new Course();
        jUnit.setName("JUnit");
        jUnit.setCourseId("1009");


        Course compilerSaved = courseRepositories.save(compiler);
        Course dataStructureSaved = courseRepositories.save(dataStructure);
        Course algorithmSaved = courseRepositories.save(algorithm);
        Course computerProgramingSaved = courseRepositories.save(computerPrograming);
        Course mathematicsSaved = courseRepositories.save(mathematics);
        Course javaSaved = courseRepositories.save(java);
        Course pythonSaved = courseRepositories.save(python);
        Course physicsSaved = courseRepositories.save(physics);
        Course jUnitSaved = courseRepositories.save(jUnit);


        courseRepositories.save(compilerSaved);
        courseRepositories.save(dataStructureSaved);
        courseRepositories.save(algorithmSaved);
        courseRepositories.save(computerProgramingSaved);
        courseRepositories.save(mathematicsSaved);
        courseRepositories.save(javaSaved);
        courseRepositories.save(pythonSaved);
        courseRepositories.save(physicsSaved);
        courseRepositories.save(jUnitSaved);

        System.out.println(" IN BootStrap");
        System.out.println("Courses count: "+ courseRepositories.count());
    }
}
