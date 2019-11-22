/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.Admin;
import com.qlsv.models.GiangVien;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;
import com.qlsv.view.AdminJPanel;
import com.qlsv.view.GVJPanel;
import com.qlsv.view.MainJFrame;
import com.qlsv.view.SVJPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Hiddenpants-H
 */
public class LoginController extends Controller {

    private JRadioButton adminjRadioButton;
    private JButton dangNhapjButton;
    private JRadioButton gVjRadioButton;
    private JPasswordField passwordjPasswordField;
    private JRadioButton sVjRadioButton;
    private JTextField usernamejTextField;

    public LoginController(JRadioButton adminjRadioButton, JButton dangNhapjButton, JRadioButton gVjRadioButton, JPasswordField passwordjPasswordField, JRadioButton sVjRadioButton, JTextField usernamejTextField, User user) {
        super();
        this.adminjRadioButton = adminjRadioButton;
        this.dangNhapjButton = dangNhapjButton;
        this.gVjRadioButton = gVjRadioButton;
        this.passwordjPasswordField = passwordjPasswordField;
        this.sVjRadioButton = sVjRadioButton;
        this.usernamejTextField = usernamejTextField;
    }

    public boolean login() {
        if (sVjRadioButton.isSelected()) {
            SinhVien user = new SinhVien();
            user.setUser_id(Long.parseLong(usernamejTextField.getText()));
            user.setPassword(passwordjPasswordField.getText());
            user = new UserDAO().findByUsernameAndPassword(user);
            if (user == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Tài khoản hoặc mật khẩu không chính xác");
                return false;
            }
            MainJFrame frame = new MainJFrame(new SVJPanel(), user);
            frame.setVisible(true);
        } else if (gVjRadioButton.isSelected()) {
            GiangVien user = new GiangVien();
            user.setUser_id(Long.parseLong(usernamejTextField.getText()));
            user.setPassword(passwordjPasswordField.getText());
            user = new UserDAO().findByUsernameAndPassword(user);
            if (user == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Tài khoản hoặc mật khẩu không chính xác");
                return false;
            }
            MainJFrame frame = new MainJFrame(new GVJPanel(), user);
            frame.setVisible(true);
        } else if (adminjRadioButton.isSelected()) {
            Admin user = new Admin();
            user.setUser_id(Long.parseLong(usernamejTextField.getText()));
            user.setPassword(passwordjPasswordField.getText());
            user = new UserDAO().findByUsernameAndPassword(user);
            if (user == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Tài khoản hoặc mật khẩu không chính xác");
                return false;
            }
            MainJFrame frame = new MainJFrame(new AdminJPanel(), user);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn dạng tài khoản muốn đăng nhập");
            return false;
        }
        return true;
    }
}
