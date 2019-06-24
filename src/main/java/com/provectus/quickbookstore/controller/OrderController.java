package com.provectus.quickbookstore.controller;

import com.provectus.quickbookstore.model.Book;
import com.provectus.quickbookstore.model.Order;
import com.provectus.quickbookstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("{book}")
    public String orderBook(
            @PathVariable Book book,
            Model model
    ) {
        model.addAttribute("book", book);

        return "order";
    }

    @PostMapping()
    public String addOrder(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String address,
            @RequestParam Integer quantity,
            @RequestParam("bookId") Book book
    ) {
        Order order = new Order(firstName, lastName, address, quantity, book);

        orderRepository.save(order);
        return"redirect:/";
    }
}
