/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.BangDiemDAO;
import com.qlsv.dao.MonHocDAO;
import com.qlsv.models.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hiddenpants-H
 */
public class BangDiemController extends Controller {

    private JTable bangDiemjTable;
    private JTable tongKetjTable;
    private JTextField hocKyjTextField;
    private JTextField maHPjTextField;
    private JTextField tenHPjTextField;
    private JTextField tCjTextField;
    private JTextField maLopjTextField;
    private JTextField qTjTextField;
    private JTextField cKjTextField;
    private JTextField DiemjTextField;

    public BangDiemController(JTable bangDiemjTable, JTable tongKetjTable, JTextField hocKyjTextField, JTextField maHPjTextField, JTextField tenHPjTextField, JTextField tCjTextField, JTextField maLopjTextField, JTextField qTjTextField, JTextField cKjTextField, JTextField DiemjTextField) {
        this.bangDiemjTable = bangDiemjTable;
        this.tongKetjTable = tongKetjTable;
        this.hocKyjTextField = hocKyjTextField;
        this.maHPjTextField = maHPjTextField;
        this.tenHPjTextField = tenHPjTextField;
        this.tCjTextField = tCjTextField;
        this.maLopjTextField = maLopjTextField;
        this.qTjTextField = qTjTextField;
        this.cKjTextField = cKjTextField;
        this.DiemjTextField = DiemjTextField;
    }

    public void setBangDiem(User user) {
        ((SinhVien) user).setBangDiem(new BangDiemDAO().find(user.getUser_id()));
    }

