package br.com.zup.library_manager.Controller.authetication.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Roles> roles;
}
