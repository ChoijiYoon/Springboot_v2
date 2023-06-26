package com.fc.v2.model.xuper;

import java.io.Serializable;
import java.util.Date;

/**
 * 区块链账户库
 */
public class XuperAccount implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 区块链地址
     */
    private String xuperAddress;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 助记词
     */
    private String mnemonic;

    /**
     * json格式私钥
     */
    private String jsonPrivateKey;

    /**
     * json格式公钥
     */
    private String jsonPublicKey;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long editTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getXuperAddress() {
        return xuperAddress;
    }

    public void setXuperAddress(String xuperAddress) {
        this.xuperAddress = xuperAddress;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getJsonPrivateKey() {
        return jsonPrivateKey;
    }

    public void setJsonPrivateKey(String jsonPrivateKey) {
        this.jsonPrivateKey = jsonPrivateKey;
    }

    public String getJsonPublicKey() {
        return jsonPublicKey;
    }

    public void setJsonPublicKey(String jsonPublicKey) {
        this.jsonPublicKey = jsonPublicKey;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getEditTime() {
        return editTime;
    }

    public void setEditTime(Long editTime) {
        this.editTime = editTime;
    }
}