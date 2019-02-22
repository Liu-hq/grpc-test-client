package com.grpc.demo.service.impl;


import com.grpc.demo.service.DemosService;
import com.grpc.demo.utils.ReturnMessage;

import com.liu.demo.demo.DemoRequest;
import com.liu.demo.demo.DemoResponse;
import com.liu.demo.demo.DemoServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class DemoImpl implements DemosService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GrpcClient("demo-test-server")
    private DemoServiceGrpc.DemoServiceBlockingStub serviceStub;

    @Override
    public Map sendMessage(String age){
        Map result;
        try {
            final DemoResponse response = this.serviceStub.sayHello(DemoRequest.newBuilder().setAge(Integer.valueOf(age)).build());
            result = ReturnMessage.jsonData(true,response.getMessage(),"200","成功");
            logger.info("收到返回消息，{}",response.getMessage());

        } catch (final StatusRuntimeException e) {
            result = ReturnMessage.jsonData(false,"","300","失败");
            logger.error("异常 ",e);
        }
        return result;
    }
}
