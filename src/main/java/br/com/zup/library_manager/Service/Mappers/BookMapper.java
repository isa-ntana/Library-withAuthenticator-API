package br.com.zup.library_manager.Service.Mappers;

import br.com.zup.library_manager.Controller.book.dtos.BookDTO;
import br.com.zup.library_manager.Controller.book.dtos.BookUpdateDTO;
import br.com.zup.library_manager.Models.Author;
import br.com.zup.library_manager.Models.Book;
import br.com.zup.library_manager.Repositories.AuthorRepository;

import java.util.List;

public class BookMapper {
    public static Book fromBookDTO(BookDTO bookDTO) {
        AuthorRepository authorRepository;

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());

        List<Author> authorsList = bookDTO.getAuthors().stream().map(AuthorMapper::fromAuthorDTO).toList();
        book.setAuthors(authorsList);

        return book;
    }

    public static Book fromBookUpdatedDTO(BookUpdateDTO bookUpdateDTO) {
        Book book = new Book();
        book.setId(bookUpdateDTO.getId());
        book.setTitle(bookUpdateDTO.getTitle());
        book.setDescription(bookUpdateDTO.getDescription());

        List<Author> authorsList = bookUpdateDTO.getAuthors().stream().map(AuthorMapper::fromAuthorDTO).toList();
        book.setAuthors(authorsList);

        return book;
    }
}
