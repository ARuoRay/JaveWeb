package com.example.demo.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主鍵
	@Column(name = "user_id")
	private Integer userId; // 使用者ID*/

	@Id
	@Column(name = "username")
	private String username; // 使用者名稱

	@Column(name = "passwordHash")
	private String passwordHash; // 使用者Hash密碼

	@Column(name = "salt")
	private String salt; // 隨機鹽
	
	@Column(name= "nickname")
	private String nickName; //暱稱

	@Column(name = "sex")
	private String sex; // 使用者性別

	@Column(name = "email")
	private String email; // 電子郵件

	/*@Column(name = "role")
	private String role; // 權限

	@Column(name = "active")
	private Boolean active; // 帳號啟動*/
	
	//修改會員資料
	public User(String username,String nickName,String email) {
		this.username=username;
		this.nickName=nickName;
		this.email=email;
	};
	

	//修改會員密碼
	public User(String username,String passwordHash) {
		this.username=username;
		this.passwordHash=passwordHash;
	};
}
