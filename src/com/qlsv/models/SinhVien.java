package com.qlsv.models;

import java.util.List;

public class SinhVien extends User {

    private List<BangDiem> bangDiem;
    private String chuongTrinh;

    public String getChuongTrinh() {
        return chuongTrinh;
    }

    public void setChuongTrinh(String chuongTrinh) {
        this.chuongTrinh = chuongTrinh;
    }

    public void setBangDiem(List<BangDiem> bangDiem) {
        this.bangDiem = bangDiem;
    }

    public List<BangDiem> getBangDiem() {
        return bangDiem;
    }


}
