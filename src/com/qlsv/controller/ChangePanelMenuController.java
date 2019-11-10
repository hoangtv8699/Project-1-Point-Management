/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.bean.DanhMucBean;
import com.qlsv.view.BangDiemCaNhan;
import com.qlsv.view.AdminJPanel;
import com.qlsv.view.ManageCourseJPanel;
import com.qlsv.view.ManageUserJPanel;
import com.qlsv.view.JPanelAbstract;
import com.qlsv.view.MatKhauJPanel;
import com.qlsv.view.TaiKhoanJPanel;
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
public class ChangePanelMenuController {

    private JPanel leftRoot;
    private JPanel RightRoot;
    private String kindSelected = "";

    private List<DanhMucBean> listDanhMuc = null;

    public ChangePanelMenuController(JPanel leftRoot, JPanel RightRoot) {
        this.leftRoot = leftRoot;
        this.RightRoot = RightRoot;
    }

    public ChangePanelMenuController(JPanel RightRoot) {
        this.RightRoot = RightRoot;
    }

    public void setMenu(JPanelAbstract jpnItem) {
        listDanhMuc = jpnItem.getListItem();
        leftRoot.removeAll();
        leftRoot.setLayout(new BorderLayout());
        leftRoot.add(jpnItem);
        leftRoot.validate();
        leftRoot.repaint();
    }

    public void setView(String s) {
        JPanel node = getjPanel(s);
        kindSelected = s;
        for (DanhMucBean item : listDanhMuc) {
            if (item.getKind().equals(kindSelected)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            }
        }
        RightRoot.removeAll();
        RightRoot.setLayout(new BorderLayout());
        RightRoot.add(node);
        RightRoot.validate();
        RightRoot.repaint();
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TaiKhoan";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        RightRoot.removeAll();
        RightRoot.setLayout(new BorderLayout());
        RightRoot.add(new TaiKhoanJPanel());
        RightRoot.validate();
        RightRoot.repaint();
    }

    public void setEvent() {
        for (DanhMucBean item : listDanhMuc) {
            item.getJlb().addMouseListener(new PanelEvent(item.getKind(), item.getJpn(), item.getJlb(), listDanhMuc));
        }
    }

    public void setPanelEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMucBean item : listDanhMuc) {
            item.getJlb().addMouseListener(new PanelEvent(item.getKind(), item.getJpn(), item.getJlb(), listDanhMuc));
        }
    }
    public void setLabelEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMucBean item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb(), listDanhMuc));
        }
    }
    
    public JPanel getjPanel(String s){
        JPanel node;
        switch (s) {
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
                case "XemBangDiemCaNhan":
                    node = new BangDiemCaNhan();
                    break;
                case "TaiKhoan":
                    node = new TaiKhoanJPanel();
                    break;
                case "MatKhau":
                    node = new MatKhauJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
        return node;
    }

    class PanelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;
        private List<DanhMucBean> listDanhMuc = null;

        public PanelEvent(String kind, JPanel jpnItem, JLabel jlbItem, List<DanhMucBean> listDanhMuc) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.listDanhMuc = listDanhMuc;
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            node = getjPanel(kind);
            RightRoot.removeAll();
            RightRoot.setLayout(new BorderLayout());
            RightRoot.add(node);
            RightRoot.validate();
            RightRoot.repaint();
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
                    item.getJlb().setBackground(new Color(51, 153, 0));
                }
            }
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
//            node = getjPanel(kind);
//            RightRoot.removeAll();
//            RightRoot.setLayout(new BorderLayout());
//            RightRoot.add(node);
//            RightRoot.validate();
//            RightRoot.repaint();
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            kindSelected = kind;
            jlbItem.setForeground(new Color(96, 100, 191));
            setChangeBackground(kind);
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jlbItem.setForeground(new Color(153, 153, 255));
            }
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jlbItem.setForeground(new Color(51, 153, 0));
            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMucBean item : listDanhMuc) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJlb().setForeground(new Color(96, 100, 191));
                } else {
                    item.getJlb().setForeground(new Color(51, 153, 0));
                }
            }
        }
    }

}
