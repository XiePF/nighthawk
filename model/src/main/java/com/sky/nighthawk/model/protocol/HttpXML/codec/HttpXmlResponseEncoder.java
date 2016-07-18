package com.sky.nighthawk.model.protocol.HttpXML.codec;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderUtil.setContentLength;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

import java.util.List;

/**
 * Created by xpf on 2016/07/18.
 */
public class HttpXmlResponseEncoder extends
        AbstractHttpXmlEncoder<HttpXmlResponse> {

    /*
     * (non-Javadoc)
     *
     * @see
     * io.netty.handler.codec.MessageToMessageEncoder#encode(io.netty.channel
     * .ChannelHandlerContext, java.lang.Object, java.util.List)
     */
    protected void encode(ChannelHandlerContext ctx, HttpXmlResponse msg,
                          List<Object> out) throws Exception {
        ByteBuf body = encodeo(ctx, msg.getResult());
        FullHttpResponse response = msg.getHttpResponse();
        if (response == null) {
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, body);
        } else {
            response = new DefaultFullHttpResponse(msg.getHttpResponse().protocolVersion(),
                     msg.getHttpResponse().status(),
                    body);
        }
        response.headers().set(CONTENT_TYPE, "text/xml");
        setContentLength(response, body.readableBytes());
        out.add(response);
    }
}

