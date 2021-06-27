package com.lizba.util.poi;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/24 21:49
 */
public class PictureTest {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\poi-tl\\pictureTest.docx";
        String targetPath =  "D:\\poi-tl\\pictureTest2.docx";
        String picPath =  "D:\\poi-tl\\pic.jpg";
        XWPFTemplate template = XWPFTemplate.compile(filePath).render(
                new HashMap<String, Object>() {
                    {
                        // 方法一、图片路径（原大小）
                        put("picture", picPath);
                        // 方法二、指定图片大小
                        put("picture", Pictures.ofLocal(picPath).size(420,350).center().create());
                        // 方法三、图片流
                        put("picture", Pictures.ofStream(new FileInputStream(picPath), PictureType.JPEG)
                                .size(420,350).create());
                        // 针对网络图片、SVG图片、Java图片都有处理
                    }
                });
        template.writeAndClose(new FileOutputStream(targetPath));
    }

}
