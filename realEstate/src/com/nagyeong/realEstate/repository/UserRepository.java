package com.nagyeong.realEstate.repository;

import java.sql.SQLException;

public interface UserRepository {
	boolean existsById(String id) throws SQLException;
}
