package com.grpc.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.grpc.demo.domain.User;
import com.grpc.demo.service.DemosService;
import com.grpc.demo.service.UserService;
import com.grpc.demo.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description: user restController demo
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private DemosService demoSrevice;

    @RequestMapping(value = "/testSendMsg/api")
    public Map testSendMsg() {
        Map retMap = ReturnMessage.jsonData(true);
        String tempJson = new JSONObject(retMap).toString();
        kafkaTemplate.send("design", tempJson.getBytes());
        return retMap;
    }

    @RequestMapping(value = "/sendMessage/api")
    public Map sendMessage(@RequestBody Map<String, String> dataMap) {
        return demoService.sendMessage(dataMap.get("age"));
    }


}
