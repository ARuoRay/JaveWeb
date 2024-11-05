package javaweb.model.dto;

import lombok.Data;
//UserDto 對應 User entity
//Dto的屬性名稱要與Entity物件不同

@Data
public class UserDto {
	private Integer userId;
	private String username;
	private String passwordHash;
	private String salt;
	private String email;
	private Boolean active;
	private String role;
}
