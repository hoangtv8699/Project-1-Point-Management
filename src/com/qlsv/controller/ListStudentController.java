/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.UserDAO;
import com.qlsv.models.BangDiem;
import com.qlsv.models.MonHoc;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hiddenpants-H
 */
public class ListStudentController extends Controller {

    private JTable dSSVjTable;
    private JTextField sTTjTextField;
    private JTextField maSVjTextField;
    private JTextField tenSVjTextField;
    private JTextField diemGKjTextField;
    private JTextField diemCKjTextField;
    private JTextField changeDiemGKjTextField;
    private JTextField changeDiemCKjTextField;
    private JLabel maHPjLabel;
    private JLabel maLopjLabel;
    private JLabel tenHPjLabel;
    private JLabel hocKyjLabel;

    public ListStudentController(JTable dSSVjTable, JTextField sTTjTextField, JTextField maSVjTextField, JTextField tenSVjTextField,
            JTextField diemGKjTextField, JTextField diemCKjTextField, JLabel maHPjLabel, JLabel maLopjLabel, JLabel tenHPjLabel, JLabel hocKyjLabel,
            JTextField changeDiemGKjTextField, JTextField changeDiemCKjTextField) {
        this.dSSVjTable = dSSVjTable;
        this.sTTjTextField = sTTjTextField;
        this.maSVjTextField = maSVjTextField;
        this.tenSVjTextField = tenSVjTextField;
        this.diemGKjTextField = diemGKjTextField;
        this.diemCKjTextField = diemCKjTextField;
        this.changeDiemGKjTextField = changeDiemGKjTextField;
        this.changeDiemCKjTextField = changeDiemCKjTextField;
        this.maHPjLabel = maHPjLabel;
        this.maLopjLabel = maLopjLabel;
        this.tenHPjLabel = tenHPjLabel;
        this.hocKyjLabel = hocKyjLabel;
    }

    public void setTextDSSV(User user, MonHoc monHoc) {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int count = 1;
        model.setRowCount(0);
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        for (SinhVien tmp1 : tmp) {
            BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
            model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            count++;
        }
    }

    public void sTTFilter(User user, MonHoc monHoc) {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (sTTjTextField.getText().equals("") || !sTTjTextField.getText().matches("^[0-9]{0,}$")) {
            setTextDSSV(user, monHoc);
            return;
        }
        Long sTT = Long.valueOf(sTTjTextField.getText());
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            if (count == sTT) {
                BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
                model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            }
            count++;
        }
    }

    public void maSVFilter(User user, MonHoc monHoc) {
        String maSV = maSVjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setTextDSSV(user, monHoc);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            if (String.valueOf(tmp1.getUser_id()).matches("(.*)" + maSV + "(.*)")) {
                BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
                model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            }
            count++;
        }
    }

    public void tenHPFilter(User user, MonHoc monHoc) {
        String tenHP = tenSVjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setTextDSSV(user, monHoc);
            return;
        }
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            if (tmp1.getTen().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
                BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
                model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            }
            count++;
        }
    }

    public void diemCKFilter(User user, MonHoc monHoc) {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (diemCKjTextField.getText().equals("") || !diemCKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextDSSV(user, monHoc);
            return;
        }
        float diemCK = Float.parseFloat(diemCKjTextField.getText());
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
            if (bangDiem.getDiemCK() == diemCK) {
                model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            }
            count++;
        }
    }

    public void diemGKFilter(User user, MonHoc monHoc) {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (diemGKjTextField.getText().equals("") || !diemGKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextDSSV(user, monHoc);
            return;
        }
        float diemGK = Float.parseFloat(diemGKjTextField.getText());
        List<SinhVien> tmp = new UserDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy());
        int count = 1;
        for (SinhVien tmp1 : tmp) {
            BangDiem bangDiem = new BangDiemDAO().find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), tmp1.getUser_id());
            if (bangDiem.getDiemQT() == diemGK) {
                model.addRow(new Object[]{count, tmp1.getUser_id(), tmp1.getTen(), bangDiem.getDiemQT(), bangDiem.getDiemCK()});
            }
            count++;
        }
    }

    public void setNULL() {
        sTTjTextField.setText("");
        maSVjTextField.setText("");
        tenSVjTextField.setText("");
        diemGKjTextField.setText("");
        diemCKjTextField.setText("");
    }

    public void setLabel(MonHoc monhoc) {
        tenHPjLabel.setText("Tên học phần: " + monhoc.getTenHP());
        maHPjLabel.setText("Mã học phần: " + monhoc.getMaHP());
        maLopjLabel.setText("Mã lớp: " + monhoc.getMaLop());
        hocKyjLabel.setText("Học kỳ: " + monhoc.getHocKy());
    }

    public void setTextSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int selected = dSSVjTable.getSelectedRow();
        if (selected >= 0) {
            changeDiemGKjTextField.setText(model.getValueAt(selected, 3).toString());
            changeDiemCKjTextField.setText(model.getValueAt(selected, 4).toString());
        }
    }

    public void updateDiem(MonHoc monHoc) {
        BangDiem bangDiem = new BangDiem();
        bangDiem.setHocKy(monHoc.getHocKy());
        bangDiem.setMaHP(monHoc.getMaHP());
        bangDiem.setMaLop(monHoc.getMaLop());
        SinhVien sinhVien = new SinhVien();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int selected = dSSVjTable.getSelectedRow();
        if (selected >= 0) {
            sinhVien.setUser_id(Long.valueOf(model.getValueAt(selected, 1).toString()));
            if (!(changeDiemGKjTextField.getText().equals("") || !changeDiemGKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")
                    && changeDiemCKjTextField.getText().equals("") || !changeDiemCKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+"))) {
                bangDiem.setDiemQT(Float.parseFloat(changeDiemGKjTextField.getText()));
                bangDiem.setDiemCK(Float.parseFloat(changeDiemCKjTextField.getText()));
                bangDiem.setDiem();
                System.out.println(bangDiem.getDiemQT() + " " + bangDiem.getDiemCK());
                new BangDiemDAO().update(bangDiem, sinhVien.getUser_id());
                JOptionPane.showMessageDialog(new JFrame(), "Cập nhật điểm thành công");
            }

        }

    }
}