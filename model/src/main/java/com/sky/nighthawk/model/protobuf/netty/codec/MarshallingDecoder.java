package com.sky.nighthawk.model.protobuf.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;


/**
 * Created by xpf on 2016/07/08.
 */
public class MarshallingDecoder extends io.netty.handler.codec.marshalling.MarshallingDecoder{


    public MarshallingDecoder(UnmarshallerProvider provider, int maxObjectSize) {
        super(provider, maxObjectSize);
    }

    @Override
    public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        return super.decode(ctx, in);
    }
}
