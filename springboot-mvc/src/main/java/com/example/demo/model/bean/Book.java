package com.example.demo.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private Integer id;
	private String name;
	private Double price;
	private Integer amout;
	private Boolean pub;
}
