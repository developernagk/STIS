package com.nagyeong.realEstate.repository;

import java.sql.SQLException;

public interface EmailAuthenticationRepositiry {
	boolean existByEmail(String email) throws SQLException;
	
	void save(String email, String authenticationCode) throws SQLException;
}
