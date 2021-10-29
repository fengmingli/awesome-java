package com.lifengming.common.serialization.coder;


import com.lifengming.common.serialization.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.AllArgsConstructor;

/**
 * @author lifengming
 * @since 2019.09.29
 */
@AllArgsConstructor
public class ProtobufEncoder extends MessageToByteEncoder {

    private final Class<?> genericClass;
    private final Serializer serializer;

    @Override
    public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
        if (genericClass.isInstance(in)) {
            byte[] data = serializer.serialize(in);
            //将消息长度写入，也就是消息头，这里使用Int：4字节
            out.writeInt(data.length);
            //消息体中包含我们要发送的数据
            out.writeBytes(data);
        }
    }
}
