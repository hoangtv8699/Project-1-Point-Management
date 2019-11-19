/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.mapper;

import com.qlsv.controller.ReadExcel;
import com.qlsv.models.MonHoc;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *
 * @author Hiddenpants-H
 */
public class MonHocExcelMapper implements ExcelMapper<MonHoc> {
    public static final int HOC_KY = 0;
    public static final int TEN_HOC_PHAN = 1;
    public static final int MA_HOC_PHAN = 2;
    public static final int MA_LOP = 3;
    public static final int SO_TIN_CHI = 4;
    public static final int TRONG_SO = 5;
    
    @Override
    public MonHoc mapRow(Iterator<Cell> cellIterator) {
        MonHoc monHoc = new MonHoc();
        while (cellIterator.hasNext()) {
            //Read cell
            Cell cell = cellIterator.next();
            
            if (cell.getColumnIndex() > 5) {
                continue;
            }
            // Set value for book object
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case HOC_KY:
                    monHoc.setHocKy(String.valueOf(((Double)new ReadExcel<>().getCellValue(cell)).intValue()));
                    break;
                case TEN_HOC_PHAN:
                    monHoc.setTenHP((String)new ReadExcel<>().getCellValue(cell));
                    break;
                case MA_HOC_PHAN:
                    monHoc.setMaHP((String)new ReadExcel<>().getCellValue(cell));
                    break;
                case MA_LOP:
                    monHoc.setMaLop(String.valueOf(((Double)new ReadExcel<>().getCellValue(cell)).intValue()));
                    break;
                case SO_TIN_CHI:
                    monHoc.setSoTC(((Double)new ReadExcel<>().getCellValue(cell)).intValue());
                    break;
                case TRONG_SO:
                    monHoc.setqT(((Double)new ReadExcel<>().getCellValue(cell)).floatValue());
                    break;
                default:
                    break;
            }

        }
        return monHoc;
    }

}
