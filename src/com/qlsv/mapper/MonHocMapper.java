package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.MonHoc;
// không dùng
public class MonHocMapper implements RowMapper<MonHoc> {
	@Override
	public MonHoc mapRow(ResultSet result) {
		try {
			MonHoc mh = new MonHoc();
			mh.setTenHP(result.getString("tenHP"));
			mh.setMaHP(result.getString("maHP"));
			mh.setMaLop(result.getString("maLop"));
			mh.setSoTC(result.getInt("soTinChi"));
			return mh;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return null;
	}
}
