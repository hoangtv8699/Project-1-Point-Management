/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.mapper;

import com.qlsv.controller.ReadExcel;
import static com.qlsv.controller.ReadExcel.HOC_KY;
import static com.qlsv.controller.ReadExcel.MA_GIANG_VIEN;
import static com.qlsv.controller.ReadExcel.MA_HOC_PHAN;
import static com.qlsv.controller.ReadExcel.MA_LOP;
import static com.qlsv.controller.ReadExcel.SO_TIN_CHI;
import static com.qlsv.controller.ReadExcel.TEN_HOC_PHAN;
import static com.qlsv.controller.ReadExcel.TRONG_SO;
import com.qlsv.models.BangDiem;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Hiddenpants-H
 */
public class BangDiemExcelMapper implements ExcelMapper<BangDiem>{
    public static final int MA_SV = 1;
    public static final int DIEM_QT = 3;
    public static final int DIEM_CK = 4;
    
    
    @Override
    public BangDiem mapRow(Iterator<Cell> cellIterator) {
         BangDiem bangDiem = new BangDiem();
        while (cellIterator.hasNext()) {
            //Read cell
            Cell cell = cellIterator.next();
            
            if (cell.getColumnIndex() > 4) {
                continue;
            }
            // Set value for book object
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case MA_SV:
                    bangDiem.setUser_id(((Double)new ReadExcel<>().getCellValue(cell)).longValue());
                    break;
                case DIEM_QT:
                    bangDiem.setDiemQT(((Double)new ReadExcel<>().getCellValue(cell)).floatValue());
                    break;
                case DIEM_CK:
                    bangDiem.setDiemCK(((Double)new ReadExcel<>().getCellValue(cell)).floatValue());
                    break;
                default:
                    break;
            }

        }
        return bangDiem;
    }
    
}
