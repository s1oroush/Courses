package com.example.courses.Controller;

import com.example.courses.Entity.Course;
import com.example.courses.Servises.CourseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class RESTController {

    private final CourseService service ;

    public RESTController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable("courseId") String courseId){
        return service.fetchCourseByCourseId(courseId);
    }

    @PatchMapping("/{courseId}")
    public ResponseEntity updateStudentPatchById(@PathVariable("courseId")String courseId, @RequestBody Course course){
        service.patchCourseById(courseId , course);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public Iterable<Course> getAllCoursesByID(){
        return service.findAll();
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody Course course){
        Course savedCourse = service.saveCourse(course);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Location","/Course/"+ savedCourse.getId().toString());
        return new ResponseEntity(headers , HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity updateById(@PathVariable("id")Long courseId,@RequestBody Course course){
        service.updateCourseById(courseId, course);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity deleteById(@PathVariable("courseId") String courseId){
        service.deleteByCourseId(courseId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }










}
