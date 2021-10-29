package com.lifengming.common.serialization.coder;

import com.lifengming.common.serialization.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author lifengming
 * @since 2019.09.29
 */
@AllArgsConstructor
public class ProtobufDecoder extends ByteToMessageDecoder {
    private static final int INT_BYTE_LENGTH = 4;

    private final Class<?> genericClass;
    private final Serializer serializer;

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //判断包头的长度int字节长度为4
        if (in.readableBytes() < INT_BYTE_LENGTH) {
            return;
        }
        in.markReaderIndex();
        //读取传送过来的消息的长度，4个字节
        int dataLength = in.readInt();
        if (dataLength < 0) {
            //非法数据，关闭连接
            ctx.close();
        }

        if (dataLength > in.readableBytes()) {
            //读到的消息体长度如果小于传过来的消息长度
            //重置读取位置
            in.resetReaderIndex();
            return;
        }
        byte[] array;
        if (in.hasArray()) {
            //堆缓冲
            ByteBuf slice = in.slice();
            array = slice.array();
        } else {
            //直接缓冲
            array = new byte[dataLength];
            in.readBytes(array, 0, dataLength);
        }
        //字节转换成Protobuf的POJO对象
        Object outMsg = serializer.deserialize(array, genericClass);
        if (outMsg != null) {
            //获取业务信息
            out.add(outMsg);
        }

    }
}
