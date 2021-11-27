package com.lifengming.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lifengming
 * @date 2021.01.03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerInfo {
    private String url;
}
