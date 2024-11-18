package com.example.demo.repository.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Entity.User;
import com.example.demo.repository.UserJdbc;

@Repository
@PropertySource("classpath:sql.properties")
public class UserJdbcImpl implements UserJdbc{

	private static final Logger logger = LoggerFactory.getLogger(UserJdbcImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${user.sql.findAll}")
	private String findAllSql;
	
	@Value("${user.sql.findByUserName}")
	private String findByUserNameSql;
	
	@Value("${user.sql.saveUser}")
	private String saveUserSql;
	
	@Value("${user.sql.updateUser}")
	private String updateUserSql;
	
	@Value("${user.sql.deleteUser}")
	private String deleteUserSql;
	
	@Value("${user.sql.updatePasswordHash}")
	private String updatePasswordHashSql;
	
	/*@Value("${user.sql.updateRole}")
	private String updateRoleSql;*/
	
	
	@Override
	public List<User> findAllUser() {
		
		return jdbcTemplate.query(findAllSql,new BeanPropertyRowMapper<>(User.class));
	}

	@Override
	public Optional<User> findByUserName(String username) {
		try {
			User user=jdbcTemplate.queryForObject(findByUserNameSql,new BeanPropertyRowMapper<>(User.class),username);
			return Optional.of(user);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return Optional.empty();
	}

	@Override
	public int saveUser(User user) {		
		return jdbcTemplate.update(saveUserSql,user.getUsername(),user.getPasswordHash(),user.getSalt()
								,user.getNickName(),user.getSex(),user.getEmail());
	}

	@Override
	public int updateUser( User user) {		
		return jdbcTemplate.update(updateUserSql,user.getNickName(),user.getEmail(),user.getUsername());
	}

	@Override
	public int deleteUser(String UserName) {
		return jdbcTemplate.update(deleteUserSql,UserName);
	}

	@Override
	public int updatePasswordHash(User user) {
		return jdbcTemplate.update(updatePasswordHashSql,user.getPasswordHash(),user.getUsername());
	}

	/*@Override
	public int updateRole(User user) {
		return jdbcTemplate.update(updateRoleSql,user.getRole(),user.getUserId());
		
	}*/

}
