package com.provectus.quickbookstore.repositories;

import com.provectus.quickbookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByGenres(Enum genre);
    List<Book> findByTitle(String title);
    List<Book> findByAuthors(String author);
}
