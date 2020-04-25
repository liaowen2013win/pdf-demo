/**
 * @(#)TestPDFController.java, 2018/12/29.
 * <p/>
 */
package com.xpu.example.itext.demo.controller;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.xpu.example.itext.demo.constant.PDFpoints;
import com.xpu.example.itext.demo.errorCode.ErrorCodeEnum;
import com.xpu.example.itext.demo.response.ApiResponse;
import com.xpu.example.itext.demo.testPDF.ITextRenderListener;
import com.xpu.example.itext.demo.utils.itextUtils.PdfReplacer;
import com.xpu.example.itext.demo.utils.pd4mlUtils.HtmlToPDFUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L.Wen
 */
@RestController
@RequestMapping("testPDF")
public class TestPDFController {

    @Value("${pdf-path}")
    private String rootPath;// 线上用

    private String filePath = "D:\\_____Work\\";// 本地测试用
    private static String USER_PASSWORD = "123456";
    private static String OWNER_PASSWORD = "123456";

    /**
     * 测试-生成PDF文件
     *
     * @return
     */
    @GetMapping("pdfHelloWorld")
    public ApiResponse pdfHelloWorld() {
//        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("A Hello World PDF document. "));
            document.close();
            writer.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    /**
     * 往PDF文件添加图片，并指定图片位置和大小（尺寸）
     *
     * @return
     */
    @GetMapping("pdfImage")
    public ApiResponse pdfImage() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "AddImageExample.pdf"));
            document.open();
            document.add(new Paragraph("Image Example"));
            //读取图片
            Image image1 = Image.getInstance(filePath + "temp22.png");
            //指定图片的位置（0 0 位于页面的左下角）
            image1.setAbsolutePosition(0f, 0f);
            //指定图片的尺寸
            image1.scaleAbsolute(200, 200);
            //添加图片
            document.add(image1);
            // 读取网络图片
            String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
            Image image2 = Image.getInstance(new URL(imageUrl));
            //指定图片的位置
            image2.setAbsolutePosition(0f, 250f);
            //指定图片的尺寸
            image2.scaleAbsolute(200, 200);
            document.add(image2);
            document.close();
            writer.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    /**
     * 添加表格
     *
     * @return
     */
    @GetMapping("pdfExcel")
    public ApiResponse pdfExcel() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "AddTableExample.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(3); // 3列
            table.setWidthPercentage(100); // 表格宽度
            table.setSpacingBefore(10f); // 表格左侧的空格
            table.setSpacingAfter(10f); // 表格右侧的空格

            // 设置列宽
            float[] columnWidths = {1f, 1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));// 单元格里的内容
            cell1.setBorderColor(BaseColor.BLUE);// 单元格边框颜色
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
            cell2.setBorderColor(BaseColor.GREEN);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
            cell3.setBorderColor(BaseColor.RED);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // To avoid having the cell border and the content overlap, if you
            // are having thick cell borders
            // cell1.setUserBorderPadding(true);
            // cell2.setUserBorderPadding(true);
            // cell3.setUserBorderPadding(true);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            document.add(table);
            document.close();
            writer.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    /**
     * 添加列表
     *
     * @return
     */
    @GetMapping("pdfList")
    public ApiResponse pdfList() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "ListExample.pdf"));
            document.open();
            document.add(new Paragraph("List Example"));

            //添加有序列表
            List orderedList = new List(List.ORDERED);
            orderedList.add(new ListItem("Item 1"));
            orderedList.add(new ListItem("Item 2"));
            orderedList.add(new ListItem("Item 3"));
            document.add(orderedList);

            //添加无序列表
            List unorderedList = new List(List.UNORDERED);
            unorderedList.add(new ListItem("Item 1"));
            unorderedList.add(new ListItem("Item 2"));
            unorderedList.add(new ListItem("Item 3"));
            document.add(unorderedList);

            //添加罗马数字编号的列表
            RomanList romanList = new RomanList();
            romanList.add(new ListItem("Item 1"));
            romanList.add(new ListItem("Item 2"));
            romanList.add(new ListItem("Item 3"));
            document.add(romanList);

            //添加希腊字母编号的列表
            GreekList greekList = new GreekList();
            greekList.add(new ListItem("Item 1"));
            greekList.add(new ListItem("Item 2"));
            greekList.add(new ListItem("Item 3"));
            document.add(greekList);

            //添加带有项目符号的列表
            ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(43, 30);
            zapfDingbatsList.add(new ListItem("Item 1"));
            zapfDingbatsList.add(new ListItem("Item 2"));
            zapfDingbatsList.add(new ListItem("Item 3"));
            document.add(zapfDingbatsList);

            //带有子列表的列表
            List nestedList = new List(List.UNORDERED);
            nestedList.add(new ListItem("Item 1"));
            List sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("A");
            sublist.add("B");
            nestedList.add(sublist);
            nestedList.add(new ListItem("Item 2"));
            sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("C");
            sublist.add("D");
            nestedList.add(sublist);
            document.add(nestedList);
            document.close();
            writer.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    /**
     * 设置样式
     *
     * @return
     */
    @GetMapping("pdfFont")
    public ApiResponse pdfFont() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "StylingExample.pdf"));
            document.open();
            document.add(new Paragraph("Styling Example"));

            //设置颜色和样式
            Paragraph paragraphOne = new Paragraph("Some colored paragraph text", redFont);
            document.add(paragraphOne);

            //创建章节
            Paragraph chapterTitle = new Paragraph("Chapter Title", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            Paragraph sectionTitle = new Paragraph("Section Title", redFont);
            Section section1 = chapter1.addSection(sectionTitle);

            Paragraph sectionContent = new Paragraph("Section Text content", blueFont);
            section1.add(sectionContent);

            document.add(chapter1);

            document.close();
            writer.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    /**
     * 设置密码
     *
     * @return
     */
    @GetMapping("pdfSetPassword")
    public ApiResponse pdfSetPassword() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            OutputStream file = new FileOutputStream(
                    new File(filePath + "PasswordProtected.pdf"));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            writer.setEncryption(USER_PASSWORD.getBytes(),
                    OWNER_PASSWORD.getBytes(),
                    PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_128);
            document.open();
            document.add(new Paragraph("Password Protected pdf example !!"));
            document.close();
            file.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    @GetMapping("pdfSetAuthority")
    public ApiResponse pdfSetAuthority() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            OutputStream file = new FileOutputStream(
                    new File(filePath + "LimitedAccess.pdf"));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);

            writer.setEncryption("".getBytes(), "".getBytes(),
                    PdfWriter.ALLOW_PRINTING, // 只允许打印
                    PdfWriter.ENCRYPTION_AES_128);

            document.open();
            document.add(new Paragraph("Limited Access File !!"));
            document.close();
            file.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    @GetMapping("pdfEditContent")
    public ApiResponse pdfEditContent() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            //读取文件内容
            PdfReader pdfReader = new PdfReader(filePath + "HelloWorld.pdf");

            //修改文件内容
            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream(filePath + "HelloWorld-modified.pdf"));

            Image image = Image.getInstance(filePath + "temp22.png");
            image.scaleAbsolute(100, 50);
            image.setAbsolutePosition(10, 770);

            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfContentByte content = pdfStamper.getUnderContent(i);
                content.addImage(image);
            }

            pdfStamper.close();
            return ApiResponse.ofSuccess(filePath);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
    }

    @GetMapping("pdfOutput")
    public ApiResponse pdfOutput(HttpServletResponse response) {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        Document document = new Document();
        try {
            response.setContentType("application/pdf");
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("how to do in java.com"));
            document.add(new Paragraph(new Date().toString()));

        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.ofMessage(ErrorCodeEnum.EXCEPTION.getErrorCode(), ErrorCodeEnum.EXCEPTION.getErrorMsg());
        }
        document.close();
        return ApiResponse.ofSuccess(ErrorCodeEnum.OPERATE_OK.getErrorMsg());
    }


    /**
     * todo 测试如何在指定位置添加内容
     *
     * @return
     */
    public boolean generateContract() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            PdfReader reader = new PdfReader(filePath + "__testContent.pdf");
            OutputStream file = new FileOutputStream(
                    new File(filePath + "__testContent_out.pdf"));
            PdfDocument pdfDoc = new PdfDocument();
            PdfWriter.getInstance(pdfDoc, file);

            PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            System.out.println("————————————————————————————————————我在这里");
            pdfDoc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * * 给PDF上添加图片
     *
     * @param page         指定要添加图片的pdf页
     * @param marginLeft   左边距
     * @param marginBottom 底边距
     * @param savePdf      原PDF路径
     * @param savePng      原图片路径
     * @param sealPdf      新生成PDF路径
     * @return
     * @throws IOException
     */
    public static boolean addSeal(int page, int marginLeft, int marginBottom, String savePdf, String savePng,
                                  String sealPdf) throws IOException {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用

        PdfReader pdfreader = new PdfReader(savePdf);
        // 获得PDF总页数
        int pdfPage = pdfreader.getNumberOfPages();
        if (page <= 0 || page > pdfPage) {
            System.out.println("pdf文件无当前页");
        }
        // 获取指定页的宽和高
        Document document = new Document(pdfreader.getPageSize(page));
        // 获取页面宽度
        float width = document.getPageSize().getWidth();
        // 获取页面高度
        float height = document.getPageSize().getHeight();
        if (pdfreader != null)
            pdfreader.close();
        if (document != null)
            document.close();
        System.out.println("pdfPage=" + pdfPage + ",width = " + width
                + ", height = " + height);
        PdfReader pdfReader = new PdfReader(savePdf);
        PdfStamper stamper = null;
        try {
            stamper = new PdfStamper(pdfReader, new FileOutputStream(sealPdf));// 生成的PDF
            PdfContentByte overContent = stamper.getOverContent(page);
            Image image = Image.getInstance(savePng);// 图片名称
            image.setAbsolutePosition(marginLeft, marginBottom);// 左边距、底边距
            overContent.addImage(image);
            overContent.stroke();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != stamper) {
                    stamper.close();
                }
                if (pdfReader != null) {
                    pdfReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 在指定位置写文字
     */
    @GetMapping("editPDF")
    public void editPDF() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(filePath + "test.pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
                    BaseFont.NOT_EMBEDDED);
            cb.beginText();
            cb.setFontAndSize(bf, 12);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                    "This text is centered", 0, 0, 0);
            cb.endText();
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 根据生成好的模板，向里面填充数据
     */
    @GetMapping("testEdit")
    public void testEdit() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            String TemplatePDF = filePath + "__testContent.pdf"; //模板路径
            String outFile = filePath + "test1.pdf"; //生成新的pdf的路径
            PdfReader reader = new PdfReader(TemplatePDF);
            PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outFile)); // 生成的输出流
            AcroFields s = ps.getAcroFields();
            // 插入文字
            insertText(ps, s);
            // 插入图片
            insertImage(ps, s);
            ps.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入图片
     */
    public void insertImage(PdfStamper ps, AcroFields s) {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            java.util.List<AcroFields.FieldPosition> list = s.getFieldPositions("甲方：");
            Rectangle signRect = list.get(0).position;
            Image image = Image.getInstance(filePath + "temp22.png");
            PdfContentByte under = ps.getOverContent(1);
            float x = signRect.getLeft();
            float y = signRect.getBottom();
            System.out.println(x);
            System.out.println(y);
            image.setAbsolutePosition(x, y);
            image.scaleToFit(signRect.getWidth(), signRect.getHeight());
            under.addImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建Chunk
     *
     * @return
     * @author L.Wen
     */
    public Chunk CreateChunk() {
        BaseFont bfChinese;
        Chunk chunk = null;
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            Font fontChinese = new Font(bfChinese, 10 * 4 / 3);
            chunk = new Chunk("张三", fontChinese);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chunk;
    }

    /**
     * 插入文本
     *
     * @return
     * @author L.Wen
     */
    public void insertText(PdfStamper ps, AcroFields s) {
        java.util.List<AcroFields.FieldPosition> list = s.getFieldPositions("乙方：");
        Rectangle rect = list.get(0).position;
        PdfContentByte cb = ps.getOverContent(1);
        PdfPTable table = new PdfPTable(1);
        float tatalWidth = rect.getRight() - rect.getLeft() - 1;
        table.setTotalWidth(tatalWidth);
        PdfPCell cell = new PdfPCell(new Phrase(CreateChunk()));
        cell.setFixedHeight(rect.getTop() - rect.getBottom() - 1);
        cell.setBorderWidth(0);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setLeading(0, (float) 1.1);
        table.addCell(cell);
        table.writeSelectedRows(0, -1, rect.getLeft(), rect.getTop(), cb);
    }

    @GetMapping("testRender")
    public void testRender() {
        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用
        try {
            String pdfPath = filePath + "__testContent.pdf";
            PdfReader reader = new PdfReader(pdfPath);
            //新建一个PDF解析对象
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            //包含了PDF页面的信息，作为处理的对象
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(filePath + "__testContent2.pdf"));
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                //新建一个ImageRenderListener对象，该对象实现了RenderListener接口，作为处理PDF的主要类
                ITextRenderListener listener = new ITextRenderListener();
                //解析PDF，并处理里面的文字
                parser.processContent(i, listener);
                //获取文字的矩形边框
                java.util.List<Rectangle2D.Float> rectText = listener.rectText;
                java.util.List<String> textList = listener.textList;
                java.util.List<Float> listY = listener.listY;
                java.util.List<Map<String, Rectangle2D.Float>> list_text = listener.rows_text_rect;
                for (int k = 0; k < list_text.size(); k++) {
                    Map<String, Rectangle2D.Float> map = list_text.get(k);
                    for (Map.Entry<String, Rectangle2D.Float> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + "---" + entry.getValue());
                    }
                }
            }

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回的是文件的绝对路径
     *
     * @return
     */
    @GetMapping("testHtml2PDFPath")
    public ApiResponse testHtml2PDFPath() {
        String title = "标题-测试生成PDF";
        String text = "正文-这里是正文";
        //此处填写你的html文件
        //在下面，body中设置了style，设置了默认字体为宋体，这样导出时的html语言就默认带有了字体，汉字才会导出成功
        String html = "<html><body style=\"font-family: 宋体, SimHei;\">" +
                "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 24px;\">"
                + "${title}$" + "</span></p>" + "${text}$" + "</body></html>";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", title);
        paramMap.put("text", text);
        String file = HtmlToPDFUtil.htmlStr2PDF(paramMap, html, rootPath);
        return ApiResponse.ofSuccess(file);
    }

    /**
     * 下载PDF文件
     *
     * @param request
     * @param response
     */
    @GetMapping("testExportHtml2PDFPath")
    public void testExportHtml2PDFPath(HttpServletRequest request, HttpServletResponse response) {
        String title = "标题-测试生成PDF";
        String text = "正文-这里是正文";
        //此处填写你的html文件
        //在下面，body中设置了style，设置了默认字体为宋体，这样导出时的html语言就默认带有了字体，汉字才会导出成功
        String html = "<html><body style=\"font-family: 宋体, SimHei;\">" +
                "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 24px;\">"
                + "${title}$" + "</span></p>" + "${text}$" + "</body></html>";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", title);
        paramMap.put("text", text);
        try {
            String pdfFileOut = HtmlToPDFUtil.htmlStr2PDF(paramMap, html, rootPath);
         /*
            如果有换行，对于文本文件没有什么问题，但是对于其它格式，
            比如AutoCAD、Word、Excel等文件下载下来的文件中就会多出一些换行符//0x0d和0x0a，
            这样可能导致某些格式的文件无法打开，有些也可以正常打开。
            同时response.reset()这种方式也能清空缓冲区, 防止页面中的空行等输出到下载内容里去
         */
            response.reset();
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
//                    response.setContentType("application/pdf;charset=utf-8");
//                    response.setContentType("application/octet-stream");
            // 设置输入输出流
            ServletOutputStream out = null;
            FileInputStream ips = null;
            //获取文件存放的路径
            File file = new File(pdfFileOut);
            ips = new FileInputStream(file);
            String pathSeparator = "\\"; // 文件路径分隔符：Windows 系统的路径分隔符是 \ ，Linux的是 /
            String fileName = pdfFileOut.substring(pdfFileOut.lastIndexOf(pathSeparator) + 1);
            //为文件重新设置名字，采用生成文件的文件名称
            // URLEncoder.encode(fileName, "UTF-8")
            // new String(fileName.getBytes("gbk"), "iso8859-1")
            //解决中文文件名乱码问题
            String userAgent = request.getHeader("User-Agent").toLowerCase();
            if (userAgent.indexOf("msie") > 0 || userAgent.contains("trident") || userAgent.contains("like gecko")) {
                fileName = URLEncoder.encode(fileName, "UTF-8");//IE浏览器及IE内核的浏览器
            } else {
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);//非IE及IE内核的浏览器
            }
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", fileName));
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Connection", "close");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            ips.close();
            out.flush();
            out.close();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    /**
     * 将PDF中的文字替换为指定的内容
     */
    public ApiResponse test1(@RequestBody Map<String, String> map) {// 要替换内容所在的页数

        //        String filePath = "";
//        Path rootLocation = Paths.get(rootPath);
//        filePath = rootLocation.toString() + File.separator;//线上用

//        float x = 100.0f;// 距离左边的距离（像素点）
//        float y = 250.0f;// 距离底边的距离（像素点）
//        float w = 36.0f;// 底色填充区的宽度（像素点）
//        float h = 12.0f;// 底色填充区的高度（像素点）

        String pdfFile = filePath + "ticket_out.pdf";
        // 处理第一页的参数
        int pageNumber = 1;
        java.util.List<String> paraList1 = new ArrayList<>();
        paraList1.add(map.get("P1_partyA"));
        paraList1.add(map.get("P1_address"));
        paraList1.add(map.get("P1_responsible"));
        paraList1.add(map.get("P1_400Number"));
        paraList1.add(map.get("P1_service"));

        //            textReplacer.replaceText(text2, "网易");
//            textReplacer.replaceText(x, y, w, h, "网易");
//            textReplacer.replaceText(129.34f, 667f, 55f, h, "测试数据2");
//            textReplacer.replaceText(129.34f, 657.72f, 55f, h, "测试数据3");
//            textReplacer.replaceText(90.1f, 705.05f, 50f, h, "测试数据");

        test2(paraList1, pageNumber, pdfFile, filePath);

//            textReplacer.toPdf(filePath + "ticket_out.pdf", pageNumber);
        return ApiResponse.ofSuccess("编辑内容成功！");
    }

    /**
     * 在指定页面添加内容
     *
     * @param paraList   要添加的内容
     * @param pageNumber 页码
     */
    public static void test2(java.util.List<String> paraList, int pageNumber, String pdfFile, String filePath) {// 要替换内容所在的页数
        PdfReplacer textReplacer = null;
        PDFpoints pdFpoints = new PDFpoints();
        java.util.List<float[]> pageList = new ArrayList<>();
        if (pageNumber == 1) {//第一页
            pageList = pdFpoints.getPAGE1();
        }
        try {
            textReplacer = new PdfReplacer(pdfFile, pageNumber);
            textReplacer.replaceText("###", "小白");
            for (int i = 0; i < paraList.size(); i++) {
                textReplacer.replaceText(pageList.get(i)[0], pageList.get(i)[1],
                        pageList.get(i)[2], pageList.get(i)[3], paraList.get(i));
            }
            textReplacer.toPdf(filePath + "ticket_out.pdf", pageNumber);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {// 要替换内容所在的页数

        String filePath = "D:\\_____Work\\";// 本地测试用
        String pdfFile = "D:\\_____Work\\___PDF_template\\pdfTemplate_ZX_New.pdf";
        // 处理第一页的参数
        int pageNumber = 1;
        java.util.List<String> paraList1 = new ArrayList<>();
        paraList1.add("编辑内容成功");
        paraList1.add("编辑内容成功");
        paraList1.add("编辑内容成功");
        paraList1.add("编辑内容成功");
        paraList1.add("编辑内容成功");

        test2(paraList1, pageNumber, pdfFile, filePath);
        System.out.println("编辑内容成功！");
    }

}
