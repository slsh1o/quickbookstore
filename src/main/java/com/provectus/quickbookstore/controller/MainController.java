package com.provectus.quickbookstore.controller;

import com.provectus.quickbookstore.model.Book;
import com.provectus.quickbookstore.model.Genre;
import com.provectus.quickbookstore.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final BookRepository bookRepository;

    public MainController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String main(
            @RequestParam(required = false, defaultValue = "") String genreFilter,
            @RequestParam(required = false, defaultValue = "") String filter,
            @RequestParam(required = false, defaultValue = "") String authorFilter,
            Model model
    ) {
        List<Book> books;

        if (genreFilter != null && !genreFilter.isEmpty()) {
            books = bookRepository.findByGenres(Genre.valueOf(genreFilter.trim()));
        } else if (filter != null && !filter.isEmpty()) {
            books = bookRepository.findByTitle(filter.trim());
            books.addAll(bookRepository.findByAuthors(filter.trim()));
        } else if (authorFilter != null && !authorFilter.isEmpty()) {
            books = bookRepository.findByAuthors(authorFilter.trim());
        } else {
            books = bookRepository.findAll();
        }

        model.addAttribute("books", books);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("genreFilter", genreFilter);
        model.addAttribute("filter", filter);

        return "main";
    }
}
