package com.qlsv.main;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.Admin;
import com.qlsv.models.User;
import com.qlsv.view.AdminJPanel;
import com.qlsv.view.MainJFrame;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        try {
            User user;
            user = new Admin();
            user.setUser_id(20000014);
            user.setPassword("12345");
            user = new UserDAO().findByUsernameAndPassword(user);
            MainJFrame frame = new MainJFrame(new AdminJPanel(), user);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
