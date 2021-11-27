package com.lifengming.springboot.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConfigExample {

	public static void main(String[] args) throws NacosException, InterruptedException {
		String serverAddr = "";
		String dataId = "";
		String group = "";
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.USERNAME,"");
		properties.put(PropertyKeyConst.PASSWORD,"");
        properties.put(PropertyKeyConst.NAMESPACE,"");
		ConfigService configService = NacosFactory.createConfigService(properties);
		String content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);

		System.out.println(getConfigByOrder(content));
		configService.addListener(dataId, group, new Listener() {
			@Override
			public void receiveConfigInfo(String configInfo) {
				System.out.println("recieve:" + configInfo);
			}

			@Override
			public Executor getExecutor() {
				return null;
			}
		});
	}

	private static String getConfigByOrder(String json) {
		LinkedHashMap<?, ?> nativeRead = JacksonUtil.nativeRead(json, new TypeReference<LinkedHashMap<?, ?>>() {
		});
		if (nativeRead == null) {
			return null;
		}
		if (nativeRead.entrySet().size() == 2) {
			for (Map.Entry<?, ?> entry : nativeRead.entrySet()) {
				if ("global" != entry.getKey()) {
					return JacksonUtil.serialize(entry.getValue());
				}
			}
		}
		return JacksonUtil.serialize(nativeRead.get("global"));
	}
}
