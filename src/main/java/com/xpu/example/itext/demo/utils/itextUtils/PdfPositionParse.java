/**********************************************************************
 * <pre>
 * FILE : PdfPositionParse.java
 * CLASS : PdfPositionParse
 *
 * AUTHOR : caoxu-yiyang@qq.com
 *
 * FUNCTION : TODO
 *
 *
 *======================================================================
 * CHANGE HISTORY LOG
 *----------------------------------------------------------------------
 * MOD. NO.|   DATE   |   NAME  | REASON  | CHANGE REQ.
 *----------------------------------------------------------------------
 * 		    |2016年11月9日|caoxu-yiyang@qq.com| Created |
 * DESCRIPTION:
 * </pre>
 ***********************************************************************/

package com.xpu.example.itext.demo.utils.itextUtils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.xpu.example.itext.demo.utils.itextUtils.listener.PositionRenderListener ;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 解析PDF中文本的x,y位置
 *
 * @author L.Wen
 */
public class PdfPositionParse {

    private PdfReader reader;
    private List<String> findText = new ArrayList<String>();    //需要查找的文本
    private PdfReaderContentParser parser;

    public PdfPositionParse(String fileName) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            init(bytes);
        } finally {
            in.close();
        }
    }

    public PdfPositionParse(byte[] bytes) throws IOException {
        init(bytes);
    }

    private boolean needClose = true;

    /**
     * 传递进来的reader不会在PdfPositionParse结束时关闭
     *
     * @param reader
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     */
    public PdfPositionParse(PdfReader reader) {
        this.reader = reader;
        parser = new PdfReaderContentParser(reader);
        needClose = false;
    }

    public void addFindText(String text) {
        this.findText.add(text);
    }

    private void init(byte[] bytes) throws IOException {
        reader = new PdfReader(bytes);
        parser = new PdfReaderContentParser(reader);
    }

    /**
     * 解析文本
     *
     * @throws IOException
     * @user : caoxu-yiyang@qq.com
     * @date : 2016年11月9日
     */
    public Map<String, ReplaceRegion> parse(int pageNumber) throws IOException {
        try {
//            if (this.findText.size() == 0) {
//                throw new NullPointerException("没有需要查找的文本");
//            }
            PositionRenderListener listener = new PositionRenderListener(this.findText);
            parser.processContent(pageNumber, listener);
            return listener.getResult();
        } finally {
            if (reader != null && needClose) {
                reader.close();
            }
        }
    }
}
