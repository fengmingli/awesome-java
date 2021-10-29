package com.lifengming.springboot.swagger2.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author lifengming
 * @date 2020.02.28
 */
@Data
@TableName("ss_company")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * AUTO : AUTO(0, “数据库ID自增”),
     * INPUT : INPUT(1, “用户输入ID”),
     * ID_WORKER : ID_WORKER(2, “全局唯一ID”),默认值如果不设置会在用该策略
     * UUID : UUID(3, “全局唯一ID”),
     * NONE : NONE(4, “该类型为未设置主键类型”),
     * ID_WORKER_STR : ID_WORKER_STR(5, “字符串全局唯一ID”);
     */
    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private Date expirationDate;

    private String address;

    private String licenseId;

    private String representative;

    private String phone;

    private String companySize;

    private String industry;

    private String remarks;

    private Integer state;

    private Double balance;

    private String city;


}
