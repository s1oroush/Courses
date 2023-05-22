package com.example.courses.Controller;

import com.example.courses.Entity.Courses;
import com.example.courses.Servises.CoursesService;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class RESTController {

    private final CoursesService service ;

    public RESTController(CoursesService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Courses getCourse(@PathVariable("id") long id){
        return service.fetchStudentId(id);
    }

    @GetMapping("/all")
    public Iterable<Courses> getAllCoursesByID(){
        return service.fidnAll();
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody  Courses courses){
        Courses savedCourses = service.saveCourse(courses);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Location","/Course/"+savedCourses.getId().toString());
        return new ResponseEntity(headers , HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity updateById(@PathVariable("id")Long courseId,@RequestBody Courses courses){
        service.updateCourseById(courseId,courses);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }












}
