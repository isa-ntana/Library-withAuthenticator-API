package br.com.zup.library_manager.Controller.book.dtos;

import br.com.zup.library_manager.Controller.author.dtos.AuthorDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDTO {

    @NotNull
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Size(max=5, message="Um livro deve ter no máximo 5 autores")
    private List<AuthorDTO> authors;

    public BookDTO() {}

}
