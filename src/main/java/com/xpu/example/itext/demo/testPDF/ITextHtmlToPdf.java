package com.xpu.example.itext.demo.testPDF;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ITextHtmlToPdf {

    public void exportPDF(HttpServletRequest request, HttpServletResponse response, String title, String text) {
        Document document = new Document();

        try {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String((title + ".pdf").getBytes(), StandardCharsets.ISO_8859_1));
            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            //在下面，body中设置了style，设置了默认字体为宋体，这样导出时的html语言就默认带有了字体，汉字才会导出成功
            String content = "<html><body style=\"font-family: 宋体, SimHei;\">" +
                    "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 24px;\">"
                    + title + "</span></p>" + text + "</body></html>";
            byte[] b = content.getBytes(StandardCharsets.UTF_8);  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, bais, Charset.forName("UTF-8"), new PdfFont());
            bais.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
