/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.MH_GVDAO;
import com.qlsv.dao.MonHocDAO;
import static com.qlsv.main.Main.user;
import com.qlsv.models.Admin;
import com.qlsv.models.GiangVien;
import com.qlsv.models.MonHoc;
import com.qlsv.models.User;
import com.qlsv.view.ListStudentJPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hiddenpants-H
 */
public class QuanLyLopController extends Controller {

    private JTable dSLopjTable;
    private JTextField hocKyjTextField;
    private JTextField maHPjTextField;
    private JTextField maLopjTextField;
    private JTextField maGVjTextField;
    private JTextField soSVjTextField;
    private JTextField tenHPjTextField;
    private JPanel jPanel1;

    public QuanLyLopController(JTable dSLopjTable, JTextField hocKyjTextField, JTextField maHPjTextField, JTextField maLopjTextField, JTextField maGVjTextField, JTextField soSVjTextField, JTextField tenHPjTextField, JPanel jPanel1, User user) {
        super(user);
        this.dSLopjTable = dSLopjTable;
        this.hocKyjTextField = hocKyjTextField;
        this.maHPjTextField = maHPjTextField;
        this.maLopjTextField = maLopjTextField;
        this.maGVjTextField = maGVjTextField;
        this.soSVjTextField = soSVjTextField;
        this.tenHPjTextField = tenHPjTextField;
        this.jPanel1 = jPanel1;
    }

    public List<MonHoc> getDSL() {
        List<MonHoc> tmp = new MonHocDAO().find(getUser().getUser_id());
        return tmp;
    }
    public List<MonHoc> getDSL(int start, int end) {
        List<MonHoc> tmp = new MonHocDAO().find(start, end);
        return tmp;
    }

    public void setTextDSL() {
        List<MonHoc> tmp = new ArrayList<>();
        if(getUser() instanceof GiangVien){
            tmp = getDSL();
        }else if(getUser() instanceof Admin){
            tmp = getDSL(1, 100);
        }
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        for (MonHoc tmp1 : tmp) {
            model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), new MH_GVDAO().find(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy()).getUser_id(),
                new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
        }
    }

    public void hocKyFilter() {
        String hocKy = hocKyjTextField.getText();

        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (hocKy.equals("")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getHocKy().toLowerCase().matches("(.*)" + hocKy.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void tenHPFilter() {
        String tenHP = tenHPjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getTenHP().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void maHPFilter() {
        String maHP = maHPjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (maHP.equals("")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getMaHP().toLowerCase().matches("(.*)" + maHP.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void maLopFilter() {
        String maLop = maLopjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (maLop.equals("") || !maLop.matches("^[0-9]{0,}$")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getMaLop().matches("(.*)" + maLop + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void maGVFilter() {
        String maGV = maGVjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (maGV.equals("") || !maGV.matches("^[0-9]{0,}$")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            if (String.valueOf(user.getUser_id()).matches("(.*)" + maGV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void soSVFilter() {
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (soSVjTextField.getText().equals("") || !soSVjTextField.getText().matches("^[0-9]{0,}$")) {
            setTextDSL();
            return;
        }
        Long maGV = Long.valueOf(soSVjTextField.getText());
        List<MonHoc> tmp = getDSL();
        for (MonHoc tmp1 : tmp) {
            Long count = new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy());
            if (count == maGV) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), user.getUser_id(), count});
            }
        }
    }

    public void setNULL() {
        hocKyjTextField.setText("");
        maHPjTextField.setText("");
        maLopjTextField.setText("");
        maGVjTextField.setText("");
        soSVjTextField.setText("");
        tenHPjTextField.setText("");
    }

    public void selected() {
        MonHoc monHoc = new MonHoc();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        int selected = dSLopjTable.getSelectedRow();
        if (selected >= 0) {
            monHoc.setHocKy(model.getValueAt(selected, 0).toString());
            monHoc.setTenHP(model.getValueAt(selected, 1).toString());
            monHoc.setMaHP(model.getValueAt(selected, 2).toString());
            monHoc.setMaLop(model.getValueAt(selected, 3).toString());
            jPanel1.removeAll();
            jPanel1.setLayout(new BorderLayout());
            jPanel1.add(new ListStudentJPanel(user, monHoc));
            jPanel1.validate();
            jPanel1.repaint();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn lớp muốn xem chi tiết");
            return;
        }
    }
}
