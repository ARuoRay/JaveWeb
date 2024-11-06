package com.example.demo.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.bean.Book;
import com.example.demo.response.ApiResponse;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class ApiController {

	/** 
	 * 1.歡迎頁 
	 * 路徑: /welcome
	 * 路徑: /home
	 * 網址: http://localhost:8080/api/welcome
	 * 網址: http://localhost:8080/api/home
	 */
	
	@GetMapping(value = {"/welcome","/home"})
	public String  welocome() {
		return "Welcome";
	}
	
	
	/**
	 * 2. ?帶參數
	 * 路徑: /greet?name=John&age=18
	 * 路徑: /greet?name=Mary
	 * 網址: http://localhost:8080/api/greet?name=John&age=18
	 * 結果: Hi John, 18 (成年)
	 * 網址: http://localhost:8080/api/greet?name=Mary
	 * 結果: Hi Mary, 0 (未成年)
	 * 限制: name 參數一定要加, age 參數可不加(若沒有加 age 參數則會給初始值 0)
	 * */
	@GetMapping("/greet")
	public String greet(@RequestParam (value="name",required=true) String username,
						@RequestParam (value="age",required=false,defaultValue ="0") Integer userage) {
		
		return String.format("HI %s,%d(%s)",username,userage,userage>=18?"成年":"未成年");
	}
	
	@GetMapping("/greet2")
	public String greet2(@RequestParam  String name,
			@RequestParam (defaultValue ="0") Integer age) {

	return String.format("HI %s,%d(%s)",name,age,age>=18?"成年":"未成年");
	}
	
	/**
	 * 4. Lab 練習 I
	 * 路徑: /bmi?h=170&w=60
	 * 網址: http://localhost:8080/api/bmi?h=170&w=60
	 * 執行結果: bmi = 20.76
	 * */
	@GetMapping("/bmi")
	public String bmi(@RequestParam double h,
					@RequestParam double w) {
		return String.format("%.2f",(w/Math.pow(h/100, 2)));
	}
	
	/**
	 * 5. 同名多筆的資料
	 * 路徑: /age?age=17&age=21&age=20
	 * 網址: http://localhost:8080/api/age?age=17&age=21&age=20
	 * 計算出平均年齡
	 */
	
	@GetMapping(value = "/age",produces = "application/json;charset=utf-8")
	public ResponseEntity<ApiResponse<Object>> getAverageOfAge(@RequestParam("age") List<String> ages){
		try {
			double avgOfAge=ages.stream().mapToInt(Integer::parseInt).average().getAsDouble();
			Object data=Map.of("平均年齡",String.format("%.1f",avgOfAge));
			
			return ResponseEntity.ok(ApiResponse.success("查詢成功", data));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), "參數不正確"));
		}
	}
	
	/*
	 * 6. Lab 練習: 得到多筆 score 資料
	 * 路徑: "/exam?score=80&score=100&score=50&score=70&score=30"
	 * 網址: http://localhost:8080/api/exam?score=80&score=100&score=50&score=70&score=30
	 * 請自行設計一個方法，此方法可以
	 * 印出: 最高分=?、最低分=?、平均=?、總分=?、及格分數列出=?、不及格分數列出=?
	 * (支援中文字印出) 
	 * 提示: IntSummaryStatistics, Collectors.partitioningBy
	 * */
	
	
	
	/**
	 * 7. 多筆參數轉 Map
	 * name 書名(String), price 價格(Double), amount 數量(Integer), pub 出刊/停刊(Boolean)
	 * 路徑: /book?name=Math&price=12.5&amount=10&pub=true
	 * 路徑: /book?name=English&price=10.5&amount=20&pub=false
	 * 網址: http://localhost:8080/api/book?name=Math&price=12.5&amount=10&pub=true
	 * 網址: http://localhost:8080/api/book?name=English&price=10.5&amount=20&pub=false
	 * 自動會轉為 Map 集合
	 * */
	
	
	
	/**
	 * 8. 多筆參數轉指定 Bean 物件
	 */
	
	
	
	/**
	 * 9. 路徑參數
	 * 路徑: /book/1
	 * 路徑: /book/3
	 * 網址: http://localhost:8080/api/book/1
	 * 網址: http://localhost:8080/api/book/3
	 */
	@GetMapping("/book/{id}")
	public ResponseEntity<ApiResponse<Book>>getBookById(@PathVariable Integer id) {
		List<Book> books=List.of(
				new Book(1, "Math1", 12.5, 20, true),
				new Book(2, "Math2", 13.5, 21, false),
				new Book(3, "Math3", 14.5, 22, true),
				new Book(4, "Math4", 15.5, 23, false),
				new Book(5, "Math5", 16.5, 24, true)
				);
		Optional<Book>optBook=books.stream().filter(b->b.getId().equals(id)).findAny();
		
		if(optBook.isEmpty()) {
			throw new RuntimeException("查無此書");
		}
		return ResponseEntity.ok(ApiResponse.success("查詢成功",optBook.get()));
	}
	
	
}
