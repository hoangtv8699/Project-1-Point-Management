/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.User;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Hiddenpants-H
 */
public class MatkhauController extends Controller{

    private JPasswordField MatKhauCujPasswordField;
    private JPasswordField MatKhauMoijPasswordField;
    private JPasswordField XacNhanjPasswordField;

    public MatkhauController(JPasswordField MatKhauCujPasswordField, JPasswordField MatKhauMoijPasswordField, JPasswordField XacNhanjPasswordField) {
        this.MatKhauCujPasswordField = MatKhauCujPasswordField;
        this.MatKhauMoijPasswordField = MatKhauMoijPasswordField;
        this.XacNhanjPasswordField = XacNhanjPasswordField;
    }

    public void doiMatKhau(User user) {
        if (!new String(MatKhauCujPasswordField.getPassword()).equals(user.getPassword())) {
            JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không chính xác");
            return;
        }
        if (!new String(MatKhauMoijPasswordField.getPassword()).matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")) {
            JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu mới không đảm bảo yêu cầu bảo mật");
            return;
        }
        if (!new String(MatKhauMoijPasswordField.getPassword()).equals(new String(XacNhanjPasswordField.getPassword()))) {
            JOptionPane.showMessageDialog(new JFrame(), "Xác nhận mật khẩu không chính xác");
            return;
        }
        user.setPassword(new String(MatKhauMoijPasswordField.getPassword()));
        new UserDAO().update(user);
        JOptionPane.showMessageDialog(new JFrame(), "Cập nhật mật khẩu thành công");
    }

}
