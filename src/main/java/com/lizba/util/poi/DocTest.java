package com.lizba.util.poi;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Texts;

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
public class DocTest {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\poi-tl\\textTest.docx";
        String targetPath =  "D:\\poi-tl\\textTestTarget.docx";
        XWPFTemplate template = XWPFTemplate.compile(filePath).render(
                new HashMap<String, Object>() {
                    {
                        put("name", "测试");
                        put("author", Texts.of("Liziba").color("000000").create());
                        put("link", Texts.of("百度").link("https://baidu.com").create());
                        put("anchor", Texts.of("anchortxt").anchor("appendix1").create());
                    }
                });
        template.writeAndClose(new FileOutputStream(targetPath));
    }

}
