package br.com.zup.library_manager.Controller.book.dtos;

import br.com.zup.library_manager.Controller.author.dtos.AuthorDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BookUpdateDTO {
    @Setter
    @Getter
    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Size(max=5, message="Um livro deve ter no máximo 5 autores")
    private List<AuthorDTO> authors;

    public BookUpdateDTO() {}

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @Size(max = 5, message = "Um livro deve ter no máximo 5 autores") List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(@Size(max = 5, message = "Um livro deve ter no máximo 5 autores") List<AuthorDTO> authors) {
        this.authors = authors;
    }
}
