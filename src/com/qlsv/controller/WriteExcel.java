/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_TITLE = 1;
    public static final int COLUMN_INDEX_PRICE = 2;
    public static final int COLUMN_INDEX_QUANTITY = 3;
    public static final int COLUMN_INDEX_TOTAL = 4;
    private static CellStyle cellStyleFormatNumber = null;

    public void writeExcel(JTable jTable, String excelFilePath) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            // Create Workbook
            Workbook workbook = getWorkbook(excelFilePath);

            // Create sheet
            Sheet sheet = workbook.createSheet("dssv"); // Create sheet with sheet name

            int rowIndex = 0;

            // Write header
            writeHeader(sheet, rowIndex, model);

            // Write data
            for (rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
                // Create row
                Row row = sheet.createRow(rowIndex + 1);
                // Write data on row
                writeBook(model, row, rowIndex);
            }

            // Auto resize column witdth
            int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
            autosizeColumn(sheet, numberOfColumn);

            // Create file excel
            createOutputFile(workbook, excelFilePath);
            JOptionPane.showMessageDialog(new JFrame(), "Export file thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "File bạn chọn không đúng địn dạng!");
        }

        return workbook;
    }

    // Write header with format
    public void writeHeader(Sheet sheet, int rowIndex, DefaultTableModel model) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }
    }

    // Write data
    public void writeBook(DefaultTableModel model, Row row, int rowIndex) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(model.getValueAt(rowIndex, i).toString());
        }

    }

    // Create CellStyle for header
    public CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Write footer
    public void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
        cell.setCellFormula("SUM(E2:E6)");
    }

    // Auto resize column width
    public void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    public void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

}
