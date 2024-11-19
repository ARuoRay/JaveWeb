package com.example.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tx.entity.BookInventory;

@Repository
public interface BookInventoryRepository extends JpaRepository<BookInventory, Integer> {
	
	//取得書本總庫存
	@Query(value = "select book_amout from book_inventory where book_id=:bookId",nativeQuery = true)
	Integer getBookAmout(Integer bookId);
	
	//更新庫存
	@Query(value = "update book_inventory set book_amout=book_amout -:amoutToReduce where book_id=:bookId",nativeQuery = true)
	void updateBookAmout(Integer amoutToReduce,Integer bookId);

}
