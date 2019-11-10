package com.qlsv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qlsv.models.MH_GV;

public class MH_GVMapper implements RowMapper<MH_GV> {
	@Override
	public MH_GV mapRow(ResultSet result) {
		try {
			MH_GV bd = new MH_GV();
			bd.setUser_id(result.getLong("user_id"));
			bd.setMaHP(result.getString("maHP"));
			bd.setMaLop(result.getString("maLop"));
			return bd;
		}catch (SQLException e) {
			e.printStackTrace();;
		}
		return null;
	}
}
