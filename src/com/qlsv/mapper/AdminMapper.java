package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.Admin;

public class AdminMapper implements RowMapper<Admin> {
	@Override
	public Admin mapRow(ResultSet result) {
		try {
			Admin a = new Admin();
			a.setUser_id(result.getLong("user_id"));
			a.setTen(result.getString("ten"));
			a.setEmail(result.getString("email"));
			a.setPassword(result.getString("password"));
			a.setNgaySinh(result.getDate("ngaySinh"));
			a.setDiaChi(result.getString("diaChi"));
			a.setSdt(result.getString("sdt"));
			a.setGt(result.getInt("gioiTinh"));
			return a;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return null;
	}
}
