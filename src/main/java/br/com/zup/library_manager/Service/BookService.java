package br.com.zup.library_manager.Service;

import br.com.zup.library_manager.Models.Book;
import br.com.zup.library_manager.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) { return bookRepository.save(book); }

    public List<Book> showAllBooks() { return bookRepository.findAll(); }

    public Book findBookById(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id){ bookRepository.deleteById(id); }

    public Book updateBook(Book book){
        Book bookUpdated = findBookById(book.getId());

        if(!bookUpdated.getTitle().equals(book.getTitle())){
            bookUpdated.setTitle(book.getTitle());
        }

        if(!bookUpdated.getDescription().equals(book.getDescription())){
            bookUpdated.setDescription(book.getDescription());
        }

        if(!bookUpdated.getAuthors().equals(book.getAuthors())){
            bookUpdated.setAuthors(book.getAuthors());
        }

        return saveBook(bookUpdated);
    }
}
