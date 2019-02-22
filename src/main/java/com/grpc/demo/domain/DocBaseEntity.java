package com.grpc.demo.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@MappedSuperclass
public class DocBaseEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    String code;

    String name;

    String companyCode;//公司关联code,内部流转

    @PrePersist
    public void beforeInsert() {
        Date date = new Date();
        setCreateDate(date);
        setUpdateDate(date);
    }

    @PreUpdate
    public void beforeUpdate() {
        setUpdateDate(new Date());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
