package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.MonHocMapper;
import com.qlsv.models.MonHoc;

public class MonHocDAO extends CommonDAO<MonHoc> {
	public void insert(MonHoc mh) {
		String sql = "insert into mon_hoc(tenHP, maHP, maLop, soTinChi) value(?,?,?,?,?,?)";
		insert(sql, mh.getTenHP(), mh.getMaHP(), mh.getMaLop(), mh.getSoTC());
	}
	
	public void delete(MonHoc mh) {
		String sql = "delete from bang_diem where maHP=? and maLop=?";
		delete(sql,  mh.getMaHP(), mh.getMaLop());
		sql = "delete from mh_gv where maHP=? and maLop=?";
		delete(sql,  mh.getMaHP(), mh.getMaLop());
		sql = "delete from mon_hoc where maHP=? and maLop=?";
		delete(sql,  mh.getMaHP(), mh.getMaLop());
	}
	
	public List<MonHoc> find(int start, int limit) {
		String sql = "select * from mon_hoc limit ?,?";
		List<MonHoc> mh = query(sql, new MonHocMapper(), start, limit);
		return mh;
	}
        
        public List<MonHoc> findName(String maLop, String maHP) {
		String sql = "select * from mon_hoc where maHP=? and maLop=?";
		List<MonHoc> mh = query(sql, new MonHocMapper(), maHP, maLop);
		return mh;
	}
	
	public List<MonHoc> findLikeName(MonHoc mh) {
		String sql = "select * from mon_hoc where tenHP like ?";
		List<MonHoc> mhs = query(sql, new MonHocMapper(), "%" + mh.getTenHP() + "%");
		return mhs;
	}
	
	public List<MonHoc> findLikeMaHP(MonHoc mh) {
		String sql = "select * from mon_hoc where maHP like ?";
		List<MonHoc> mhs = query(sql, new MonHocMapper(), "%" + mh.getMaHP() + "%");
		return mhs;
	}
	
	public List<MonHoc> findLikeMaLop(MonHoc mh) {
		String sql = "select * from mon_hoc where maLop like ?";
		List<MonHoc> mhs = query(sql, new MonHocMapper(), "%" + mh.getMaLop() + "%");
		return mhs;
	}
	
	public long count(){
            String sql = "select count(0) from mon_hoc";
            Long count = count(sql);
            return count;
        }
	
	
}
