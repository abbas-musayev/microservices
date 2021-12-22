package az.micro.userservice.controller;

import az.micro.userservice.client.Response;
import az.micro.userservice.entity.User;
import az.micro.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
            return userService.save(user);
    }

    @GetMapping
    public Response getUserWithCourse(@RequestParam Long userId){
        return userService.getUserWithCourse(userId);
    }



}
