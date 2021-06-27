package com.lizba.util.poi;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;

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
public class TableTest {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\poi-tl\\tableTest.docx";
        String targetPath =  "D:\\poi-tl\\tableTest2.docx";

        // 表头
        RowRenderData tableHead = Rows.of("姓名", "性别", "地址", "微信公众号").center().bgColor("4472c4").create();
        // 第一行
        RowRenderData row1 = Rows.create("张三", "男", "广东深圳", "liziba_98");
        // 第二行
        RowRenderData row2 = Rows.create("李四", "男", "广东深圳", "liziba_98");
        // 合并第一行和第二行的第二列与第三列
        MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(2, 1))
                .map(MergeCellRule.Grid.of(1, 2), MergeCellRule.Grid.of(2, 2)).build();

        XWPFTemplate template = XWPFTemplate.compile(filePath).render(
            new HashMap<String, Object>() {
                {
                    put("table", Tables.of(tableHead, row1, row2).mergeRule(rule).center().create());
                }
            });
        template.writeAndClose(new FileOutputStream(targetPath));
    }

}
