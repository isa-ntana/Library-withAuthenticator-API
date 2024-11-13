package br.com.zup.library_manager.Controller.book;

import br.com.zup.library_manager.Controller.book.dtos.BookDTO;
import br.com.zup.library_manager.Controller.book.dtos.BookUpdateDTO;
import br.com.zup.library_manager.Models.Book;
import br.com.zup.library_manager.Service.BookService;
import br.com.zup.library_manager.Service.Mappers.BookMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() { return bookService.showAllBooks(); }

    @GetMapping("/{bookId}")
    public Book findBookById(@PathVariable Long bookId) { return bookService.findBookById(bookId); }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook(@RequestBody @Valid BookDTO bookDTO) { return bookService.saveBook(BookMapper.fromBookDTO(bookDTO)); }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBookById(@PathVariable Long bookId) { bookService.deleteBook(bookId);}

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Book updateBook(@RequestBody @Valid BookUpdateDTO bookUpdateDTO){
        return bookService.updateBook(BookMapper.fromBookUpdatedDTO(bookUpdateDTO));
    }
}
