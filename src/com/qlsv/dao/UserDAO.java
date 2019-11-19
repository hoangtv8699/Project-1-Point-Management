package com.qlsv.dao;

import java.util.List;

import com.qlsv.mapper.AdminMapper;
import com.qlsv.mapper.GiangVienMapper;
import com.qlsv.mapper.SinhVienMapper;
import com.qlsv.models.Admin;
import com.qlsv.models.GiangVien;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;

public class UserDAO extends CommonDAO<User> {

    public long save(User user) {
        long id = -1;
        if (user instanceof SinhVien) {
            String sql = "insert into users(password, ten, email, ngaySinh, diaChi, sdt, gioiTinh, chuongtrinh) value(?,?,?,?,?,?,?,?);";
            id = insert(sql, user.getPassword(), user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt(), ((SinhVien) user).getChuongTrinh());
            user.setUser_id(id);
        } else if (user instanceof GiangVien) {
            String sql = "insert into users(password, ten, email, ngaySinh, diaChi, sdt, gioiTinh, level) value(?,?,?,?,?,?,?,?)";
            id = insert(sql, user.getPassword(), user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt(), ((GiangVien) user).getLevel());
            user.setUser_id(id);
        } else if (user instanceof Admin) {
            String sql = "insert into users(password, ten, email, ngaySinh, diaChi, sdt, gioiTinh) value(?,?,?,?,?,?,?)";
            id = insert(sql, user.getPassword(), user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt());
            user.setUser_id(id);
        }
        saveRole(user);
        return id;
    }

    public long save(String password) {
        long id = -1;
        String sql = "insert into users(password) value(?);";
        id = insert(sql, password);
        return id;

    }

    public void saveRole(User user) {
        String sql = "insert into role(user_id, roles) value(?,?)";
        if (user instanceof SinhVien) {
            insert(sql, user.getUser_id(), 1);
        } else if (user instanceof GiangVien) {
            insert(sql, user.getUser_id(), 2);
        } else if (user instanceof Admin) {
            insert(sql, user.getUser_id(), 0);
        }
    }

    public void update(User user) {
        if (user instanceof SinhVien) {
            String sql = "update users set ten=?, email=?, ngaySinh=?, diaChi=?, sdt=?, gioiTinh=?, chuongtrinh=? where user_id=?";
            update(sql, user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt(), ((SinhVien) user).getChuongTrinh(), user.getUser_id());
        } else if (user instanceof GiangVien) {
            String sql = "update users set ten=?, email=?, ngaySinh=?, diaChi=?, sdt=?, gioiTinh=?, level=? where user_id=?";
            update(sql, user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt(), ((GiangVien) user).getLevel(), user.getUser_id());
        } else if (user instanceof Admin) {
            String sql = "update users set ten=?, email=?, ngaySinh=?, diaChi=?, sdt=?, gioiTinh=? where user_id=?";
            update(sql, user.getTen(), user.getEmail(), user.getNgaySinh(), user.getDiaChi(),
                    user.getSdt(), user.getGt(), user.getUser_id());
        }
    }

    public void updatePassword(User user) {
        String sql = "update users set password=? where user_id=?";
        update(sql, user.getPassword(), user.getUser_id());

    }

    public User findByUsernameAndPassword(User user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id  where users.user_id=? and password=? and roles=?";
        if (user instanceof SinhVien) {
            List<SinhVien> users = query(sql, new SinhVienMapper(), user.getUser_id(), user.getPassword(), 1);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } else if (user instanceof GiangVien) {
            List<GiangVien> users = query(sql, new GiangVienMapper(), user.getUser_id(), user.getPassword(), 2);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } else if (user instanceof Admin) {
            List<Admin> users = query(sql, new AdminMapper(), user.getUser_id(), user.getPassword(), 0);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        }
        return null;
    }

    public User findById(User user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where users.user_id=? and roles=?";
        if (user instanceof SinhVien) {
            List<SinhVien> users = query(sql, new SinhVienMapper(), user.getUser_id(), 1);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } else if (user instanceof GiangVien) {
            List<GiangVien> users = query(sql, new GiangVienMapper(), user.getUser_id(), 2);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } else if (user instanceof Admin) {
            List<Admin> users = query(sql, new AdminMapper(), user.getUser_id(), 0);
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        }
        return null;
    }

    public List<SinhVien> find(SinhVien user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where roles=1";
        List<SinhVien> users = query(sql, new SinhVienMapper());
        return users;
    }

    public List<GiangVien> findAll(GiangVien user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where roles=2";
        List<GiangVien> users = query(sql, new GiangVienMapper());
        return users;
    }

    public List<Admin> findAll(Admin user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where roles=3";
        List<Admin> users = query(sql, new AdminMapper());
        return users;
    }

    public List<SinhVien> find(SinhVien u, int start, int limit) {
        String sql = "select * from users limit ?,?";
        List<SinhVien> users = query(sql, new SinhVienMapper(), start, limit);
        return users;
    }

    public List<GiangVien> find(GiangVien u, int start, int limit) {
        String sql = "select * from users limit ?,?";
        List<GiangVien> users = query(sql, new GiangVienMapper(), start, limit);
        return users;
    }

    public List<Admin> find(Admin u, int start, int limit) {
        String sql = "select * from users limit ?,?";
        List<Admin> users = query(sql, new AdminMapper(), start, limit);
        return users;
    }

    public boolean isExist(String username) {
        String sql = "select count(1) from users where ten=? limit 1";
        long count = count(sql, username);
        if (count > 0) {
            return true;
        }
        return false;
    }

    public List<SinhVien> findLikeUsername(SinhVien user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where username like ? and roles=1";
        List<SinhVien> users = query(sql, new SinhVienMapper(), "%" + user.getTen() + "%");
        return users;
    }

    public List<GiangVien> findLikeUsername(GiangVien user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where username like ? and roles=2";
        List<GiangVien> users = query(sql, new GiangVienMapper(), "%" + user.getTen() + "%");
        return users;
    }

    public List<Admin> findLikeUsername(Admin user) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where username like ? and roles=3";
        List<Admin> users = query(sql, new AdminMapper(), "%" + user.getTen() + "%");
        return users;
    }

    public List<SinhVien> find(String maHP, String maLop, String hocky) {
        String sql = "select users.* from users inner join bang_diem on bang_diem.user_id = users.user_id where maHP=? and maLop=? and hocky=?";
        List<SinhVien> users = query(sql, new SinhVienMapper(), maHP, maLop, hocky);
        return users;
    }

    public void delete(User u) {
        String sql = "delete from role where user_id=?";
        delete(sql, u.getUser_id());
        sql = "delete from mh_gv where user_id=?";
        delete(sql, u.getUser_id());
        sql = "delete from bang_diem where user_id=?";
        delete(sql, u.getUser_id());
        sql = "delete from users where user_id=?";
        delete(sql, u.getUser_id());
    }

    public long count(int i) {
        if (i < 0 || i > 2) {
            return 0;
        }
        String sql = "select count(0) from users inner join role on users.user_id = role.user_id where roles = ?;";
        long count = count(sql, i);
        return count;
    }

    public SinhVien findSV(Long id) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where roles=1 and users.user_id=?";
        List<SinhVien> users = query(sql, new SinhVienMapper(), id);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }public GiangVien findGV(Long id) {
        String sql = "select * from users inner join role on users.user_id = role.user_id where roles=2 and users.user_id=?";
        List<GiangVien> users = query(sql, new GiangVienMapper(), id);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }
}
