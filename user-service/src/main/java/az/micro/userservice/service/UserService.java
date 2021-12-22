package az.micro.userservice.service;

import az.micro.userservice.client.Course;
import az.micro.userservice.client.Response;
import az.micro.userservice.entity.User;
import az.micro.userservice.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RestTemplate restTemplate;

    public User save(User user) {
        return userRepo.save(user);
    }

    public User getById(Long id){
        return userRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("UserNotFound"));
    }

    public Response getUserWithCourse(Long userId) {
        Response response = new Response();

        User user = (User) Hibernate.unproxy(userRepo.getById(userId));
        Course course = restTemplate
                .getForObject("http://localhost:8082/course?id=" + user.getCourseId(), Course.class);

        response.setUser(user);
        response.setCourse(course);

        return response;
    }
}
