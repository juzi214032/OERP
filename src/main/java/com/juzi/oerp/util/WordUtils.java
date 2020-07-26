package com.juzi.oerp.util;

import fr.opensagres.poi.xwpf.converter.xhtml.Base64EmbedImgManager;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Juzi
 * @date 2020/7/25 20:17
 */
public class WordUtils {
    /**
     * 将 word（docx） 转换为 html
     *
     * @param inputStream 文件数据流
     * @return html 文本
     * @throws IOException IO异常
     */
    public static String docxToHTML(InputStream inputStream) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream);
        XHTMLOptions options = XHTMLOptions.create().indent(4).setImageManager(new Base64EmbedImgManager());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XHTMLConverter.getInstance().convert(document, byteArrayOutputStream, options);
        return byteArrayOutputStream.toString();
    }
}