    public void setTextBangDiem(User user) {
        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
            model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
        }
    }

    public void setTextTongKet(User user) {
        DefaultTableModel model = (DefaultTableModel) tongKetjTable.getModel();
        model.setRowCount(0);
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        List<String> hocky = new ArrayList<>();
        float GPA = 0.0f, CPA = 0.0f, GPAtmp, CPAtmp;
        int tcQua = 0, tcTickLuy = 0;
        for (BangDiem tmp1 : tmp) {
            if (hocky.indexOf(tmp1.getHocKy()) < 0) {
                hocky.add(tmp1.getHocKy());
            }
        }
        for (String hockyS : hocky) {
            GPA = 0.0f;
            tcQua = 0;
            for (BangDiem tmp1 : tmp) {
                if (tmp1.getHocKy().equals(hockyS)) {
                    MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                    tcQua += mh.getSoTC();
                    GPA += getDiemBangSo(getDiemBangChu(tmp1.getDiem())) * mh.getSoTC();
                }
            }
            CPA += GPA;
            tcTickLuy += tcQua;
            GPAtmp = (float) Math.round((GPA / tcQua) * 100) / 100;
            CPAtmp = (float) Math.round((CPA / tcTickLuy) * 100) / 100;
            model.addRow(new Object[]{hockyS, GPAtmp, CPAtmp, tcQua, tcTickLuy, getTrinhDo(tcTickLuy)});
        }
    }

    public String getDiemBangChu(float f) {
        if (9.5 <= f && f <= 10) {
            return "A+";
        } else if (8.5 <= f && f < 9.5) {
            return "A";
        } else if (8 <= f && f < 8.5) {
            return "B+";
        } else if (7 <= f && f < 8) {
            return "B";
        } else if (6.5 <= f && f < 1) {
            return "C+";
        } else if (5.5 <= f && f < 6.5) {
            return "C";
        } else if (5 <= f && f < 5.5) {
            return "D+";
        } else if (4 <= f && f < 5) {
            return "D";
        } else {
            return "F";
        }
    }

    public float getDiemBangSo(String s) {
        switch (s) {
            case "A+":
                return 4.0f;
            case "A":
                return 4.0f;
            case "B+":
                return 3.5f;
            case "B":
                return 3.0f;
            case "C+":
                return 2.5f;
            case "C":
                return 2.0f;
            case "D+":
                return 1.5f;
            case "D":
                return 1.0f;
            case "F":
                return 0.0f;
            default:
                return 0.0f;
        }

    }

    public String getTrinhDo(int i) {
        if (i < 32) {
            return "Năm thứ nhất";
        } else if (32 <= i && i < 64) {
            return "Năm thứ hai";
        } else if (64 <= i && i < 96) {
            return "Năm thứ ba";
        } else if (96 <= i && i < 128) {
            return "Năm thứ tư";
        }
        if (i > 128) {
            return "Năm thứ năm";
        }
        return "";
    }

    public void hocKyFilter(User user) {
        String hocKy = hocKyjTextField.getText();

        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (hocKy.equals("")) {
            setTextBangDiem(user);
            return;
        }
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (tmp1.getHocKy().toLowerCase().matches("(.*)" + hocKy.toLowerCase() + "(.*)")) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void maHPFilter(User user) {
        String maHP = maHPjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (maHP.equals("")) {
            setTextBangDiem(user);
            return;
        }
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (tmp1.getMaHP().toLowerCase().matches("(.*)" + maHP.toLowerCase() + "(.*)")) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void tenHPFilter(User user) {
        String tenHP = tenHPjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (tenHP.equals("")) {
            setTextBangDiem(user);
            return;
        }
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
            if (mh.getTenHP().toLowerCase().matches("(.*)" + tenHP.toLowerCase() + "(.*)")) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void tcFilter(User user) {
        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (tCjTextField.getText().equals("") || !tCjTextField.getText().matches("^[0-9]{0,}$")) {
            setTextBangDiem(user);
            return;
        }
        int tc = Integer.parseInt(tCjTextField.getText());
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
            if (mh.getSoTC() == tc) {
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void maLopFilter(User user) {
        String maLop = maLopjTextField.getText();
        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (maLop.equals("") || !maLop.matches("^[0-9]{0,}$")) {
            setTextBangDiem(user);
            return;
        }
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (tmp1.getMaLop().matches("(.*)" + maLop + "(.*)")) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void diemQTFilter(User user) {

        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (qTjTextField.getText().equals("") || !qTjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextBangDiem(user);
            return;
        }
        float diemQT = Float.parseFloat(qTjTextField.getText());
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (tmp1.getDiemQT() == diemQT) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void diemCKFilter(User user) {

        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (cKjTextField.getText().equals("") || !cKjTextField.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
            setTextBangDiem(user);
            return;
        }
        float diemCK = Float.parseFloat(cKjTextField.getText());
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (tmp1.getDiemCK() == diemCK) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void diemChuFilter(User user) {

        DefaultTableModel model = (DefaultTableModel) bangDiemjTable.getModel();
        model.setRowCount(0);
        if (DiemjTextField.getText().equals("")) {
            setTextBangDiem(user);
            return;
        }
        String diemChu = DiemjTextField.getText();
        List<BangDiem> tmp = ((SinhVien) user).getBangDiem();
        for (BangDiem tmp1 : tmp) {
            if (getDiemBangChu(tmp1.getDiem()).toLowerCase().matches("(.*)" + diemChu.toLowerCase() + "(.*)")) {
                MonHoc mh = new MonHocDAO().find(tmp1.getMaLop(), tmp1.getMaHP(), tmp1.getHocKy()).get(0);
                model.addRow(new Object[]{tmp1.getHocKy(), tmp1.getMaHP(), mh.getTenHP(),
                    mh.getSoTC(), tmp1.getMaLop(), tmp1.getDiemQT(), tmp1.getDiemCK(), getDiemBangChu(tmp1.getDiem())});
            }
        }
    }

    public void setNULL() {
        hocKyjTextField.setText("");
        maHPjTextField.setText("");
        tenHPjTextField.setText("");
        maLopjTextField.setText("");
        qTjTextField.setText("");
        cKjTextField.setText("");
        DiemjTextField.setText("");
    }
}
