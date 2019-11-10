package com.qlsv.models;

import java.util.List;

public class GiangVien extends User {
        private List<MonHoc> monHoc;
	private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

    public List<MonHoc> getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(List<MonHoc> monHoc) {
        this.monHoc = monHoc;
    }
	

}
