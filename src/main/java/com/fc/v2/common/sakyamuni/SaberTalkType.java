package com.fc.v2.common.sakyamuni;

/**
 * 赛博佛祖对话类型
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/23 16:13
 */
public enum SaberTalkType {

    COMMON("普通"),
    SIGN("抽签"),
    ;

    /**
     * 文本
     */
    private String content;

    SaberTalkType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

