package com.xpu.example.itext.demo.utils.pd4mlUtils;


import org.apache.commons.lang3.StringUtils;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

import java.awt.*;
import java.io.*;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author L.Wen
 */
public class HtmlToPDFUtil {
    private int topValue = 10;
    private int leftValue = 20;
    private int rightValue = 10;
    private int bottomValue = 10;
    private int userSpaceWidth = 1300;

    private static String filePath = "D:\\_____Work\\";// 本地测试用

    public static void main(String[] args) {
        try {
            HtmlToPDFUtil jt = new HtmlToPDFUtil();
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
            //获取查询结果
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                //替换标签值内容
                if (StringUtils.isNotEmpty(html)) {
                    html = html.replace("${" + entry.getKey() + "}$", entry.getValue().toString());
                }
            }
            //此处填写你下载的地方
            String fileName = UUID.randomUUID().toString() + ".pdf";
            String fileAbsolutePath = filePath + fileName;
            jt.doConversion(html, fileAbsolutePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将html里面的标签内容替换成指定内容，并转换成pdf，返回pdf文件的路径
     *
     * @param paramMap  指定内容
     * @param html      html字符串
     * @param localPath 本地目录
     * @return pdf文件的路径
     */
    public static String htmlStr2PDF(Map<String, Object> paramMap, String html, String localPath) {
        String fileAbsolutePath = "";
        try {
            HtmlToPDFUtil jt = new HtmlToPDFUtil();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                //替换标签值内容
                if (StringUtils.isNotEmpty(html)) {
                    html = html.replace("${" + entry.getKey() + "}$", entry.getValue().toString());
                }
            }
            // 此处填写pdf文件的路径
            String fileName = UUID.randomUUID().toString() + ".pdf";
            fileAbsolutePath = localPath + fileName;
            jt.doConversion(html, fileAbsolutePath);
            return fileAbsolutePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 将字符串形式的html转换成pdf
     *
     * @param htmlDocument 字符串形式的html
     * @param outputPath   转换成pdf的存放位置
     * @throws InvalidParameterException
     * @throws IOException
     */
    private void doConversion(String htmlDocument, String outputPath) throws InvalidParameterException, IOException {
        PD4ML pd4ml = new PD4ML();
        pd4ml.enableDebugInfo();
        pd4ml.setHtmlWidth(userSpaceWidth);
        pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));
        pd4ml.setPageInsetsMM(new Insets(topValue, leftValue, bottomValue, rightValue));
        pd4ml.addStyle("BODY {margin: 0; font-family:MSJH}", true);
        String classPath = HtmlToPDFUtil.class.getResource("/") + "fonts";
        pd4ml.useTTF(classPath, true);
        pd4ml.setDefaultTTFs("SimSun", "SimSun", "SimSun");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pd4ml.render(new StringReader(htmlDocument), byteArrayOutputStream);
        byteArrayOutputStream.close();
        File output = new File(outputPath);
        java.io.FileOutputStream fos = new java.io.FileOutputStream(output);
        fos.write(byteArrayOutputStream.toByteArray());
        fos.close();
    }

    /**
     * 将 html文件读取成字符串
     *
     * @param path     html文件位置
     * @param encoding 编码格式
     * @return 字符串
     * @throws IOException
     */
    private static String readFile(String path, String encoding) throws IOException {
        File f = new File(path);
        FileInputStream is = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int read;
        do {
            read = is.read(buffer, 0, buffer.length);
            if (read > 0) {
                fos.write(buffer, 0, read);
            }
        } while (read > -1);
        fos.close();
        bis.close();
        is.close();
        return fos.toString(encoding);
    }

}