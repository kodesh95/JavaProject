package kr.excel.example;

import org.apache.poi.ss.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelExample2 {
    public static void main(String[] args) {

        try {

            FileInputStream file = new FileInputStream(new File("example.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date dateValue = cell.getDateCellValue();
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedDate = dateFormat.format(dateValue);
                                System.out.print(formattedDate + "\t");
                            } else {
                                double numbericValue = cell.getNumericCellValue();
                                if (numbericValue == Math.floor(numbericValue)) {
                                    int intValue = (int) numbericValue;
                                    System.out.print(intValue + "\t");
                                } else {
                                    System.out.print(numbericValue + "\t");
                                }
                            }
                            break;

                        case STRING:
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue + "\t");
                            break;
                        case BOOLEAN:
                            boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue + "\t");
                            break;
                        case FORMULA:
                            String formulaValue = cell.getCellFormula();
                            System.out.print(formulaValue + "\t");
                            break;
                        case BLANK:
                            System.out.print("\t");
                            break;
                        default:
                            System.out.print("\t");
                            break;

                    } // switch
                } // 두번째 for
                System.out.println();
            } // 첫번째 for

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // main

} // class
