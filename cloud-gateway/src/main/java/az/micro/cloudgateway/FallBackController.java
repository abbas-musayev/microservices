package az.micro.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than excepted, please try again later";
    }


    @GetMapping("/courseServiceFallBack")
    public String courseServiceFallBackMethod(){
        return "Course Service is taking longer than excepted, please try again later";
    }
}
