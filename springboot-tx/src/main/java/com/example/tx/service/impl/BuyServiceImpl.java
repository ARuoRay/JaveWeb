package com.example.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.tx.exception.InsufficientAmount;
import com.example.tx.service.BookService;
import com.example.tx.service.BuyService;



@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BookService bookService;

	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor= {InsufficientAmount.class}
			)
	@Override
	public void buyOneBook(String username, Integer bookId)throws InsufficientAmount {
		
		System.out.println(username+"要買書");
		
		Integer bookPrice=bookService.getBookPrice(bookId);
		System.out.print("bookId price:"+bookPrice);
		
		bookService.reduceBookAmount(bookId, 1);
		
		bookService.reduceWalletBalance(username, bookPrice);
		
		System.out.println(username+"多了一份知識，少了一份憂愁");
	}
	
	
}
