package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.BangDiemMapper;
import com.qlsv.models.*;

public class BangDiemDAO extends CommonDAO<BangDiem> {
	public void insert(BangDiem bd, String id) {
		String sql = "insert into bang_diem(user_id, maHP, maLop, hocky) value(?,?,?)";
		insert(sql, id, bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
	}
	public void update(BangDiem bd, String id) {
		String sql = "update bang_diem set diemQT=?, diemCK=?, diem=? where user_id=? and maHP=? and maLop=? and hocky=?";
		update(sql, bd.getDiemQT(), bd.getDiemCK(), bd.getDiem(), id, bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
	}
	
	public void delete(BangDiem bd, String id) {
		String sql = "delete from bang_diem where user_id=? and maHP=? and maLop=? and hocky=?";
		delete(sql, id, bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
	}
	
	public List<BangDiem> findAll() {
		String sql = "select * from bang_diem";
		List<BangDiem> mhs = query(sql, new BangDiemMapper());
		return mhs;
	}
	
	public List<BangDiem> find(Long user_id) {
		String sql = "select * from bang_diem where user_id=?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), user_id);
		return mhs;
	}
	
	public List<BangDiem> findLikeMaHP(BangDiem mh) {
		String sql = "select * from bang_diem where maHP like ?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), "%" + mh.getMaHP() + "%");
		return mhs;
	}
	
	public List<BangDiem> findLikeMaLop(BangDiem mh) {
		String sql = "select * from bang_diem where maLop like ?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(), "%" + mh.getMaLop() + "%");
		return mhs;
	}
        
        public List<BangDiem> findLikeHocky(BangDiem mh) {
		String sql = "select * from bang_diem where hocky=?";
		List<BangDiem> mhs = query(sql, new BangDiemMapper(),mh.getHocKy());
		return mhs;
	}
}
