package br.com.zup.library_manager.Service.Mappers;

import br.com.zup.library_manager.Controller.author.dtos.AuthorDTO;
import br.com.zup.library_manager.Controller.author.dtos.AuthorUpdateDTO;
import br.com.zup.library_manager.Models.Author;

public class AuthorMapper {
    public static Author fromAuthorDTO(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setLastname(authorDTO.getLastName());
        author.setYearOfBirth(authorDTO.getYearOfBirth());
        author.setYearOfDeath(authorDTO.getYearOfDeath());

        return author;
    }

    public static Author fromAuthorUpdateDTO(AuthorUpdateDTO authorUpdateDTO) {
        Author author = new Author();
        author.setId(authorUpdateDTO.getId());
        author.setName(authorUpdateDTO.getName());
        author.setLastname(authorUpdateDTO.getLastName());
        author.setYearOfBirth(authorUpdateDTO.getYearOfBirth());
        author.setYearOfDeath(authorUpdateDTO.getYearOfDeath());

        return author;
    }
}
