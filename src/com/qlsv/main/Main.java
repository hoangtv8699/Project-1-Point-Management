package com.qlsv.main;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.Admin;
import com.qlsv.models.User;
import com.qlsv.view.AdminJPanel;
import com.qlsv.view.LoginJFrame;
import com.qlsv.view.MainJFrame;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        try {
            LoginJFrame frame = new LoginJFrame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
