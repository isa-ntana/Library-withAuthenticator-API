package br.com.zup.library_manager.Controller.author.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private int yearOfBirth;

    private int yearOfDeath;

    public AuthorUpdateDTO() {}
}
