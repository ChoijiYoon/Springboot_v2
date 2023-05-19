package com.fc.v2.service.message;

import com.fc.v2.model.message.UserMessageHistory;

import java.util.List;

/**
 * 用户对话历史记录对外接口
 *
 * @author cgy
 * @date 2023年5月19日13:57:02
 */
public interface UserMessageHistoryService {

    /**
     * 根据用户id 查询对应消息列表
     * @Author cgy
     * @Date 14:02 2023/5/19
     * @Param
     * @return
     * @return java.util.List<com.fc.v2.model.message.UserMessageHistory>
     **/
    List<UserMessageHistory> getByUserId(Long userId);

    /**
     * 保存消息
     * @Author cgy
     * @Date 14:03 2023/5/19
     * @Param
     * @param userMessageHistory
     * @return
     * @return Long
     **/
    Long save(UserMessageHistory userMessageHistory);


}
