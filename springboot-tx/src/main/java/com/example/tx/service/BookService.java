package com.example.tx.service;

public interface BookService {
	
	
	Integer getBookPrice(Integer bookId);
	
	Integer getBookAmount(Integer bookId);
	
	Integer getWalletBalance(String username);
	
	void reduceBookAmount(Integer bookId,Integer amountToReduce);
	
	void reduceWalletBalance(String username,Integer bookPrice);
}
