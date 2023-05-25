package com.fc.v2.common.sakyamuni;

/**
 * 赛博佛祖自定义对话
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/23 16:13
 */
public enum SaberCustomDialogEnum {

    /**
     * 抽签
     */
    DRAW_LOTS("以下是我的问题：阿弥陀佛, 我想求一支"),
    ;

    /**
     * 文本
     */
    private String content;

    SaberCustomDialogEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

