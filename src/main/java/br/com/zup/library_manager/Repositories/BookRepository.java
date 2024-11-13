package br.com.zup.library_manager.Repositories;

import br.com.zup.library_manager.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
