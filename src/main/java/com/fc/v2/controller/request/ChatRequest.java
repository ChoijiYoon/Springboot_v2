package com.fc.v2.controller.request;

import com.fc.v2.common.sakyamuni.SaberDrawLotsEnum;
import lombok.Data;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @sine 2023-04-08
 */
@Data
public class ChatRequest {
    /**
     * 客户端发送的问题参数
     */
    private String msg;

    /**
     * 客户端发送的问题种类
     */
    private SaberDrawLotsEnum saberDrawLotsEnum;
}
