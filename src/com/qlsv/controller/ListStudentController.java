/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.bean.Properties;
import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.MonHocDAO;
import com.qlsv.dao.UserDAO;
import com.qlsv.mapper.BangDiemExcelMapper;
import com.qlsv.models.Admin;
import com.qlsv.models.BangDiem;
import com.qlsv.models.MonHoc;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hiddenpants-H
 */
public class ListStudentController extends Controller implements Properties{
    private MonHoc monHoc;
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
    private JButton themSVjButton;

    public ListStudentController(MonHoc monHoc, JTable dSSVjTable, JTextField sTTjTextField, JTextField maSVjTextField, JTextField tenSVjTextField, JTextField diemGKjTextField, JTextField diemCKjTextField, JTextField changeDiemGKjTextField, JTextField changeDiemCKjTextField, JLabel maHPjLabel, JLabel maLopjLabel, JLabel tenHPjLabel, JLabel hocKyjLabel, JButton themSVjButton, User user) {
        super(user);
        this.monHoc = monHoc;
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
        this.themSVjButton = themSVjButton;
    }
    
    public void setView(){
        if(getUser() instanceof Admin){
            themSVjButton.setVisible(true);
            
        }else{
            themSVjButton.setVisible(false);
        }
    }

    public void setTextDSSV() {
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

    public void sTTFilter() {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (sTTjTextField.getText().equals("") || !sTTjTextField.getText().matches("^[0-9]{0,}$")) {
            setTextDSSV();
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

    public void maSVFilter() {
        String maSV = maSVjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (maSV.equals("") || !maSV.matches("^[0-9]{0,}$")) {
            setTextDSSV();
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

    public void tenHPFilter() {
        String tenHP = tenSVjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setTextDSSV();
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

    public void diemCKFilter() {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (diemCKjTextField.getText().equals("") || !diemCKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextDSSV();
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

    public void diemGKFilter() {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        model.setRowCount(0);
        if (diemGKjTextField.getText().equals("") || !diemGKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextDSSV();
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

    public void setLabel() {
        tenHPjLabel.setText("Tên học phần: " + monHoc.getTenHP());
        maHPjLabel.setText("Mã học phần: " + monHoc.getMaHP());
        maLopjLabel.setText("Mã lớp: " + monHoc.getMaLop());
        hocKyjLabel.setText("Học kỳ: " + monHoc.getHocKy());
    }

    public void setTextSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int selected = dSSVjTable.getSelectedRow();
        if (selected >= 0) {
            changeDiemGKjTextField.setText(model.getValueAt(selected, 3).toString());
            changeDiemCKjTextField.setText(model.getValueAt(selected, 4).toString());
        }
    }

    public void updateDiem() {
        BangDiem bangDiem = new BangDiem();
        bangDiem.setHocKy(monHoc.getHocKy());
        bangDiem.setMaHP(monHoc.getMaHP());
        bangDiem.setMaLop(monHoc.getMaLop());
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int selected = dSSVjTable.getSelectedRow();
        if (selected >= 0) {
            bangDiem.setUser_id(Long.valueOf(model.getValueAt(selected, 1).toString()));
            if (!(changeDiemGKjTextField.getText().equals("") || !changeDiemGKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")
                    && changeDiemCKjTextField.getText().equals("") || !changeDiemCKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+"))) {
                bangDiem.setDiemQT(Float.parseFloat(changeDiemGKjTextField.getText()));
                bangDiem.setDiemCK(Float.parseFloat(changeDiemCKjTextField.getText()));
                float trongSo = new MonHocDAO().find(bangDiem.getMaLop(), bangDiem.getMaHP(), bangDiem.getHocKy()).get(0).getqT();
                bangDiem.setDiem(bangDiem.getDiemQT()* trongSo + bangDiem.getDiemCK() * trongSo);
                new BangDiemDAO().update(bangDiem);
                JOptionPane.showMessageDialog(new JFrame(), "Cập nhật điểm thành công");
            }

        }
    }
    public void importSV(){
        File excelFile;
        String path;

        String defaultCurrentDirectoryPath = DEFAULT_FILE_PATH;
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        FileFilter filter = new FileNameExtensionFilter("Files", "xlsx"); //filter to show only that
        excelFileChooser.setAcceptAllFileFilterUsed(false); //to show or not all other files
        excelFileChooser.addChoosableFileFilter(filter);

        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            BangDiemDAO bdDao = new BangDiemDAO();
            UserDAO uDao = new UserDAO();
            excelFile = excelFileChooser.getSelectedFile();
            path = excelFile.getPath();
            List<BangDiem> list = new ReadExcel<BangDiem>().readExcel(path, new BangDiemExcelMapper());
            if(list == null){
                return;
            }
            for (BangDiem m : list) {
                if(uDao.findSV(m.getUser_id()) == null){
                    JOptionPane.showMessageDialog(new JFrame(), "có mã sinh viên không tồn tại");
//                    return;
                }
            }
            for (BangDiem m : list) {
                m.setMaHP(monHoc.getMaHP());
                m.setMaLop(monHoc.getMaLop());
                m.setHocKy(monHoc.getHocKy());
                if(bdDao.find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), m.getUser_id()) == null){
                    bdDao.insertFull(m);
                }
            }
            JOptionPane.showMessageDialog(new JFrame(), "Cập nhật lớp sv thành công!");
            setTextDSSV();
        }
    }
    public void updateSV(){
        File excelFile;
        String path;

        String defaultCurrentDirectoryPath = DEFAULT_FILE_PATH;
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        FileFilter filter = new FileNameExtensionFilter("Files", "xlsx"); //filter to show only that
        excelFileChooser.setAcceptAllFileFilterUsed(false); //to show or not all other files
        excelFileChooser.addChoosableFileFilter(filter);

        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            BangDiemDAO bdDao = new BangDiemDAO();
            UserDAO uDao = new UserDAO();
            excelFile = excelFileChooser.getSelectedFile();
            path = excelFile.getPath();
            List<BangDiem> list = new ReadExcel<BangDiem>().readExcel(path, new BangDiemExcelMapper());
            if(list == null){
                return;
            }
            for (BangDiem m : list) {
                if(uDao.findSV(m.getUser_id()) == null || bdDao.find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), m.getUser_id()) == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "có mã sinh viên không có trong lớp hoặc không tồn tại");
                    return;
                }
            }
            for (BangDiem m : list) {
                m.setMaHP(monHoc.getMaHP());
                m.setMaLop(monHoc.getMaLop());
                m.setHocKy(monHoc.getHocKy());
                float trongSo = new MonHocDAO().find(m.getMaLop(), m.getMaHP(), m.getHocKy()).get(0).getqT();
                m.setDiem(m.getDiemQT()* trongSo + m.getDiemCK() * trongSo);
                if(bdDao.find(monHoc.getMaHP(), monHoc.getMaLop(), monHoc.getHocKy(), m.getUser_id()) != null){
                    bdDao.update(m);
                }
            }
            JOptionPane.showMessageDialog(new JFrame(), "Cập nhật điểm sv thành công!");
            setTextDSSV();
        }
    }
    
    public void deleteSV(){
        BangDiem bangDiem = new BangDiem();
        DefaultTableModel model = (DefaultTableModel) dSSVjTable.getModel();
        int selected = dSSVjTable.getSelectedRow();
        if (selected >= 0) {
            bangDiem.setHocKy(monHoc.getHocKy());
            bangDiem.setMaHP(monHoc.getMaHP());
            bangDiem.setMaLop(monHoc.getMaLop());
            bangDiem.setUser_id(Long.parseLong(model.getValueAt(selected, 1).toString()));
            new BangDiemDAO().delete(bangDiem);
            JOptionPane.showMessageDialog(new JFrame(), "xóa thành công!");
            setTextDSSV();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn sinh viên muốn xóa");
            return;
        }
    }
    public void exportSV(){
        File excelFile;
        String path;

        String defaultCurrentDirectoryPath = DEFAULT_FILE_PATH;
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        FileFilter filter = new FileNameExtensionFilter("Files", "xlsx"); 
        excelFileChooser.setAcceptAllFileFilterUsed(false);
        excelFileChooser.addChoosableFileFilter(filter);
        excelFileChooser.setSelectedFile(new File("Danh sách sinh viên.xlsx"));
        
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            path = excelFileChooser.getSelectedFile().getAbsolutePath();
            new WriteExcel().writeExcel(dSSVjTable, path);
        }
    }
    
}
