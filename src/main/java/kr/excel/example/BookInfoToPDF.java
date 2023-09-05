package kr.excel.example;


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.HashMap;

public class BookInfoToPDF {
    public static void main(String[] args) {
        HashMap<String, String> bookInfo = new HashMap<>();
        bookInfo.put("title", "한글 자바"); // key와 value를 넣는다.
        bookInfo.put("author", "홍길동");
        bookInfo.put("publisher", "한빛");
        bookInfo.put("year", String.valueOf(Year.now().getValue())); //문자열로 변환해주는 String.valueOf()
        bookInfo.put("price", "24000");
        bookInfo.put("page", "400");


        /*  Year.now().getValue())
         *   현재의 연도를 나타내는 객체를 생성하고 getValue는 그 객체의 값을 출력해줌 */

        try {
//            PDF 생성을 위한 Pdfwriter 객체생성
            PdfWriter writer = new PdfWriter(new FileOutputStream("book_information.pdf"));
//            PdfWriter의 객체 writer을 생성하면서 pdf파일을 저장할 파일 스트림을

//            PdfWriter의 객체인 writer을 사용하여 PdfDocumnet의 객체생성
            PdfDocument pdf = new PdfDocument(writer); //PDF 파일 생성

            Document document = new Document(pdf); // PDF 문서의 내용을 구성

            //폰트 생성 및 추가
            PdfFont font = PdfFontFactory.createFont("HANBatangB.ttf", PdfEncodings.IDENTITY_H,true   );

            document.setFont(font);

            for (String key : bookInfo.keySet()) {
                Paragraph paragragh = new Paragraph(key + ": " + bookInfo.get(key));
                document.add(paragragh);
            }

            document.close();

            System.out.println("book_information.pdf 파일이 생성되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
