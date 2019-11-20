/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.models.User;
import com.qlsv.view.ManageAccount;
import com.qlsv.view.ManageAdmin;
import com.qlsv.view.ManageGV;
import com.qlsv.view.ManageSV;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Hiddenpants-H
 */
public class QuanLyNguoiDungController extends Controller {

    private JButton SVjButton;
    private JButton GVjButton;
    private JButton AdjButton;
    private JButton taiKhoanjButton;
    private JPanel jPanel;

    public QuanLyNguoiDungController(JButton SVjButton, JButton GVjButton, JButton AdjButton, JButton taiKhoanjButton, JPanel jPanel, User user) {
        super(user);
        this.SVjButton = SVjButton;
        this.GVjButton = GVjButton;
        this.AdjButton = AdjButton;
        this.taiKhoanjButton = taiKhoanjButton;
        this.jPanel = jPanel;
    }

    public void changeSV() {
        jPanel.removeAll();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new ManageSV(getUser()));
        jPanel.validate();
        jPanel.repaint();
    }
    public void changeGV() {
        jPanel.removeAll();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new ManageGV(getUser()));
        jPanel.validate();
        jPanel.repaint();
    }
    public void changeQLTaiKhoan() {
        jPanel.removeAll();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new ManageAccount(getUser()));
        jPanel.validate();
        jPanel.repaint();
    }
    public void changeAd() {
        jPanel.removeAll();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(new ManageAdmin(getUser()));
        jPanel.validate();
        jPanel.repaint();
    }
}
