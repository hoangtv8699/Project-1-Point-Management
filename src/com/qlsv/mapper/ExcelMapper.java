/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.mapper;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Hiddenpants-H
 */
public interface ExcelMapper<T> {
    T mapRow(Iterator<Cell> result);
}
