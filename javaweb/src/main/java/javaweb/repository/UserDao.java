package javaweb.repository;

import java.util.List;
import javaweb.model.entity.User;
public interface UserDao {
	
	List<User>findAllUsers();
	
	User getUser(String username);
	
	void addUser(User user);
	
	void updateUserRole(Integer userId,String role);
	
	void deleteUser(Integer userID);

	void updateUserActive(Integer userId, Boolean active);
	
	void updatePasswordHash(Integer userId,String newPasswordHash);
	

}
