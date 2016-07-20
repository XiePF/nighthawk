package protocol.HttpXML;

import com.sky.nighthawk.model.protocol.HttpXML.OrderFactory;
import com.sky.nighthawk.model.protocol.HttpXML.codec.HttpXmlRequest;
import com.sky.nighthawk.model.protocol.HttpXML.codec.HttpXmlResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by xpf on 2016/07/15.
 */
public class HttpXmlClientHandle extends
        SimpleChannelInboundHandler<HttpXmlResponse> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        HttpXmlRequest request = new HttpXmlRequest(null,
                OrderFactory.create(123));
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx,
                                   HttpXmlResponse msg) throws Exception {
        System.out.println("The client receive response of http header is : "
                + msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is : "
                + msg.getResult());
    }
}
