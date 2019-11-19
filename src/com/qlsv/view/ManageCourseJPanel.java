/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.controller.QuanLyLopController;
import com.qlsv.controller.TextBubbleBorder;
import com.qlsv.models.Admin;
import com.qlsv.models.GiangVien;
import com.qlsv.models.User;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Hiddenpants-H
 */
public class ManageCourseJPanel extends CommonJPanel {

    /**
     * Creates new form ManageCourseJPanel
     */
    public ManageCourseJPanel(User user) {
        initComponents();
        setUser(user);
        dSLopjTable.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
        dSLopjTable.getTableHeader().setBackground(new Color(255,102,102));
        dSLopjTable.getTableHeader().setForeground(new Color(255,255,255));
        setController(new QuanLyLopController(dSLopjTable, hocKyjTextField, maHPjTextField, maLopjTextField, maGVjTextField, soSVjTextField, tenHPjTextField, jPanel1));
        ((QuanLyLopController)controller).setTextDSL(user);

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dSLopjTable = new javax.swing.JTable();
        hocKyjTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        maHPjTextField = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        maLopjTextField = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        maGVjTextField = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        soSVjTextField = new javax.swing.JTextField();
        tenHPjTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        hocKyjTextField1 = new javax.swing.JTextField();
        tenHPjTextField1 = new javax.swing.JTextField();
        maHPjTextField1 = new javax.swing.JTextField();
        maLopjTextField1 = new javax.swing.JTextField();
        maGVjTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1067, 768));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Danh sách lớp giảng dạy");

        dSLopjTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dSLopjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Học kỳ", "Tên học phần", "Mã học phần", "Mã lớp", "Mã giảng viên", "Số sinh viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dSLopjTable.setRowHeight(25);
        dSLopjTable.setSelectionBackground(new java.awt.Color(102, 255, 255));
        dSLopjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dSLopjTableMouseClicked(evt);
            }
        });
        dSLopjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dSLopjTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(dSLopjTable);
        if (dSLopjTable.getColumnModel().getColumnCount() > 0) {
            dSLopjTable.getColumnModel().getColumn(0).setMinWidth(100);
            dSLopjTable.getColumnModel().getColumn(0).setMaxWidth(100);
            dSLopjTable.getColumnModel().getColumn(5).setMinWidth(100);
            dSLopjTable.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        hocKyjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hocKyjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        hocKyjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hocKyjTextFieldActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        maHPjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maHPjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maHPjTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maHPjTextFieldMouseClicked(evt);
            }
        });
        maHPjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHPjTextFieldActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton6.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        maLopjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maLopjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maLopjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maLopjTextFieldActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton7.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        maGVjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maGVjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maGVjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maGVjTextFieldActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton8.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        soSVjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        soSVjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        soSVjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soSVjTextFieldActionPerformed(evt);
            }
        });

        tenHPjTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tenHPjTextField.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));

        jButton2.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Reset");
        jButton3.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("Xem chi tiết");
        jButton4.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        hocKyjTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hocKyjTextField1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        hocKyjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hocKyjTextField1ActionPerformed(evt);
            }
        });

        tenHPjTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tenHPjTextField1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));

        maHPjTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maHPjTextField1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maHPjTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maHPjTextField1MouseClicked(evt);
            }
        });
        maHPjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHPjTextField1ActionPerformed(evt);
            }
        });

        maLopjTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maLopjTextField1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maLopjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maLopjTextField1ActionPerformed(evt);
            }
        });

        maGVjTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        maGVjTextField1.setBorder(new TextBubbleBorder(Color.MAGENTA.darker(), 1, 5, 0));
        maGVjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maGVjTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Học kỳ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tên học phần");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Mã học phần");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Mã Lớp");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Mã giảng viên");

        jButton10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton10.setText("Thêm Lớp sv");

        jButton11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton11.setText("Xóa lớp đã chọn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hocKyjTextField1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenHPjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maHPjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maLopjTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maGVjTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hocKyjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tenHPjTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maHPjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maLopjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maGVjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soSVjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel1)
                                .addGap(279, 279, 279)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(soSVjTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(maGVjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maHPjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tenHPjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(maLopjTextField)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hocKyjTextField)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maHPjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenHPjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hocKyjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maLopjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maGVjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dSLopjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dSLopjTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dSLopjTableKeyPressed

    private void hocKyjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hocKyjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hocKyjTextFieldActionPerformed

    private void dSLopjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dSLopjTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dSLopjTableMouseClicked

    private void maHPjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHPjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maHPjTextFieldActionPerformed

    private void maLopjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maLopjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maLopjTextFieldActionPerformed

    private void maGVjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maGVjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maGVjTextFieldActionPerformed

    private void soSVjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soSVjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soSVjTextFieldActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ((QuanLyLopController)controller).hocKyFilter(user);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        ((QuanLyLopController)controller).setTextDSL(user);
        ((QuanLyLopController)controller).setNULL();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        ((QuanLyLopController)controller).tenHPFilter(user);
    }//GEN-LAST:event_jButton2MouseClicked

    private void maHPjTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maHPjTextFieldMouseClicked
        
    }//GEN-LAST:event_maHPjTextFieldMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        ((QuanLyLopController)controller).maHPFilter(user);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        ((QuanLyLopController)controller).maLopFilter(user);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        ((QuanLyLopController)controller).maGVFilter(user);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        ((QuanLyLopController)controller).soSVFilter(user);
        
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        ((QuanLyLopController)controller).selected();
    }//GEN-LAST:event_jButton4MouseClicked

    private void hocKyjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hocKyjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hocKyjTextField1ActionPerformed

    private void maHPjTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maHPjTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_maHPjTextField1MouseClicked

    private void maHPjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHPjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maHPjTextField1ActionPerformed

    private void maLopjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maLopjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maLopjTextField1ActionPerformed

    private void maGVjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maGVjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maGVjTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dSLopjTable;
    private javax.swing.JTextField hocKyjTextField;
    private javax.swing.JTextField hocKyjTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maGVjTextField;
    private javax.swing.JTextField maGVjTextField1;
    private javax.swing.JTextField maHPjTextField;
    private javax.swing.JTextField maHPjTextField1;
    private javax.swing.JTextField maLopjTextField;
    private javax.swing.JTextField maLopjTextField1;
    private javax.swing.JTextField soSVjTextField;
    private javax.swing.JTextField tenHPjTextField;
    private javax.swing.JTextField tenHPjTextField1;
    // End of variables declaration//GEN-END:variables
}
