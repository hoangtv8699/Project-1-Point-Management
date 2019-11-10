package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.MH_GVMapper;
import com.qlsv.models.MH_GV;

public class MH_GV_DAO extends CommonDAO<MH_GV> {
	public void insert(MH_GV mh) {
		String sql = "insert into mh_gv(user_id, maHP, maLop) value(?,?,?)";
		insert(sql, mh.getUser_id(), mh.getMaHP(), mh.getMaLop());
	}
	
	public void update(MH_GV mh) {
		String sql = "update mh_gv set user_id=? where maHP=? and maLop=?";
		update(sql, mh.getUser_id(), mh.getMaHP(), mh.getMaLop());
	}
	
	public void delete(MH_GV mh) {
		String sql = "delete from mh_gv where user_id=? and maHP=? and maLop=?";
		delete(sql, mh.getUser_id(), mh.getMaHP(), mh.getMaLop());
	}
	
	public List<MH_GV> findAll() {
		String sql = "select * from mh_gv";
		List<MH_GV> mhs = query(sql, new MH_GVMapper());
		return mhs;
	}
	
	public List<MH_GV> findLikeMaHP(MH_GV mh) {
		String sql = "select * from mh_gv where maHP like ?";
		List<MH_GV> mhs = query(sql, new MH_GVMapper(), "%" + mh.getMaHP() + "%");
		return mhs;
	}
	
	public List<MH_GV> findLikeMaLop(MH_GV mh) {
		String sql = "select * from mh_gv where maLop like ?";
		List<MH_GV> mhs = query(sql, new MH_GVMapper(), "%" + mh.getMaLop() + "%");
		return mhs;
	}
}
