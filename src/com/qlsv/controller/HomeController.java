/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.MonHocDAO;
import com.qlsv.dao.UserDAO;
import javax.swing.JLabel;

/**
 *
 * @author Hiddenpants-H
 */
public class HomeController {
    private JLabel count1;
    private JLabel count2;
    private JLabel count3;

    public HomeController(JLabel count1, JLabel count2, JLabel count3) {
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
    }
    
    public void setCount(){
        count1.setText("" + new MonHocDAO().count());
        count2.setText("" + new UserDAO().count(1));
        count3.setText("" + new UserDAO().count(2));

    }
}
