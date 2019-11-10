package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.GiangVien;

public class GiangVienMapper implements RowMapper<GiangVien> {
	@Override
	public GiangVien mapRow(ResultSet result) {
		try {
			GiangVien gv = new GiangVien();
			gv.setUser_id(result.getLong("user_id"));
			gv.setTen(result.getString("ten"));
			gv.setEmail(result.getString("email"));
			gv.setPassword(result.getString("password"));
			gv.setNgaySinh(result.getDate("ngaySinh"));
			gv.setDiaChi(result.getString("diaChi"));
			gv.setSdt(result.getString("sdt"));
			gv.setGt(result.getInt("gioiTinh"));
			gv.setLevel(result.getInt("level"));
			return gv;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return null;
	}
}
