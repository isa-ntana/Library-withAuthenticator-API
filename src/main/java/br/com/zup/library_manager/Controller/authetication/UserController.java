package br.com.zup.library_manager.Controller.authetication;

import br.com.zup.library_manager.Controller.authetication.dtos.RegisterUserDTO;
import br.com.zup.library_manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void registerUser(@RequestBody RegisterUserDTO registerUserDTO){
        userService.registerUser(registerUserDTO);
    }
}
