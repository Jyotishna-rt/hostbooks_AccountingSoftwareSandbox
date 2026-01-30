package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {


    public static Object[][] getTestData(String filename, String sheetName) throws IOException {
        try (InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream(filename)) {
            if (fis == null) {
                throw new IOException("File not found: " + filename);
            }

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();

            int totalRows = sheet.getPhysicalNumberOfRows();
            Row headerRow = sheet.getRow(0);
            int cols = (headerRow != null) ? headerRow.getLastCellNum() : 0;

            List<Object[]> dataList = new ArrayList<>();

            for (int i = 1; i < totalRows; i++) { // Skip header row
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String[] rowData = new String[cols];
                boolean isEmptyRow = true;

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = formatter.formatCellValue(cell).trim();
                    rowData[j] = value;
                    if (!value.isEmpty()) isEmptyRow = false;
                }

                if (!isEmptyRow) {
                    dataList.add(rowData);
                }
            }

            workbook.close();
            return dataList.toArray(new Object[0][0]);

        } catch (Exception e) {
            throw new IOException("Failed to read Excel file: " + e.getMessage(), e);
        }
    }
}
//    public static Object[][] getdatafromexcel() throws IOException {
//
//
//        //fetch data from excel code and store it into 2d array and return
//        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Datafiles\\Contactdetails.xlsx");
//
//        //workbook factory create instance
//
//        Workbook wb = WorkbookFactory.create(fs);
//        int rownum = wb.getSheet("Sheet1").getPhysicalNumberOfRows();
//
//        int colnum = wb.getSheet("Sheet1").getRow(1).getLastCellNum();
//
//
//        //create 2d array data to store data from excel file
//
//        Object[][] ob = new Object[rownum][colnum];
//
//        String[][] data = null;
//
//        for (int i = 0; i < rownum; i++) {
//
//            for (int j = 0; j < colnum; j++) {
//
//                ob[i][j] = wb.getSheet("Sheet1").getRow(i + 1).getCell(j).getStringCellValue();
//
//                System.out.println(ob[i][j]);
//            }
//        }
//        return ob;
//    }
//
//}



