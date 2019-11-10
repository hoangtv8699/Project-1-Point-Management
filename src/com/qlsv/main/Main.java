package com.qlsv.main;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.SinhVien;
import com.qlsv.models.User;
import com.qlsv.view.MainJFrame;
import com.qlsv.view.SVJPanel;

public class Main {

    public static void main(String[] args) {
        try {
            User user = new SinhVien();
            user.setUser_id(6);
            user.setPassword("12345");
            user = new UserDAO().findByUsernameAndPassword(user);
            System.out.println(user.getTen());
//            MainJFrame frame = new MainJFrame(new SVJPanel(), new UserDAO().findByUsernameAndPassword(user));
//            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
