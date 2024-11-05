package javaweb.service;

import java.util.ArrayList;
import java.util.List;

import javaweb.exception.PasswordInvalidException;
import javaweb.exception.UserNotFoundException;
import javaweb.model.dto.UserDto;
import javaweb.model.entity.User;
import javaweb.repository.UserDao;
import javaweb.repository.UserDaoImpl;
import javaweb.utils.Hash;

public class UserService {
	
	private UserDao userDao=new UserDaoImpl(); 
	
	//所有使用者
	public List<UserDto> findAll(){
		List<UserDto> userDtos=new ArrayList<>();
		
		List<User>users=userDao.findAllUsers();
		
		for(User user:users) {
			UserDto userDto=new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUsername(user.getUsername());
			userDto.setEmail(user.getEmail());
			userDto.setActive(user.getActive());
			userDto.setRole(user.getRole());
			
			userDtos.add(userDto);
		}
		
		return userDtos;
}
	//新增使用者
	public void appendUser(String username,String password,String email,String role) {
		String salt=Hash.getSalt();
		String passwordHash=Hash.getHash(password,salt);
		Boolean action=false;
		
		User user=new User();
		user.setUsername(username);
		user.setPasswordHash(passwordHash);
		user.setSalt(salt);
		user.setActive(action);
		user.setRole(role);
		
		userDao.addUser(user);
	}
	
	//刪除使用者
	public void deleateUser(String userId) {
		userDao.deleteUser(Integer.parseInt(userId));
	}
	
	//取得指定使用者
	public UserDto getUser(String username) {
		User user=userDao.getUser(username);
		if(user==null) {
			return null;
		}
		UserDto userDto=new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		userDto.setActive(user.getActive());
		userDto.setRole(user.getRole());
		return userDto;
	}
	//修改使用者
	public void updateUser(String userId,String active,String role) {
		if(!active.isEmpty()) {
			userDao.updateUserActive(Integer.parseInt(userId),Boolean.parseBoolean(active));
		}
		if(!role.isEmpty()) {
			userDao.updateUserRole(Integer.parseInt(userId), role);
		}
	}
	//變更密碼
	public void updatePassword(Integer userId,String username,String oldPassword,String newPassword) throws UserNotFoundException, PasswordInvalidException{
		User user=userDao.getUser(username);
		if(user==null) {
			throw new UserNotFoundException();
		}
		
		//對比password
		String oldPasswordHash=Hash.getHash(oldPassword, user.getSalt());
		
		if(!oldPassword.equals(user.getPasswordHash())) {
			throw new PasswordInvalidException("原密碼輸入錯誤");
		}
		
		//產生新密碼的Hash
		String newPasswordHash=Hash.getHash(newPassword,user.getSalt());
		userDao.updatePasswordHash(userId,newPasswordHash);
	}
}	
