/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.UserDAO;
import com.qlsv.models.Admin;
import com.qlsv.models.BangDiem;
import com.qlsv.models.GiangVien;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hiddenpants-H
 */
public class ManageUserController extends Controller{

    private JTable jTable;
    private JTextField IDjTextField;
    private JTextField TenjTextField;
    private JTextField NgaySinhjTextField;
    private JTextField SDTjTextField;
    private JTextField EmailjTextField;
    private JTextField DiaChijTextField;
    private JTextField GioiTinhjTextField;
    private JTextField dactrungjTextField;

    public ManageUserController(JTable jTable, JTextField IDjTextField, JTextField TenjTextField, JTextField NgaySinhjTextField, JTextField SDTjTextField, JTextField EmailjTextField, JTextField DiaChijTextField, JTextField GioiTinhjTextField, JTextField dactrungjTextField, User user) {
        super(user);
        this.jTable = jTable;
        this.IDjTextField = IDjTextField;
        this.TenjTextField = TenjTextField;
        this.NgaySinhjTextField = NgaySinhjTextField;
        this.SDTjTextField = SDTjTextField;
        this.EmailjTextField = EmailjTextField;
        this.DiaChijTextField = DiaChijTextField;
        this.GioiTinhjTextField = GioiTinhjTextField;
        this.dactrungjTextField = dactrungjTextField;
    }

    public ManageUserController(JTable jTable, JTextField IDjTextField, JTextField TenjTextField, JTextField NgaySinhjTextField, JTextField SDTjTextField, JTextField EmailjTextField, JTextField DiaChijTextField, JTextField GioiTinhjTextField, User user) {
        super(user);
        this.jTable = jTable;
        this.IDjTextField = IDjTextField;
        this.TenjTextField = TenjTextField;
        this.NgaySinhjTextField = NgaySinhjTextField;
        this.SDTjTextField = SDTjTextField;
        this.EmailjTextField = EmailjTextField;
        this.DiaChijTextField = DiaChijTextField;
        this.GioiTinhjTextField = GioiTinhjTextField;
    }

    
    public String gT(int i){
        if(i == 1){
            return "Nam";
        }else if (i == 0) {
            return "Nữ";
        }
        return null;
    }
    
    public void setText(SinhVien sv) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
        }
    }
    public void setText(GiangVien sv) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
        }
    } 
    public void setText(Admin sv) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        List<Admin> tmp = new UserDAO().find(sv);
        for (Admin tmp1 : tmp) {
            model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
        }
    } 

    public void iDFilter(SinhVien user) {
        String maSV = IDjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(user);
        for (SinhVien tmp1 : tmp) {
            if (String.valueOf(tmp1.getUser_id()).matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void iDFilter(GiangVien user) {
        String maSV = IDjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(user);
        for (GiangVien tmp1 : tmp) {
            if (String.valueOf(tmp1.getUser_id()).matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void iDFilter(Admin user) {
        String maSV = IDjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<Admin> tmp = new UserDAO().find(user);
        for (Admin tmp1 : tmp) {
            if (String.valueOf(tmp1.getUser_id()).matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    
    public void tenFilter(SinhVien sv) {
        String tenHP = TenjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getTen().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void tenFilter(Admin sv) {
        String tenHP = TenjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<Admin> tmp = new UserDAO().find(sv);
        int count = 1;
        for (Admin tmp1 : tmp) {
            if (tmp1.getTen().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    public void tenFilter(GiangVien sv) {
        String tenHP = TenjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        int count = 1;
        for (GiangVien tmp1 : tmp) {
            if (tmp1.getTen().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void sDTFilter(SinhVien user) {
        String maSV = SDTjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(user);
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getSdt().matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void sDTFilter(GiangVien user) {
        String maSV = SDTjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(user);
        for (GiangVien tmp1 : tmp) {
            if (tmp1.getSdt().matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void sDTFilter(Admin user) {
        String maSV = SDTjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setText(user);
            return;
        }
        List<Admin> tmp = new UserDAO().find(user);
        for (Admin tmp1 : tmp) {
            if (tmp1.getSdt().matches("(.*)" + maSV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    public void emailFilter(SinhVien sv) {
        String tenHP = EmailjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getEmail().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void emailFilter(GiangVien sv) {
        String tenHP = EmailjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            if (tmp1.getEmail().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void emailFilter(Admin sv) {
        String tenHP = EmailjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<Admin> tmp = new UserDAO().find(sv);
        for (Admin tmp1 : tmp) {
            if (tmp1.getEmail().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    public void diaChiFilter(SinhVien sv) {
        String tenHP = DiaChijTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getDiaChi().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void diaChiFilter(GiangVien sv) {
        String tenHP = DiaChijTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            if (tmp1.getDiaChi().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void diaChiFilter(Admin sv) {
        String tenHP = DiaChijTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<Admin> tmp = new UserDAO().find(sv);
        for (Admin tmp1 : tmp) {
            if (tmp1.getDiaChi().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    public void gioiTinhFilter(SinhVien sv) {
        String tenHP = GioiTinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            String gt = gT(tmp1.getGt());
            if (gt.toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void gioiTinhFilter(GiangVien sv) {
        String tenHP = GioiTinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            String gt = gT(tmp1.getGt());
            if (gt.toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void gioiTinhFilter(Admin sv) {
        String tenHP = GioiTinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<Admin> tmp = new UserDAO().find(sv);
        for (Admin tmp1 : tmp) {
            String gt = gT(tmp1.getGt());
            if (gt.toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
    public void dacTrungFilter(SinhVien sv) {
        String tenHP = dactrungjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getChuongTrinh().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void dacTrungFilter(GiangVien sv) {
        String tenHP = dactrungjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("") || !tenHP.matches("^[0-9]{0,}$")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            if (String.valueOf(tmp1.getLevel()).toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    
    public void ngaySinhFilter(SinhVien sv) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tenHP = NgaySinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(sv);
        for (SinhVien tmp1 : tmp) {
            if (sdf.format(tmp1.getNgaySinh()).matches("(.*)" + tenHP + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getChuongTrinh()});
            }
        }
    }
    public void ngaySinhFilter(GiangVien sv) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tenHP = NgaySinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<GiangVien> tmp = new UserDAO().find(sv);
        for (GiangVien tmp1 : tmp) {
            if (sdf.format(tmp1.getNgaySinh()).matches("(.*)" + tenHP + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt()), tmp1.getLevel()});
            }
        }
    }
    public void ngaySinhFilter(Admin sv) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tenHP = NgaySinhjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setText(sv);
            return;
        }
        List<Admin> tmp = new UserDAO().find(sv);
        for (Admin tmp1 : tmp) {
            if (sdf.format(tmp1.getNgaySinh()).matches("(.*)" + tenHP + "(.*)")) {
               model.addRow(new Object[]{tmp1.getUser_id(), tmp1.getTen(), tmp1.getNgaySinh(), tmp1.getSdt(), tmp1.getEmail(), tmp1.getDiaChi(), gT(tmp1.getGt())});
            }
        }
    }
}
