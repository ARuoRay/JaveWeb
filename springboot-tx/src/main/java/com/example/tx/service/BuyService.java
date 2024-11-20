package com.example.tx.service;

import com.example.tx.exception.InsufficientAmount;

public interface BuyService {
	void buyOneBook(String username,Integer bookId)throws InsufficientAmount;
}
