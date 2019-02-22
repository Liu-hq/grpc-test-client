package com.grpc.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.grpc.demo.domain.User;
import com.grpc.demo.service.UserService;
import com.grpc.demo.utils.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/testSendMsg/api")
    public Map testSendMsg() {
        Map retMap = ReturnMessage.jsonData(true);
        String tempJson = new JSONObject(retMap).toString();
        kafkaTemplate.send("design", tempJson.getBytes());
        return retMap;
    }

    @RequestMapping(value = "/findAllBySex/api")
    public Map findAllBySex(@RequestParam String sex) {
        return userService.findAllBySex(sex);
    }


    @RequestMapping(value = "/findAll/api")
    public Map findAll() {
        return userService.findAllUser();
    }

    @RequestMapping(value = "/findUserPage/api")
    public Map findUserPage(@RequestBody Map<String, String> dataMap) {

        String page = dataMap.get("page");
        String size = dataMap.get("size");
        return userService.findUserPager(Integer.valueOf(page), Integer.valueOf(size));
    }

    @RequestMapping(value = "/operationUser/api")
    public Map operationUser(@RequestBody User user) {
        return userService.operationUser(user);
    }

}
