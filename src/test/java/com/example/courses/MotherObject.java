package com.example.courses;

import com.example.courses.Entity.Course;

import java.util.ArrayList;
import java.util.List;

public class MotherObject {

    public static  String DUMMY = "dummy";

        public static Iterable<Course> courseIterable(){
        List<Course> course = new ArrayList<>();
        course.add(anyCourse());
        course.add(anyCourse());
        course.add(anyCourse());
        return course;
    }

    public static Course anyCourse(){
        return Course.builder()
                .name(DUMMY)
                .courseId(DUMMY)
                .build();
    }

    public static Course anyCourseWithId() {
        return Course.builder()
                .id(1L)
                .name(DUMMY)
                .courseId(DUMMY)
                .build();
    }

    public static long anyId() {
        return 1L;
    }

    public static String anyCourseId() {
        return "1";
    }


}
