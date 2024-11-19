package com.example.tx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository {

	@Query(value = "select balance from wallet where username=:username",nativeQuery = true)
	Integer getWalletBalance(String username);
	
	@Query(value = "update wallet set balance=balance-:bookPrice where username=:username",nativeQuery = true)
	void updateWalletBalance(Integer bookPrice,String username);
}
