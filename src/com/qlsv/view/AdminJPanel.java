/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.bean.DanhMucBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hiddenpants-H
 */
public final class AdminJPanel extends JPanelMenuAbstract{
    @Override
    public List<DanhMucBean> getListItem(){
        return listItem;
    };
    @Override
    public void setListItem(){
        listItem.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucBean("QuanLyNguoiDung", jpnQuanLyNguoidung, jlbQuanLyNguoidung));
        listItem.add(new DanhMucBean("QuanLyLopSinhVien", jpnQuanLyLopSinhVien, jlbQuanLyLopSinhVien));
        listItem.add(new DanhMucBean("QuanLyTaiKhoanCaNhan", jpnQuanLyTaiKhoanCaNhan, jlbQuanLyTaiKhoanCaNhan));
    };
    public AdminJPanel() {
        initComponents();
        setListItem();
    }


    
    
    

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenu = new javax.swing.JPanel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnQuanLyNguoidung = new javax.swing.JPanel();
        jlbQuanLyNguoidung = new javax.swing.JLabel();
        jpnQuanLyLopSinhVien = new javax.swing.JPanel();
        jlbQuanLyLopSinhVien = new javax.swing.JLabel();
        jpnQuanLyTaiKhoanCaNhan = new javax.swing.JPanel();
        jlbQuanLyTaiKhoanCaNhan = new javax.swing.JLabel();

        jpnMenu.setBackground(new java.awt.Color(82, 83, 81));

        jpnTrangChu.setBackground(new java.awt.Color(51, 153, 0));

        jlbTrangChu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/icon_home.png"))); // NOI18N
        jlbTrangChu.setText("Màn Hình Chính");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrangChuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jpnQuanLyNguoidung.setBackground(new java.awt.Color(51, 153, 0));

        jlbQuanLyNguoidung.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbQuanLyNguoidung.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLyNguoidung.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbQuanLyNguoidung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/icon_manage_user.png"))); // NOI18N
        jlbQuanLyNguoidung.setText("Quản Lý Người Dùng");

        javax.swing.GroupLayout jpnQuanLyNguoidungLayout = new javax.swing.GroupLayout(jpnQuanLyNguoidung);
        jpnQuanLyNguoidung.setLayout(jpnQuanLyNguoidungLayout);
        jpnQuanLyNguoidungLayout.setHorizontalGroup(
            jpnQuanLyNguoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLyNguoidungLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbQuanLyNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnQuanLyNguoidungLayout.setVerticalGroup(
            jpnQuanLyNguoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyNguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnQuanLyLopSinhVien.setBackground(new java.awt.Color(51, 153, 0));

        jlbQuanLyLopSinhVien.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbQuanLyLopSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLyLopSinhVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbQuanLyLopSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/manage_icon.png"))); // NOI18N
        jlbQuanLyLopSinhVien.setText("Quản Lý Lớp Sinh Viên");

        javax.swing.GroupLayout jpnQuanLyLopSinhVienLayout = new javax.swing.GroupLayout(jpnQuanLyLopSinhVien);
        jpnQuanLyLopSinhVien.setLayout(jpnQuanLyLopSinhVienLayout);
        jpnQuanLyLopSinhVienLayout.setHorizontalGroup(
            jpnQuanLyLopSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLyLopSinhVienLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbQuanLyLopSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLyLopSinhVienLayout.setVerticalGroup(
            jpnQuanLyLopSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLyLopSinhVienLayout.createSequentialGroup()
                .addComponent(jlbQuanLyLopSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnQuanLyTaiKhoanCaNhan.setBackground(new java.awt.Color(51, 153, 0));

        jlbQuanLyTaiKhoanCaNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbQuanLyTaiKhoanCaNhan.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLyTaiKhoanCaNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbQuanLyTaiKhoanCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/icon_user.png"))); // NOI18N
        jlbQuanLyTaiKhoanCaNhan.setText("Quản Lý Tài Khoản Cá Nhân");

        javax.swing.GroupLayout jpnQuanLyTaiKhoanCaNhanLayout = new javax.swing.GroupLayout(jpnQuanLyTaiKhoanCaNhan);
        jpnQuanLyTaiKhoanCaNhan.setLayout(jpnQuanLyTaiKhoanCaNhanLayout);
        jpnQuanLyTaiKhoanCaNhanLayout.setHorizontalGroup(
            jpnQuanLyTaiKhoanCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLyTaiKhoanCaNhanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLyTaiKhoanCaNhanLayout.setVerticalGroup(
            jpnQuanLyTaiKhoanCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnQuanLyLopSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQuanLyNguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLyNguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLyLopSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbQuanLyLopSinhVien;
    private javax.swing.JLabel jlbQuanLyNguoidung;
    private javax.swing.JLabel jlbQuanLyTaiKhoanCaNhan;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQuanLyLopSinhVien;
    private javax.swing.JPanel jpnQuanLyNguoidung;
    private javax.swing.JPanel jpnQuanLyTaiKhoanCaNhan;
    private javax.swing.JPanel jpnTrangChu;
    // End of variables declaration//GEN-END:variables
}
