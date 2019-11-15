package com.qlsv.main;

import com.qlsv.dao.*;
import com.qlsv.models.*;
import com.qlsv.view.GVJPanel;
import com.qlsv.view.MainJFrame;
import com.qlsv.view.SVJPanel;

public class Main {
    public static User user;
    public static void main(String[] args) {
        try {
            user = new SinhVien();
            user.setUser_id(20000000);
            user.setPassword("12345");
            user = new UserDAO().findByUsernameAndPassword(user);
            MainJFrame frame = new MainJFrame(new SVJPanel(), user);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
