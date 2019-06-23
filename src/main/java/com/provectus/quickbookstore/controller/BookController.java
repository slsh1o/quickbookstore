package com.provectus.quickbookstore.controller;

import com.provectus.quickbookstore.model.Book;
import com.provectus.quickbookstore.model.Genre;
import com.provectus.quickbookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping()
    public String booksList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("genres", Genre.values());

        return "books";
    }

    @PostMapping()
    public String addBook(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String authors,
            @RequestParam Map<String,String> form
    ) {
        /*book.setTitle(title);
        book.setDescription(description);
        book.setPrice(price);
        book.setAuthors(Arrays.asList(authors.split("\\s*,\\s*")));*/

        Book book = new Book(title, description, price);
        book.setAuthors(Arrays.asList(authors.split("\\s*,\\s*")));

        // Get all available genres and convert them to Set
        Set<String> genres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.toSet());

        // Compare converted genres from above against value fetched from form's checkboxes
        Set<Genre> gTemp = new HashSet<>();
        for (String value : form.keySet()) {
            if(genres.contains(value)) {
                gTemp.add(Genre.valueOf(value));
                //book.getGenres().add(Genre.valueOf(value));
            }
        }
        book.setGenres(gTemp);

        bookRepository.save(book);
        return "books";
    }
}
