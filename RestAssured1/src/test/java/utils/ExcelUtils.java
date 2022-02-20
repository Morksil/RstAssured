package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {

        workbook =  new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public void getCellData(int rowNum, int colNum) throws IOException {

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);
    }

    public void getRowCount() throws IOException {

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rowns " + rowCount);
    }


}
