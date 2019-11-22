/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import datechooser.beans.DateChooserCombo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hiddenpants-H
 */
public class TaiKhoanController extends Controller {
    private JLabel userIdJLabel;
    private JTextField tenjTextField;
    private JTextField emailjTextField;
    private JDateChooser dateChooser;
    private JTextField diaChijTextField;
    private JTextField sDTjTextField;
    private JLabel dacTrungJLabel;
    private JComboBox<String> sexjComboBox;

    public TaiKhoanController(JLabel userIdJLabel, JTextField tenjTextField, JTextField emailjTextField, JDateChooser dateChooser, JTextField diaChijTextField, JTextField sDTjTextField, JLabel dacTrungJLabel, JComboBox<String> sexjComboBox, User user) {
        super(user);
        this.userIdJLabel = userIdJLabel;
        this.tenjTextField = tenjTextField;
        this.emailjTextField = emailjTextField;
        this.dateChooser = dateChooser;
        this.diaChijTextField = diaChijTextField;
        this.sDTjTextField = sDTjTextField;
        this.dacTrungJLabel = dacTrungJLabel;
        this.sexjComboBox = sexjComboBox;
    }

    public void setData() {
        User u = getUser();
        userIdJLabel.setText("" + u.getUser_id());
        tenjTextField.setText(u.getTen());
        emailjTextField.setText(u.getEmail());
        diaChijTextField.setText(u.getDiaChi());
        dateChooser.setDate(u.getNgaySinh());
        sDTjTextField.setText(u.getSdt());
        if (u instanceof SinhVien) {
            dacTrungJLabel.setText("Chương trình: " + ((SinhVien) u).getChuongTrinh());
        } else if (u instanceof GiangVien) {
            dacTrungJLabel.setText("Level: " + ((GiangVien) u).getLevel());
        } else {
            dacTrungJLabel.setText("");
        }
        sexjComboBox.setSelectedIndex(u.getGt());

    }

    public User getData() {
        String tmp = dacTrungJLabel.getText();
        String dacTrung[] = tmp.split(": ");
        User user;
        switch (dacTrung[0]) {
            case "Chương trình":
                user = new SinhVien();
                ((SinhVien) user).setChuongTrinh(dacTrung[1]);
                break;
            case "Level":
                user = new GiangVien();
                ((GiangVien) user).setLevel(Integer.parseInt(dacTrung[1]));
                break;
            default:
                user = new Admin();
                break;
        }
        
        user.setUser_id(Long.parseLong(userIdJLabel.getText()));
        user.setTen(tenjTextField.getText());
        user.setEmail(emailjTextField.getText());
        user.setNgaySinh(new java.sql.Date(dateChooser.getDate().getTime()));
        user.setDiaChi(diaChijTextField.getText());
        user.setSdt(sDTjTextField.getText());
        user.setGt(sexjComboBox.getSelectedIndex());
        user.setPassword(getUser().getPassword());
        return user;
    }

    public boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9_.]+@[a-zA-Z.]+?\\.[a-zA-Z]{2,3}$");
    }

    public boolean CheckSDT(String sDT) {
        return sDT.matches("[09|03|07|08|05]"+"[0-9]{9}");
    }
    public boolean CheckTen(String Ten) {
        return !Ten.isEmpty();
    }
    public boolean CheckDiaChi(String diaChi) {
        return !diaChi.isEmpty();
    }

    public boolean checkData() {
        if (!checkEmail(emailjTextField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Email bạn nhập không hợp lệ");
            return false;
        }
        if (!CheckSDT(sDTjTextField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Số điện thoại bạn nhập không hợp lệ");
            return false;
        }
        if (!CheckTen(tenjTextField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập tên");
            return false;
        }
        if (!CheckDiaChi(diaChijTextField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập địa chỉ");
            return false;
        }
        return true;
    }

    public void saveData() {
        if (checkData()) {
            User u = getUser();
            u = getData();
            new UserDAO().update(u);
            setUser(u);
            JOptionPane.showMessageDialog(new JFrame(), "cập nhật thông tin thành công");
        }
    }
}
