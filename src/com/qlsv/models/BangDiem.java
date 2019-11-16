package com.qlsv.models;

public class BangDiem {
    private String hocKy;
    private String maLop;
    private String maHP;
    private float diemQT;
    private float diemCK;
    private float diem;

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public float getDiemQT() {
        return diemQT;
    }

    public void setDiemQT(float diemQT) {
        this.diemQT = diemQT;
    }

    public float getDiemCK() {
        return diemCK;
    }

    public void setDiemCK(float diemCK) {
        this.diemCK = diemCK;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem() {
        this.diem = diemQT * 0.3f + diemCK * 0.7f;
    }
    
    public void setDiem(float diem) {
        this.diem = diem;
    }

}
