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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Hiddenpants-H
 */
public class ManageAccountController extends Controller {

    private JRadioButton sVjRadioButton;
    private JRadioButton gVjRadioButton;
    private JRadioButton adminjRadioButton;
    private JButton themTkjButton;
    private JButton deletejButton;
    private JButton resetjButton;
    private JTextField usernamejTextField;
    private JTextField passwordjTextField;
    private JTextField iDjTextField;
    private JTextField dacTrungjTextField;
    private JLabel dacTrungjLabel;

    public ManageAccountController(JRadioButton sVjRadioButton, JRadioButton gVjRadioButton, JRadioButton adminjRadioButton, JButton themTkjButton, JButton deletejButton, JButton resetjButton, JTextField usernamejTextField, JTextField passwordjTextField, JTextField iDjTextField, JTextField dacTrungjTextField, JLabel dacTrungjLabel, User user) {
        super(user);
        this.sVjRadioButton = sVjRadioButton;
        this.gVjRadioButton = gVjRadioButton;
        this.adminjRadioButton = adminjRadioButton;
        this.themTkjButton = themTkjButton;
        this.deletejButton = deletejButton;
        this.resetjButton = resetjButton;
        this.usernamejTextField = usernamejTextField;
        this.passwordjTextField = passwordjTextField;
        this.iDjTextField = iDjTextField;
        this.dacTrungjTextField = dacTrungjTextField;
        this.dacTrungjLabel = dacTrungjLabel;
    }

    public void setVisable(boolean b) {
        dacTrungjLabel.setVisible(b);
        dacTrungjTextField.setVisible(b);
    }

    public void setView() {
        if (sVjRadioButton.isSelected()) {
            dacTrungjLabel.setText("Chương trình");
        } else if (gVjRadioButton.isSelected()) {
            dacTrungjLabel.setText("Level");
        }

    }

    public void addAccount() {
        User user;
        if (sVjRadioButton.isSelected()) {
            user = new SinhVien();
            String dacTrung = dacTrungjTextField.getText();
            if (dacTrung.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập chương trình");
                return;
            }
            ((SinhVien) user).setChuongTrinh(dacTrung);
            user.setPassword("12345");
            user.setUser_id(new UserDAO().save((SinhVien) user));
        } else if (gVjRadioButton.isSelected()) {
            user = new GiangVien();
            String dacTrung = dacTrungjTextField.getText();
            if (dacTrung.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập Level");
                return;
            } else if (!dacTrung.matches("^[0-9]{0,}$")) {
                JOptionPane.showMessageDialog(new JFrame(), "Level bạn nhập không phải là số");
                return;
            } else if (Long.parseLong(dacTrung) <= 0 || Long.parseLong(dacTrung) > 10) {
                JOptionPane.showMessageDialog(new JFrame(), "Level bạn nhập phải > 0 và < 10");
                return;
            }
            ((GiangVien) user).setLevel(Integer.parseInt(dacTrung));
            user.setPassword("12345");
            user.setUser_id(new UserDAO().save((GiangVien) user));
        } else if (adminjRadioButton.isSelected()) {
            user = new Admin();
            user.setPassword("12345");
            user.setUser_id(new UserDAO().save((Admin) user));
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn loại tài khoản muốn tạo");
            return;
        }
        usernamejTextField.setText("" + user.getUser_id());
        passwordjTextField.setText("" + user.getPassword());
    }

    public void deleteUser() {
        String iD = iDjTextField.getText();
        if (iD == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập ID muốn xóa");
            return;
        } else if (!iD.matches("^[0-9]{0,}$")) {
            JOptionPane.showMessageDialog(new JFrame(), "ID bạn nhập không phải là số");
            return;
        }
        User user = new UserDAO().findById(Long.parseLong(iD));
        if(user == null){
            JOptionPane.showMessageDialog(new JFrame(), "ID bạn nhập không tồn tại");
            return;
        }else{
            new UserDAO().delete(user);
            JOptionPane.showMessageDialog(new JFrame(), "xóa tài khoản thành công");
        }
    }
    
    public void resetPassword(){
        String iD = iDjTextField.getText();
        if (iD == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Bạn phải nhập ID muốn xóa");
            return;
        } else if (!iD.matches("^[0-9]{0,}$")) {
            JOptionPane.showMessageDialog(new JFrame(), "ID bạn nhập không phải là số");
            return;
        }
        User user = new UserDAO().findById(Long.parseLong(iD));
        if(user == null){
            JOptionPane.showMessageDialog(new JFrame(), "ID bạn nhập không tồn tại");
            return;
        }else{
            user.setPassword("12345");
            new UserDAO().updatePassword(user);
            JOptionPane.showMessageDialog(new JFrame(), "Reset password thành công, password mặc định là 12345");
        }
    }
}
