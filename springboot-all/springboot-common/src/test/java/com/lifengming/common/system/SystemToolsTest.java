package com.lifengming.common.system;


import org.junit.Test;


/**
 * @author lifengming
 * @since 2019.12.31
 */

public class SystemToolsTest {


    @Test
    public void getOsName() {
        System.out.println(SystemTools.getOsName());
    }

    @Test
    public void getIpAddress() {
        System.out.println(SystemTools.getIpAddress());
    }
}
