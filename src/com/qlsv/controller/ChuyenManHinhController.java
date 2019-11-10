/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.bean.DanhMucBean;
import com.qlsv.models.Admin;
import com.qlsv.view.ManageCourseJPanel;
import com.qlsv.view.ManageUserJPanel;
import com.qlsv.view.TrangChuJPanel;
import com.qlsv.view.UserManageJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hiddenpants-H
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listDanhMuc = null;

    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMucBean item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb(), listDanhMuc));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;
        private List<DanhMucBean> listDanhMuc = null;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem, List<DanhMucBean> listDanhMuc) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.listDanhMuc = listDanhMuc;
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "QuanLyNguoiDung":
                    node = new ManageUserJPanel();
                    break;
                case "QuanLyLopSinhVien":
                    node = new ManageCourseJPanel();
                    break;
                case "QuanLyTaiKhoanCaNhan":
                    node = new UserManageJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            kindSelected = kind;
            jlbItem.setBackground(new Color(96, 100, 191));
            jpnItem.setBackground(new Color(96, 100, 191));
            setChangeBackground(kind);
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jlbItem.setBackground(new Color(153, 153, 255));
                jpnItem.setBackground(new Color(153, 153, 255));
            }
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jlbItem.setBackground(new Color(51, 153, 0));
                jpnItem.setBackground(new Color(51, 153, 0));
            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMucBean item : listDanhMuc) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(new Color(96, 100, 191));
                    item.getJlb().setBackground(new Color(96, 100, 191));
                } else {
                    item.getJpn().setBackground(new Color(51, 153, 0));
                    item.getJpn().setBackground(new Color(51, 153, 0));
                }
            }
        }
    }
}
