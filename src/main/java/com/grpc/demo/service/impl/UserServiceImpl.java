package com.grpc.demo.service.impl;

import com.grpc.demo.dao.UserRepository;
import com.grpc.demo.domain.User;
import com.grpc.demo.service.UserService;
import com.grpc.demo.utils.Constants;
import com.grpc.demo.utils.ReturnMessage;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Description: user service impl demo
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Map findAllBySex(String sex) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from t_user t where t.sex = '").append(sex).append("'");
        Query query = entityManager.createNativeQuery(sb.toString());
//         将结果转化为 Map<tableKey, keyValue>
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List dataList = query.getResultList();
        Map retMap = ReturnMessage.jsonData(true, dataList, null, Constants.SUCCESS_MSG);
        return retMap;
    }

    @Override
    @Transactional(readOnly = true)
    public Map findAllUser() {
        List dataList = userRepository.findAll();
        Map retMap = ReturnMessage.jsonData(true, dataList, null, Constants.SUCCESS_MSG);
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
        return retMap;
    }

    @Override
    @Transactional(readOnly = true)
    public Map findUserPager(int page, int size) {
        Pageable pageable = new PageRequest(page - 1, size);
        Page<User> users = userRepository.findAll(pageable);
        Map retMap = ReturnMessage.jsonData(true, users, null, Constants.SUCCESS_MSG);
        return retMap;
    }

    @Override
    public Map operationUser(User newUser) {
        Map result;
        try {
            User user = null;
            String code = newUser.getCode();
            if (!StringUtils.isEmpty(code)) {
                user = userRepository.findByCode(code);

                if (null != user) {
                    user.setName(newUser.getName());
                    user.setSex(newUser.getSex());
                } else {
                    user = newUser;
                }
            }
            userRepository.save(user);
            result = ReturnMessage.jsonData(true);
        } catch (Exception e) {
            result = ReturnMessage.jsonData(false, e.getMessage());
        }
        return result;
    }

}
