package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.SinhVien;

public class SinhVienMapper implements RowMapper<SinhVien> {
	@Override
	public SinhVien mapRow(ResultSet result) {
		try {
			SinhVien sv = new SinhVien();
			sv.setUser_id(result.getLong("user_id"));
			sv.setTen(result.getString("ten"));
			sv.setEmail(result.getString("email"));
			sv.setPassword(result.getString("password"));
			sv.setNgaySinh(new java.sql.Date(result.getDate("ngaySinh").getTime()));
			sv.setDiaChi(result.getString("diaChi"));
			sv.setSdt(result.getString("sdt"));
			sv.setGt(result.getInt("gioiTinh"));
			sv.setChuongTrinh(result.getString("chuongTrinh"));
			return sv;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return null;
	}
}
