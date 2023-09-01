package kr.excel.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExample {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new File("example.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row)
                    System.out.print(cell.toString() + "\t");

                System.out.println(); // 줄바꿈
            }
            file.close();
            System.out.println("엑셀에서 데이터읽어오기 성공");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
/*
1.0	2.0	3.0	4.0	5.0
A	B	C	D	E
홍길동	이길동	조길동	박길동	송길동
35.6	59.1	23.2	65.8	32.1
20-3월-2023	21-3월-2023	22-3월-2023	23-3월-2023	24-3월-2023
*/