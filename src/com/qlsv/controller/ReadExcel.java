package com.qlsv.controller;
 
import com.qlsv.mapper.ExcelMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType._NONE;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadExcel<T> {
    public static final int HOC_KY = 0;
    public static final int TEN_HOC_PHAN = 1;
    public static final int MA_HOC_PHAN = 2;
    public static final int MA_LOP = 3;
    public static final int SO_TIN_CHI = 4;
    public static final int TRONG_SO = 5;
    public static final int MA_GIANG_VIEN = 6;

 
    public List<T> readExcel(String excelFilePath, ExcelMapper<T> excelMapper){
        List<T> list = new ArrayList<T>();
        InputStream inputStream = null;
        Workbook workbook = null;
        try{
        // Get file
        inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        workbook = getWorkbook(inputStream, excelFilePath);
        
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }
 
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            list.add(excelMapper.mapRow(cellIterator));
        }
 
        
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(workbook != null){
                try{
                    workbook.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                }                      
            }
            
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                }                      
            }
            
            
        }
        
 
        return list;
    }
 
    // Get Workbook
    public Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
    
    public Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
}