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

import com.example.demo.model.Entity.Message;
import com.example.demo.repository.MessageJdbc;

@Repository("messageJdbc")
@PropertySource("classpath:sql.properties")
public class MessageJdbcImpl implements MessageJdbc {

	private static final Logger logger=LoggerFactory.getLogger(MessageJdbcImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${message.sql.findAll}")
	private String findAllSql;
	
	@Value("${message.sql.save}")
	private String saveSql;

	@Value("${message.sql.findSendUser}")
	private String findSendUser;

	@Value("${message.sql.findReceiveUser}")
	private String findReceiveUser;
	
	@Override
	public List<Message> findMessage() {
		return jdbcTemplate.query(findAllSql,new BeanPropertyRowMapper<>(Message.class));
	}
		
	@Override
	public int addMessage(Message message) {
		return jdbcTemplate.update(saveSql,message.getId(),message.getSendUserId(),message.getReceiveUserId(),message.getMessage(),message.getUpdateTime());
	}

	@Override
	public Optional<Message> findMessageSendById(Integer sendUserId,Integer receiveId) {
		try {
			Message message=jdbcTemplate.queryForObject(findSendUser, new BeanPropertyRowMapper<>(Message.class),sendUserId,receiveId);
			return Optional.of(message);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return Optional.empty();
	}

	@Override
	public Optional<Message> findMessageReceiveById(Integer receiveId,Integer sendUserId) {
		try {
			Message message=jdbcTemplate.queryForObject(findReceiveUser, new BeanPropertyRowMapper<>(Message.class), receiveId,sendUserId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Optional.empty();
	}


}
