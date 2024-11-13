package br.com.zup.library_manager.Service;

import br.com.zup.library_manager.Models.Author;
import br.com.zup.library_manager.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) { return this.authorRepository.save(author); }

    public List<Author> showAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        return authorOptional.orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Author author) {
        Author updatedAuthor = this.findAuthorById(author.getId());

        if (!updatedAuthor.getName().equals(author.getName())) {
            updatedAuthor.setName(author.getName());
        }

        if (!updatedAuthor.getLastname().equals(author.getLastname())) {
            updatedAuthor.setLastname(author.getLastname());
        }

        if (updatedAuthor.getYearOfBirth() != author.getYearOfBirth()){
            updatedAuthor.setYearOfBirth(author.getYearOfBirth());
        }

        if(updatedAuthor.getYearOfDeath() != author.getYearOfDeath()){
            updatedAuthor.setYearOfDeath(author.getYearOfDeath());
        }

        if (updatedAuthor.getBooks().equals(author.getBooks())) {
            updatedAuthor.setBooks(author.getBooks());
        }

        return saveAuthor(updatedAuthor);
    }
}
