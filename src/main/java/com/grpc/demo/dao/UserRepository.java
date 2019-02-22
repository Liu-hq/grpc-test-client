package com.grpc.demo.dao;

import com.grpc.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Description: user dao demo
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCode(String code);
}
