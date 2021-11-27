package com.github.binlog;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

import java.io.IOException;

/**
 * @author lifengming
 * @date 2021.11.26
 */
public class BinlogServiceTest {
    public static void main(String[] args) throws IOException {

//        //构造BinaryLogClient，填充mysql链接信息
        BinaryLogClient client = new BinaryLogClient("", 3306,
                "", ""
        );

        //设置需要读取的Binlog的文件以及位置，否则，client会从"头"开始读取Binlog并监听
//        client.setBinlogFilename("binlog.000035");
//        client.setBinlogPosition();

        //给客户端注册监听器，实现对Binlog的监听和解析
        //event 就是监听到的Binlog变化信息，event包含header & data 两部分
        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("--------Update-----------");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("--------Insert-----------");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("--------Delete-----------");
                System.out.println(data.toString());
            }
        });

        client.connect();
    }
}
