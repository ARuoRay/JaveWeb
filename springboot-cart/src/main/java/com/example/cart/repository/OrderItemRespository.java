package com.example.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cart.entity.OrderItem;

@Repository
public interface OrderItemRespository extends JpaRepository<OrderItem, Long>{

}
