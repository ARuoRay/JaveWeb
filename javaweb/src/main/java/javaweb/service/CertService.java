package javaweb.service;

import javaweb.exception.CertException;
import javaweb.exception.PasswordInvalidException;
import javaweb.exception.UserNotFoundException;
import javaweb.model.dto.UserCert;
import javaweb.model.entity.User;
import javaweb.repository.UserDao;
import javaweb.repository.UserDaoImpl;
import javaweb.utils.Hash;

public class CertService {
	private UserDao userDao =new UserDaoImpl();
	
	public UserCert getCert(String username,String password) throws CertException {
		//1.查詢
		User user=userDao.getUser(username);
		if(user==null) {
			throw new UserNotFoundException("查無此人");
		}
		//2.比對
		String passwoHash=Hash.getHash(password, user.getSalt());
		if(!passwoHash.equals(user.getPasswordHash())) {
			throw new PasswordInvalidException("密碼錯誤");
		}
		//3.簽發
		UserCert userCert=new UserCert(user.getUserId(), user.getUsername(), user.getRole());
		return userCert;
	}
}
