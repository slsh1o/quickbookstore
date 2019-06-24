package com.provectus.quickbookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "order_list")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firsName;
    private String lastName;
    private String address;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book orderedBook;

    public Order() {
    }

    public Order(String firsName, String lastName, String address, Integer quantity, Book orderedBook) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.address = address;
        this.quantity = quantity;
        this.orderedBook = orderedBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getOrderedBook() {
        return orderedBook;
    }

    public void setOrderedBook(Book orderedBook) {
        this.orderedBook = orderedBook;
    }
}
