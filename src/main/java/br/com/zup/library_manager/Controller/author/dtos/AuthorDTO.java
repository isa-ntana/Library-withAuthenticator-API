package br.com.zup.library_manager.Controller.author.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private int yearOfBirth;

    @NotNull
    private int yearOfDeath;

    public AuthorDTO() {}
}
