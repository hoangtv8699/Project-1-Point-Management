/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.MonHocDAO;
import com.qlsv.dao.UserDAO;
import com.qlsv.mapper.MonHocExcelMapper;
import com.qlsv.models.Admin;
import com.qlsv.models.BangDiem;
import com.qlsv.models.GiangVien;
import com.qlsv.models.MonHoc;
import com.qlsv.models.User;
import com.qlsv.view.ListStudentJPanel;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private JTextField tCjTextField;
    private JTextField qTjTextField;
    private JPanel jPanel1;
    private JButton xoaLopjButton;
    private JButton themLopjButton;

    public QuanLyLopController(JTable dSLopjTable, JTextField hocKyjTextField, JTextField maHPjTextField, JTextField maLopjTextField, JTextField maGVjTextField, JTextField soSVjTextField, JTextField tenHPjTextField, JTextField tCjTextField, JTextField qTjTextField, JPanel jPanel1, JButton xoaLopjButton, JButton themLopjButton, User user) {
        super(user);
        this.dSLopjTable = dSLopjTable;
        this.hocKyjTextField = hocKyjTextField;
        this.maHPjTextField = maHPjTextField;
        this.maLopjTextField = maLopjTextField;
        this.maGVjTextField = maGVjTextField;
        this.soSVjTextField = soSVjTextField;
        this.tenHPjTextField = tenHPjTextField;
        this.tCjTextField = tCjTextField;
        this.qTjTextField = qTjTextField;
        this.jPanel1 = jPanel1;
        this.xoaLopjButton = xoaLopjButton;
        this.themLopjButton = themLopjButton;
    }

    public void setView() {
        User user = getUser();
        if (user instanceof Admin) {
            xoaLopjButton.setVisible(true);
            themLopjButton.setVisible(true);
        } else if (user instanceof GiangVien) {
            xoaLopjButton.setVisible(false);
            themLopjButton.setVisible(false);
        }
    }

    public List<MonHoc> getDSL() {
        List<MonHoc> tmp = new MonHocDAO().find(getUser().getUser_id());
        return tmp;
    }

    public List<MonHoc> getAllDSL() {
        List<MonHoc> tmp = new MonHocDAO().find();
        return tmp;
    }

    public void setTextDSL() {
        List<MonHoc> tmp = new ArrayList<>();
        if (getUser() instanceof GiangVien) {
            tmp = getDSL();
        } else if (getUser() instanceof Admin) {
            tmp = getAllDSL();
        }
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        for (MonHoc tmp1 : tmp) {
            model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getHocKy().toLowerCase().matches("(.*)" + hocKy.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getTenHP().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getMaHP().toLowerCase().matches("(.*)" + maHP.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getMaLop().matches("(.*)" + maLop + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void tcFilter() {
        String tC = tCjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (tC.equals("") || !tC.matches("^[0-9]{0,}$")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getSoTC() == Long.valueOf(tC)) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
                    new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy())});
            }
        }
    }

    public void qTFilter() {
        String qT = qTjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        model.setRowCount(0);
        if (qT.equals("") || !qT.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextDSL();
            return;
        }
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (tmp1.getqT() == Float.parseFloat(qT)) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            if (String.valueOf(tmp1.getUser_id()).matches("(.*)" + maGV + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(),
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
        List<MonHoc> tmp = getAllDSL();
        for (MonHoc tmp1 : tmp) {
            Long count = new BangDiemDAO().count(tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getHocKy());
            if (count == maGV) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getTenHP(), tmp1.getMaHP(), tmp1.getMaLop(), tmp1.getSoTC(), tmp1.getqT(), tmp1.getUser_id(), count});
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
            jPanel1.add(new ListStudentJPanel(getUser(), monHoc));
            jPanel1.validate();
            jPanel1.repaint();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn lớp muốn xem chi tiết");
            return;
        }
    }

    public void addLop() {
        File excelFile;
        String path;

        String defaultCurrentDirectoryPath = "C:\\Users\\Hiddenpants-H\\Downloads";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        FileFilter filter = new FileNameExtensionFilter("Files", "xlsx"); 
        excelFileChooser.setAcceptAllFileFilterUsed(false);
        excelFileChooser.addChoosableFileFilter(filter);

        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            MonHocDAO dao = new MonHocDAO();
            UserDAO udao = new UserDAO();
            excelFile = excelFileChooser.getSelectedFile();
            path = excelFile.getPath();
            List<MonHoc> list = new ReadExcel<MonHoc>().readExcel(path, new MonHocExcelMapper());
            if(list == null){
                return;
            }
            for (MonHoc m : list) {
                if(udao.findGV(m.getUser_id()) == null){
                    JOptionPane.showMessageDialog(new JFrame(), "có mã giảng viên không tồn tại");
                }
            }
            for (MonHoc m : list) {
                if(dao.find(m.getMaLop(), m.getMaHP(), m.getHocKy()).size() == 0){
                    dao.insert(m);
                }
            }
            JOptionPane.showMessageDialog(new JFrame(), "Thêm lớp thành công!");
            setTextDSL();
        }
    }
    public void deleteLop(){
        MonHoc monHoc = new MonHoc();
        DefaultTableModel model = (DefaultTableModel) dSLopjTable.getModel();
        int selected = dSLopjTable.getSelectedRow();
        if (selected >= 0) {
            monHoc.setHocKy(model.getValueAt(selected, 0).toString());
            monHoc.setMaHP(model.getValueAt(selected, 2).toString());
            monHoc.setMaLop(model.getValueAt(selected, 3).toString());
            new MonHocDAO().delete(monHoc);
            setTextDSL();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn lớp muốn xóa");
            return;
        }
    }
}
