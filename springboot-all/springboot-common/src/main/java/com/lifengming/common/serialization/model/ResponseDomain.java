package com.lifengming.common.serialization.model;

import lombok.*;

import java.io.File;
import java.io.Serializable;

/**
 * @author : binbin.xu
 * @date : Created in 2019/10/29 16:54
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class ResponseDomain implements Serializable {

    private static final long serialVersionUID = -5364319026946683170L;

    private String nodeIp;

    private Integer nodePort;

    private String msgType;

    private String memo;

    private String status;

    private File file;

    private HeartbeatMessage heartbeatMessage;

}