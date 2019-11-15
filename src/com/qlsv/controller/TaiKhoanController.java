/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import datechooser.beans.DateChooserCombo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hiddenpants-H
 */
public class TaiKhoanController extends Controller{

    private User user;
    private JLabel userIdJLabel;
    private JTextField tenjTextField;
    private JTextField emailjTextField;
    private JDateChooser dateChooser;
    private JTextField diaChijTextField;
    private JTextField sDTjTextField;
    private JLabel dacTrungJLabel;

    public TaiKhoanController() {
    }

    public TaiKhoanController(JLabel userIdJLabel, JTextField tenjTextField, JTextField emailjTextField, JDateChooser dateChooser, JTextField diaChijTextField, JTextField sDTjTextField, JLabel dacTrungJLabel) {
        this.userIdJLabel = userIdJLabel;
        this.tenjTextField = tenjTextField;
        this.emailjTextField = emailjTextField;
        this.dateChooser = dateChooser;
        this.diaChijTextField = diaChijTextField;
        this.sDTjTextField = sDTjTextField;
        this.dacTrungJLabel = dacTrungJLabel;
    }

    public void setData(User user) {
        userIdJLabel.setText("" + user.getUser_id());
        tenjTextField.setText(user.getTen());
        emailjTextField.setText(user.getEmail());
        diaChijTextField.setText(user.getDiaChi());
        dateChooser.setDate(user.getNgaySinh());
        sDTjTextField.setText(user.getSdt());
        if (user instanceof SinhVien) {
            dacTrungJLabel.setText("Chương trình: " + ((SinhVien) user).getChuongTrinh());
        } else if (user instanceof GiangVien) {
            dacTrungJLabel.setText("Level: " + ((GiangVien) user).getLevel());
        } else {
            dacTrungJLabel.setText("");

        }
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
        return user;
    }

    public boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9_.]+@[a-zA-Z.]+?\\.[a-zA-Z]{2,3}$");
    }

    public boolean CheckSDT(String sDT) {
        return sDT.matches("[09|03|07|08|05]+[0-9]{8}");
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
        return true;
    }

    public void saveData(User user) {
        if (checkData()) {
            user = getData();
            new UserDAO().update(user);
            JOptionPane.showMessageDialog(new JFrame(), "cập nhật thông tin thành công");
        }
    }
}
