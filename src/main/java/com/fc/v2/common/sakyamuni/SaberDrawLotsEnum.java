package com.fc.v2.common.sakyamuni;

/**
 * 赛博佛祖抽签类型
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/23 16:13
 */
public enum SaberDrawLotsEnum {

    /**
     * 姻缘签
     */
    MARRIAGE_SIGN("姻缘签"),
    /**
     * 家宅签
     */
    HOUSING_SIGN("家宅签"),
    /**
     * 事业签
     */
    CAUSE_SIGN("事业签"),
    /**
     * 功名签
     */
    HIGH_OFFICIAL_POSITIONS_SIGN("功名签"),
    /**
     * 健康签
     */
    HEALTH_SIGN("健康签"),
    ;

    /**
     * 文本
     */
    private String content;

    SaberDrawLotsEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

