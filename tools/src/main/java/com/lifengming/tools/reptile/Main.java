package com.lifengming.tools.reptile;

/**
 * @author lifengming
 * @date 2021.09.11
 */
public class Main {
    public static void main(String[] args) {
        String url = "https://pic.sogou.com/napi/pc/searchList?mode=1&start=%s&xml_len=%s&query=%s";
        SogouImgProcessor processor = new SogouImgProcessor(url, "壁纸");

        // 定义爬取开始索引、每次爬取数量、总共爬取数量
        int start = 0, size = 50, limit = 1000;

        for (int i = start; i < start + limit; i += size) {
            processor.process(i, size);
        }

        processor.pipelineData();
    }
}
