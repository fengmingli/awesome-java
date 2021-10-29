package com.lifengming.springboot.nacos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * jackson 工具类
 * @author lifengming
 * @date 2020.12.29
 */
public class JacksonUtil {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    /**
     * POJO——>JSON
     *
     * @param obj object
     * @return json
     */
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("Json serialization error：" + obj, e);
            return null;
        }
    }

    /**
     * JSON->POJO
     *
     * @param json json
     * @param tClass Target Class
     * @param <T> Target Type
     * @return POJO
     */
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return MAPPER.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json serialization error：" + json, e);
            return null;
        }
    }

    /**
     * JSON—>List
     *
     * @param json json
     * @param eClass target class
     * @param <E> target type
     * @return List
     */
    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json serialization error：" + json, e);
            return null;
        }
    }


    /**
     * Json、Json数组转Map
     *
     * @param json Original
     * @param kClass map-keyClass
     * @param vClass map-valueClass
     * @param <K> map-key
     * @param <V> map-value
     * @return map
     */
    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json serialization error：" + json, e);
            return null;
        }
    }


    /**
     * Universal conversion
     * @param json json
     * @param type reference type
     * @param <T> target type
     * @return /
     */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (IOException e) {
            logger.error("json serialization error：" + json, e);
            return null;
        }
    }
}
