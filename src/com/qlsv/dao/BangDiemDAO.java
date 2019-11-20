package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.BangDiemMapper;
import com.qlsv.models.*;

public class BangDiemDAO extends CommonDAO<BangDiem> {

    public void insert(BangDiem bd) {
        String sql = "insert into bang_diem(user_id, maHP, maLop, hocky) value(?,?,?)";
        insert(sql, bd.getUser_id(), bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
    }
    public void insertFull(BangDiem bd) {
        String sql = "insert into bang_diem(user_id, maHP, maLop, hocky, diemQT, diemCK) value(?,?,?,?,?,?)";
        insert(sql, bd.getUser_id(), bd.getMaHP(), bd.getMaLop(), bd.getHocKy(), bd.getDiemQT(), bd.getDiemCK());
    }

    public void update(BangDiem bd) {
        String sql = "update bang_diem set diemQT=?, diemCK=?, diem=? where user_id=? and maHP=? and maLop=? and hocky=?";
        update(sql, bd.getDiemQT(), bd.getDiemCK(), bd.getDiem(), bd.getUser_id(), bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
    }

    public void delete(BangDiem bd) {
        String sql = "delete from bang_diem where user_id=? and maHP=? and maLop=? and hocky=?";
        delete(sql, bd.getUser_id(), bd.getMaHP(), bd.getMaLop(), bd.getHocKy());
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
        List<BangDiem> mhs = query(sql, new BangDiemMapper(), mh.getHocKy());
        return mhs;
    }

    public BangDiem find(String maHP, String maLop, String hocky, Long userId) {
        String sql = "select * from bang_diem where maHP=? and maLop=? and hocky=? and user_id=?";
        List<BangDiem> bangDiems = query(sql, new BangDiemMapper(), maHP, maLop, hocky, userId);
        if (bangDiems.isEmpty()) {
            return null;
        }
        return bangDiems.get(0);
    }

    public Long count(String maHP, String maLop, String hocky) {
        String sql = "select count(user_id) from bang_diem where maHP=? and maLop=? and hocky=?";
        Long count = count(sql, maHP, maLop, hocky);
        return count;
    }
}
