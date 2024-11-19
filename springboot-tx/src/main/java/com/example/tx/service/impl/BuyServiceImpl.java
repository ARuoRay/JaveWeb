package com.example.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tx.service.BookService;
import com.example.tx.service.BuyService;

import jakarta.transaction.Transactional;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BookService bookService;

	@Transactional
	@Override
	public void buyOneBook(String username, Integer bookId) {
		
		System.out.println(username+"要買書");
		
		Integer bookPrice=bookService.getBookPrice(bookId);
		System.out.print("bookId price:"+bookPrice);
		
		bookService.reduceBookAmount(bookId, 1);
		
		bookService.reduceWalletBalance(username, bookPrice);
		
		System.out.println(username+"多了一份知識，少了一份憂愁");
	}
	
	
}
