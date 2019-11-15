/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.bean.DanhMucBean;
import java.util.List;

/**
 *
 * @author Hiddenpants-H
 */
public class GVJPanel extends JPanelMenuAbstract {
@Override
    public List<DanhMucBean> getListItem(){
        return listItem;
    };
    @Override
    public void setListItem(){
        listItem.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucBean("QuanLyLopSinhVien", jpnQuanLyLopGiangDay, jlbQuanLyLopGiangDay));
        listItem.add(new DanhMucBean("QuanLyTaiKhoanCaNhan", jpnQuanLyTaiKhoanCaNhan, jlbQuanLyTaiKhoanCaNhan));
    };
    
    public GVJPanel() {
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
        jpnQuanLyLopGiangDay = new javax.swing.JPanel();
        jlbQuanLyLopGiangDay = new javax.swing.JLabel();
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

        jpnQuanLyLopGiangDay.setBackground(new java.awt.Color(51, 153, 0));

        jlbQuanLyLopGiangDay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbQuanLyLopGiangDay.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuanLyLopGiangDay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbQuanLyLopGiangDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlsv/image/manage_icon.png"))); // NOI18N
        jlbQuanLyLopGiangDay.setText("Quản Lý Lớp Giảng Dạy");

        javax.swing.GroupLayout jpnQuanLyLopGiangDayLayout = new javax.swing.GroupLayout(jpnQuanLyLopGiangDay);
        jpnQuanLyLopGiangDay.setLayout(jpnQuanLyLopGiangDayLayout);
        jpnQuanLyLopGiangDayLayout.setHorizontalGroup(
            jpnQuanLyLopGiangDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQuanLyLopGiangDayLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbQuanLyLopGiangDay, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnQuanLyLopGiangDayLayout.setVerticalGroup(
            jpnQuanLyLopGiangDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQuanLyLopGiangDayLayout.createSequentialGroup()
                .addComponent(jlbQuanLyLopGiangDay, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(30, 30, 30)
                .addComponent(jlbQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jpnQuanLyLopGiangDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLyLopGiangDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnQuanLyTaiKhoanCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbQuanLyLopGiangDay;
    private javax.swing.JLabel jlbQuanLyTaiKhoanCaNhan;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQuanLyLopGiangDay;
    private javax.swing.JPanel jpnQuanLyTaiKhoanCaNhan;
    private javax.swing.JPanel jpnTrangChu;
    // End of variables declaration//GEN-END:variables
}
