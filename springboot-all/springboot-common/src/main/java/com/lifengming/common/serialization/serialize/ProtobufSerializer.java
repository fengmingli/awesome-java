package com.lifengming.common.serialization.serialize;


import com.lifengming.common.serialization.Serializer;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.concurrent.ConcurrentHashMap;


/**
 * <p>基于protobuf协议实现序列化<p/>
 *
 * @author lifengming
 * @since 2019.09.17
 */
public class ProtobufSerializer implements Serializer {
    private static final ConcurrentHashMap<Class<?>, Schema<?>> CACHED_SCHEMA = new ConcurrentHashMap<>();

    private static final Objenesis OBJENESIS = new ObjenesisStd(true);

    @Override
    @SuppressWarnings("unchecked")
    public <T> byte[] serialize(T obj) {
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> cls) {
        try {
            T message = OBJENESIS.newInstance(cls);
            Schema<T> schema = getSchema(cls);
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = null;
        if (CACHED_SCHEMA.size() > 0) {
            schema = (Schema<T>) CACHED_SCHEMA.get(cls);
        }
        if (schema == null && cls != null) {
            schema = RuntimeSchema.createFrom(cls);
            CACHED_SCHEMA.put(cls, schema);
        }

        return schema;
    }
}
