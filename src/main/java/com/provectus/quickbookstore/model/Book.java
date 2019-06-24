package com.provectus.quickbookstore.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    @Column(columnDefinition="VARCHAR(2000)")
    private String description;
    private Double price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"))
    @Fetch(FetchMode.SUBSELECT)// N + 1 issue solving
    private List<String> authors;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Book() {
    }

    public Book(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Book(String title, String description, Double price, List<String> authors, Set<Genre> genres) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.authors = authors;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
