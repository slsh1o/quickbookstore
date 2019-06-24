package com.provectus.quickbookstore.repositories;

import com.provectus.quickbookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
