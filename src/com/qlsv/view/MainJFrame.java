/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.controller.ChangePanelMenuController;
import com.qlsv.controller.TextBubbleBorder;
import com.qlsv.models.User;
import java.awt.Color;

/**
 *
 * @author Hiddenpants-H
 */
public class MainJFrame extends javax.swing.JFrame {
    private User user;
    private ChangePanelMenuController controller;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChangePanelMenuController getController() {
        return controller;
    }

    public void setController(ChangePanelMenuController controller) {
        this.controller = controller;
    }
    
    public MainJFrame(JPanelMenuAbstract jpnItem, User user) {
        initComponents();
        setTitle("Quản Lý Điểm Sinh Viên");
        setUser(user);
        setController(new ChangePanelMenuController(MenuJPanel, jpnView , user));
        controller.setMenu(jpnItem);
        controller.setEvent();
        controller.setView("TrangChu");
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        ApplicationNameJPanel = new javax.swing.JPanel();
        ApplicationNameJLabel = new javax.swing.JLabel();
        MenuJPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpnRoot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpnMenu.setBackground(new java.awt.Color(82, 83, 81));

        ApplicationNameJPanel.setBackground(new java.awt.Color(232, 64, 60));
        ApplicationNameJPanel.setForeground(new java.awt.Color(255, 255, 255));

        ApplicationNameJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ApplicationNameJLabel.setForeground(new java.awt.Color(255, 255, 255));
        ApplicationNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationNameJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/icon_ung_dung.png"))); // NOI18N
        ApplicationNameJLabel.setText("QUẢN LÝ ĐIỂM SINH VIÊN");
        ApplicationNameJLabel.setToolTipText("");

        javax.swing.GroupLayout ApplicationNameJPanelLayout = new javax.swing.GroupLayout(ApplicationNameJPanel);
        ApplicationNameJPanel.setLayout(ApplicationNameJPanelLayout);
        ApplicationNameJPanelLayout.setHorizontalGroup(
            ApplicationNameJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ApplicationNameJPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ApplicationNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        ApplicationNameJPanelLayout.setVerticalGroup(
            ApplicationNameJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ApplicationNameJPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(ApplicationNameJLabel)
                .addGap(25, 25, 25))
        );

        MenuJPanel.setBackground(new java.awt.Color(82, 83, 81));

        javax.swing.GroupLayout MenuJPanelLayout = new javax.swing.GroupLayout(MenuJPanel);
        MenuJPanel.setLayout(MenuJPanelLayout);
        MenuJPanelLayout.setHorizontalGroup(
            MenuJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MenuJPanelLayout.setVerticalGroup(
            MenuJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(96, 100, 191));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thoát");
        jButton1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ApplicationNameJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(ApplicationNameJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(WIDTH);
    }//GEN-LAST:event_jButton1MouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationNameJLabel;
    private javax.swing.JPanel ApplicationNameJPanel;
    private javax.swing.JPanel MenuJPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
