/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.bean.DanhMucBean;
import com.qlsv.controller.ChangePanelMenuController;
import com.qlsv.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiddenpants-H
 */
public class UserManageJPanel extends CommonJPanel {
    /**
     * Creates new form UserManageJPanel
     */
    public UserManageJPanel(User user) {
        initComponents();
        ChangePanelMenuController controller = new ChangePanelMenuController(ViewjPanel ,user);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("TaiKhoan", TaiKhoanjPanel, TaiKhoanjLabel));
        listItem.add(new DanhMucBean("MatKhau", MatKhaujPanel, MatKhaujLabel));
        
        controller.setPanelEvent(listItem);
        controller.setLabelEvent(listItem);
        controller.setView("TaiKhoan");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenujPanel = new javax.swing.JPanel();
        MatKhaujLabel = new javax.swing.JLabel();
        TaiKhoanjLabel = new javax.swing.JLabel();
        TaiKhoanjPanel = new javax.swing.JPanel();
        MatKhaujPanel = new javax.swing.JPanel();
        ViewjPanel = new javax.swing.JPanel();

        MenujPanel.setBackground(new java.awt.Color(204, 255, 255));

        MatKhaujLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MatKhaujLabel.setForeground(new java.awt.Color(51, 153, 0));
        MatKhaujLabel.setText("Mật khẩu");

        TaiKhoanjLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TaiKhoanjLabel.setForeground(new java.awt.Color(96, 100, 191));
        TaiKhoanjLabel.setText("Tài khoản");

        TaiKhoanjPanel.setBackground(new java.awt.Color(96, 100, 191));
        TaiKhoanjPanel.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout TaiKhoanjPanelLayout = new javax.swing.GroupLayout(TaiKhoanjPanel);
        TaiKhoanjPanel.setLayout(TaiKhoanjPanelLayout);
        TaiKhoanjPanelLayout.setHorizontalGroup(
            TaiKhoanjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        TaiKhoanjPanelLayout.setVerticalGroup(
            TaiKhoanjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        MatKhaujPanel.setBackground(new java.awt.Color(51, 153, 0));
        MatKhaujPanel.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout MatKhaujPanelLayout = new javax.swing.GroupLayout(MatKhaujPanel);
        MatKhaujPanel.setLayout(MatKhaujPanelLayout);
        MatKhaujPanelLayout.setHorizontalGroup(
            MatKhaujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        MatKhaujPanelLayout.setVerticalGroup(
            MatKhaujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MenujPanelLayout = new javax.swing.GroupLayout(MenujPanel);
        MenujPanel.setLayout(MenujPanelLayout);
        MenujPanelLayout.setHorizontalGroup(
            MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenujPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TaiKhoanjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MatKhaujLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaiKhoanjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MatKhaujPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        MenujPanelLayout.setVerticalGroup(
            MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenujPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaiKhoanjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaiKhoanjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(MenujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MatKhaujLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MatKhaujPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(521, Short.MAX_VALUE))
        );

        ViewjPanel.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout ViewjPanelLayout = new javax.swing.GroupLayout(ViewjPanel);
        ViewjPanel.setLayout(ViewjPanelLayout);
        ViewjPanelLayout.setHorizontalGroup(
            ViewjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        ViewjPanelLayout.setVerticalGroup(
            ViewjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenujPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenujPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MatKhaujLabel;
    private javax.swing.JPanel MatKhaujPanel;
    private javax.swing.JPanel MenujPanel;
    private javax.swing.JLabel TaiKhoanjLabel;
    private javax.swing.JPanel TaiKhoanjPanel;
    private javax.swing.JPanel ViewjPanel;
    // End of variables declaration//GEN-END:variables
}
