package br.com.zup.library_manager.Controller.authetication;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Map<String, Date> returnDate(){
        return Map.of("dateNow", new Date());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/register")
    public Map<String, String> adminRoute(){
        return Map.of("message", "You now have access as an admin");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/access")
    public Map<String, String> userRoute(){
        return Map.of("message", "You now have access as an user");
    }

}
