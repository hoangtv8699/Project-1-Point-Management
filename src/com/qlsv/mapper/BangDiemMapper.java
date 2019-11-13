package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.BangDiem;

public class BangDiemMapper implements RowMapper<BangDiem> {

	@Override
	public BangDiem mapRow(ResultSet result) {
		try {
			BangDiem bd = new BangDiem();
                        bd.setHocKy(result.getString("hocky"));
			bd.setMaHP(result.getString("maHP"));
			bd.setMaLop(result.getString("maLop"));
			bd.setDiemQT(result.getFloat("diemQT"));
			bd.setDiemCK(result.getFloat("diemCK"));
			bd.setDiem(result.getFloat("diem"));
			return bd;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		return null;
	}
	
}
