package com.lifengming.common.util;

import com.lifengming.common.utils.ExcelUtil;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lifengming
 * @date 2020.06.17
 */
public class ExcelUtilTest {

    @Test
    public void excelTest() {
        ExcelUtil excelUtil = new ExcelUtil();
        String filePath = "/Users/mockuai/lifengming/mockuai/ec-messagecenter/message-test/src/test/resources/test.xlsx";
        //是否跳过标题解析
        excelUtil.excel(filePath, 1, true,"/Users/mockuai/lifengming/mockuai/");
    }

    @Test
    public void test(){

       int QUEUE_NUM = 10;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i=0;i<100000;i++){
        System.out.println(atomicInteger.getAndIncrement() % QUEUE_NUM);}
    }
}
