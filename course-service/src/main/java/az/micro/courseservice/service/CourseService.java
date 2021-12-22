package az.micro.courseservice.service;

import az.micro.courseservice.entity.Course;
import az.micro.courseservice.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public Course getById(Long courseId){
        return courseRepo.getById(courseId);
    }
}
