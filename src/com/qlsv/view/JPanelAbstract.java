/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.view;

import com.qlsv.bean.DanhMucBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiddenpants-H
 */ 
public abstract class JPanelAbstract extends javax.swing.JPanel{
    public List<DanhMucBean> listItem = new ArrayList<>();
    public abstract List<DanhMucBean> getListItem();
    public abstract void setListItem();
}
