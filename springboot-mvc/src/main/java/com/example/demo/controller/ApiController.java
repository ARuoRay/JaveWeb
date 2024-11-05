package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
	
	@GetMapping("/bmi")
	public String bmi(@RequestParam double h,
					@RequestParam double w) {
		return String.format("%.2f",(w/Math.pow(h/100, 2)));
	}
	
	
	
	
}
