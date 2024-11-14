package com.socialmedia.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.socialmedia.qa.base.TestBase;

public class TestUtil extends TestBase {
	private final static String FILE_PATH = prop.getProperty("testdatapath");
	
	public static List<Object[]> getExcelData() {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            rows.next();  // Skip the header row

            while (rows.hasNext()) {
                Row row = rows.next();
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                data.add(new Object[]{username, password});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
