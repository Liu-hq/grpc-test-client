package com.grpc.demo.service;

import com.grpc.demo.domain.User;

import java.util.Map;
/**
 * Description: user service demo
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
public interface UserService {

    Map findAllBySex(String sex);

    Map findAllUser();

    Map findUserPager(int page, int size);

    Map operationUser(User user);

}
