package com.example.test.service;

import com.example.test.exception.CertException;
import com.example.test.exception.PasswordInvalidException;
import com.example.test.exception.UserNotFoundException;
import com.example.test.model.dto.UserCert;
import com.example.test.model.entity.User;
import com.example.test.repository.UserDao;
import com.example.test.repository.UserDaoImpl;
import com.example.test.utils.Hash;

// 憑證服務
public class CertService {
	private UserDao userDao = new UserDaoImpl();
	// 登入成功後可以取得憑證
	public UserCert getCert(String username, String password) throws CertException {
		// 1.是否有此人
		User user = userDao.getUser(username);
		if(user == null) {
			//throw new UserNotFoundException("查無此人");
			throw new UserNotFoundException();
		}
		// 2.比對密碼
		String passwordHash = Hash.getHash(password, user.getSalt());
		if(!passwordHash.equals(user.getPasswordHash())) {
			//throw new PasswordInvalidException("密碼錯誤");
			throw new PasswordInvalidException();
		}
		// 3. 簽發憑證
		UserCert userCert = new UserCert(user.getUserId(), user.getUsername(), user.getRole());
		return userCert;
	}
	
}