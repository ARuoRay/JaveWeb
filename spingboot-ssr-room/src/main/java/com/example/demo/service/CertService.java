package com.example.demo.service;

import com.example.demo.model.dto.UserCert;
import com.example.demo.exception.CertException;

public interface CertService {
	public UserCert getCert(String username,String password) throws CertException;
}
