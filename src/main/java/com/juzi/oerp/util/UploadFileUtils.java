package com.juzi.oerp.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 上传文件工具类
 *
 * @author Juzi
 * @date 2020/7/25 18:59
 */
@Slf4j
public class UploadFileUtils {

    /**
     * 上传文件工具类
     *
     * @param inputStream 文件数据流
     * @param ext         扩展名（不带 .）
     * @return 文件存储路径
     */
    public static String upload(InputStream inputStream, String ext) {
        byte[] fileBytes = IoUtil.readBytes(inputStream);

        String workDirectory = FileUtil.normalize(System.getProperty("user.dir"));
        String dateDirectory = LocalDate.now().format(DateTimeFormatter.ofPattern("/'assets'/yyyy/MM/dd/"));
        String fileName = SecureUtil.md5(new ByteArrayInputStream(fileBytes)) + "." + ext;

        String fullDirectory = workDirectory + dateDirectory + fileName;
        FileUtil.writeFromStream(new ByteArrayInputStream(fileBytes), fullDirectory);
        return dateDirectory + fileName;
    }

    public static String getAbsoluteWorkDirectory() {
        return FileUtil.normalize(System.getProperty("user.dir")) + "/assets/";
    }

}
