package com.example.courses.Controller;

import com.example.courses.Servises.CoursesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoursesController {
        private final CoursesService coursesService;

        public CoursesController(CoursesService coursesService) {
                this.coursesService = coursesService;
        }

        @RequestMapping("/courses")
        public String getCourses (Model model){
                model.addAttribute("LIST",coursesService.fidnAll());
                        return "WebPage";
        }


        @RequestMapping("/salam")
        public String test(){
                return "aleyke salam";
        }
}
