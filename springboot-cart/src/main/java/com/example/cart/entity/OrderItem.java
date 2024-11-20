package com.example.cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_item")
public class OrderItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int quantity;
	
	//訂單的商品(orderitem)與訂單(order)是多對一
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	
	//商品庫存(oderitem)與訂單商品(product)是多對伊關係
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
}
