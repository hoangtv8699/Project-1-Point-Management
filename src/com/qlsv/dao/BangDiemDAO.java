package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.BangDiemMapper;
import com.qlsv.models.*;

public class BangDiemDAO extends CommonDAO<BangDiem> {
	public void insert(BangDiem bd, String id) {
		String sql = "insert into bang_diem(user_id, maHP, maLop) value(?,?,?)";
		insert(sql, id, bd.getMaHP(), bd.getMaLop());
	}
	public void update(BangDiem bd, String id) {
		String sql = "update bang_diem set diemQT=?, diemCK=?, diem=? where user_id=? and maHP=? and maLop=?";
		update(sql, bd.getDiemQT(), bd.getDiemCK(), bd.getDiem(), id, bd.getMaHP(), bd.getMaLop());
	}
	
	public void delete(BangDiem bd, String id) {
		String sql = "delete from bang_diem where user_id=? and maHP=? and maLop=?";
		delete(sql, id, bd.getMaHP(), bd.getMaLop());
	}
	
	public List<BangDiem> findAll() {
		String sql = "select * from bang_diem";
		List<BangDiem> mhs = query(sql, new BangDiemMapper());
		return mhs;
	}
	
	public List<BangDiem> find(String user_id) {
		String sql = "select * from bang_diem where user_id=?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), user_id);
		return mhs;
	}
	
	public List<BangDiem> findLikeMaHP(BangDiem mh) {
		String sql = "select * from bang_diem where maHP like ?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), "%" + mh.getMaHP() + "%");
		return mhs;
	}
	
	public List<BangDiem> findLikeMaLop(MonHoc mh) {
		String sql = "select * from bang_diem where maLop like ?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), "%" + mh.getMaLop() + "%");
		return mhs;
	}
}
