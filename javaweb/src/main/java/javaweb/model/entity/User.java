package javaweb.model.entity;

import lombok.Data;


/*
 * -- 建立user資料表--
 * create table if not exists users(
	INT	user_id int primary key auto_increment comment'使用者ID',
    STR	username varchar(50) not null unique comment'使用者名稱',
    STR	password_hash varchar(255) not null comment'使用者密碼hash',
    STR	salt varchar(255) not null comment'隨機鹽',
    STR	email varchar(255) comment'電子郵件',
    BOO	active boolean default false comment'帳號啟動',
    STR	role varchar(50) not null default'ROLE_USER'comment'角色權限'
);
 * */

@Data

public class User {
	private Integer userId;
	private String username;
	private String passwordHash;
	private String salt;
	private String email;
	private Boolean active;
	private String role;

}
