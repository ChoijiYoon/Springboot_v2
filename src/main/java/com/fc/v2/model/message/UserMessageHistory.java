package com.fc.v2.model.message;

import java.io.Serializable;

/**
 * 用户信息记录表
 * @author cgy
 */
public class UserMessageHistory implements Serializable {


    /**
     * id
     */
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 类型
     */
    private Integer type;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}