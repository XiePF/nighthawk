package com.sky.nighthawk.model.protobuf.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import org.jboss.marshalling.Marshaller;

import java.io.IOException;

/**
 * Created by xpf on 2016/07/08.
 */
public class MarshallingEncoder extends io.netty.handler.codec.marshalling.MarshallingEncoder {

    public MarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        super.encode(ctx, msg, out);
    }

}
