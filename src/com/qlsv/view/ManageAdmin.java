/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.controller.BangDiemController;
import com.qlsv.controller.ManageUserController;
import com.qlsv.controller.TextBubbleBorder;
import com.qlsv.models.Admin;
import com.qlsv.models.User;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Hiddenpants-H
 */
public class ManageAdmin extends CommonJPanel {

    /**
     * Creates new form ManageAdmin
     */
    public ManageAdmin(User user) {

        initComponents();
        jTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        jTable.getTableHeader().setBackground(new Color(255, 102, 102));
        jTable.getTableHeader().setForeground(new Color(255, 255, 255));
        setController(new ManageUserController(jTable, IDjTextField, TenjTextField, NgaySinhjTextField, SDTjTextField, EmailjTextField, DiaChijTextField, GioiTinhjTextField, user));
        ((ManageUserController)controller).setText(new Admin());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        IDjTextField = new javax.swing.JTextField();
        TenjTextField = new javax.swing.JTextField();
        NgaySinhjTextField = new javax.swing.JTextField();
        SDTjTextField = new javax.swing.JTextField();
        EmailjTextField = new javax.swing.JTextField();
        DiaChijTextField = new javax.swing.JTextField();
        GioiTinhjTextField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 716));

        jTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"20173129", null, "08/06/1999", null, "hoang.tv173129@sis.hust.edu.vnaaaaaaa", "đội 5 thôn thụy ứng hòa bình thành phố hà nội", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ và Tên", "Ngày sinh", "Sdt", "Email", "Địa chỉ", "Giới tinh"
            }
        ));
        jTable.setRowHeight(25);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(75);
            jTable.getColumnModel().getColumn(0).setMaxWidth(75);
            jTable.getColumnModel().getColumn(1).setMinWidth(150);
            jTable.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable.getColumnModel().getColumn(2).setMinWidth(100);
            jTable.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable.getColumnModel().getColumn(3).setMinWidth(150);
            jTable.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable.getColumnModel().getColumn(6).setMinWidth(100);
            jTable.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        IDjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        IDjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        IDjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDjTextFieldKeyReleased(evt);
            }
        });

        TenjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TenjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        TenjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TenjTextFieldKeyReleased(evt);
            }
        });

        NgaySinhjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NgaySinhjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        NgaySinhjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NgaySinhjTextFieldKeyReleased(evt);
            }
        });

        SDTjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SDTjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        SDTjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SDTjTextFieldKeyReleased(evt);
            }
        });

        EmailjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EmailjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        EmailjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailjTextFieldKeyReleased(evt);
            }
        });

        DiaChijTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DiaChijTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        DiaChijTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DiaChijTextFieldKeyReleased(evt);
            }
        });

        GioiTinhjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        GioiTinhjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        GioiTinhjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GioiTinhjTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TenjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NgaySinhjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SDTjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiaChijTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GioiTinhjTextField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GioiTinhjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiaChijTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NgaySinhjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SDTjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TenjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IDjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDjTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).iDFilter(new Admin());
    }//GEN-LAST:event_IDjTextFieldKeyReleased

    private void TenjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TenjTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).tenFilter(new Admin());
    }//GEN-LAST:event_TenjTextFieldKeyReleased

    private void NgaySinhjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NgaySinhjTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).ngaySinhFilter(new Admin());
    }//GEN-LAST:event_NgaySinhjTextFieldKeyReleased

    private void SDTjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SDTjTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).sDTFilter(new Admin());
    }//GEN-LAST:event_SDTjTextFieldKeyReleased

    private void EmailjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailjTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).emailFilter(new Admin());
    }//GEN-LAST:event_EmailjTextFieldKeyReleased

    private void DiaChijTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiaChijTextFieldKeyReleased
        // TODO add your handling code here:
        ((ManageUserController)controller).diaChiFilter(new Admin());
    }//GEN-LAST:event_DiaChijTextFieldKeyReleased

    private void GioiTinhjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GioiTinhjTextFieldKeyReleased
        ((ManageUserController)controller).gioiTinhFilter(new Admin());
    }//GEN-LAST:event_GioiTinhjTextFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiaChijTextField;
    private javax.swing.JTextField EmailjTextField;
    private javax.swing.JTextField GioiTinhjTextField;
    private javax.swing.JTextField IDjTextField;
    private javax.swing.JTextField NgaySinhjTextField;
    private javax.swing.JTextField SDTjTextField;
    private javax.swing.JTextField TenjTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
