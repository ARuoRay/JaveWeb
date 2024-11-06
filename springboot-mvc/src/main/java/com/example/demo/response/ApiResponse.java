package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//建立Server 與 Client 在傳遞資料上統一結構與標準(含錯誤)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	private int status;
	private String message;
	private T data;
	
	public static <T> ApiResponse<T> success(String message , T data){
		return new ApiResponse<T>(200,message,data);
	}
	public static <T>ApiResponse<T> error(int status,String message){
		return new ApiResponse<T>(status,message,null);
	}
	
}
