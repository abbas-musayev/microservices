package az.micro.courseservice.controller;

import az.micro.courseservice.entity.Course;
import az.micro.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course save(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping
    public Course getCourseById(@RequestParam Long id){
        return (Course) Hibernate.unproxy(courseService.getById(id));
    }
}
