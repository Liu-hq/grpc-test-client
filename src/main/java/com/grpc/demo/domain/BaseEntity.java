package com.grpc.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    Date createDate;

    String createByCode;
    String createByName;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    Date updateDate;

    String updateByCode;
    String updateByName;

    @Column(nullable = false)
    @Version
    Long version;

    boolean isDelete = false;
    boolean isEffect = true;

    String remark;//备注
    String tenantId;//租户id

    /**
     * 插入前事件
     */
    @PrePersist
    public void beforeInsert() {
        Date date = new Date();
        setCreateDate(date);
        setUpdateDate(date);

    }

    /**
     * 插入后事件
     */
    @PostPersist
    public void afterInsert() {
    }

    /**
     * 更新前事件
     */
    @PreUpdate
    public void beforeUpdate() {
        setUpdateDate(new Date());
    }

    /**
     * 更新后事件
     */
    @PostUpdate
    public void afterUpdate() {
    }

    /**
     * 删除前事件
     */
    @PreRemove
    public void beforeDelete() {

    }

    /**
     * 删除后事件
     */
    @PostRemove
    public void afterDelete() {
    }

    /**
     * 查询后事件
     */
    @PostLoad
    public void afterLoad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateByCode() {
        return createByCode;
    }

    public void setCreateByCode(String createByCode) {
        this.createByCode = createByCode;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateByCode() {
        return updateByCode;
    }

    public void setUpdateByCode(String updateByCode) {
        this.updateByCode = updateByCode;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean getIsEffect() {
        return isEffect;
    }

    public void setIsEffect(boolean isEffect) {
        this.isEffect = isEffect;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
