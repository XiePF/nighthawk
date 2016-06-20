package Decode.Protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sky.nighthawk.model.protobuf.SubscribeReqProto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpf on 2016/06/20.
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode
            (byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder =
                SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("xiaoming");
        builder.setProductName("netty book");
        List<String> address = new ArrayList<String>();
        address.add("xian");
        address.add("beijing");
        address.add("shenzhen");
        builder.setAddress("shenzhen");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req =
                createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : " + req.toString());
        System.out.println("Assert equal : --> " + req2.equals(req));

    }
}
