package com.grpc.demo.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Description: user entity demo
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/21 11:15.
 *
 * @see
 */
@Entity
@Table(name = "t_user")
public class User extends DocBaseEntity implements Serializable{
    private String sex;



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



}
