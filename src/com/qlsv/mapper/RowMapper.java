package com.qlsv.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T mapRow(ResultSet result);
}
