package com.example.tx.service;

import com.example.tx.exception.InsufficientAmount;

public interface BookService {
	
	
	Integer getBookPrice(Integer bookId);
	
	Integer getBookAmount(Integer bookId);
	
	Integer getWalletBalance(String username);
	
	void reduceBookAmount(Integer bookId,Integer amountToReduce);
	
	void reduceWalletBalance  (String username,Integer bookPrice)throws InsufficientAmount ;
}
