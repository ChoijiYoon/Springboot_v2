package com.fc.v2.service.user;

import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.model.xuper.XuperAccount;

import java.util.List;

/**
 * 用户对话历史记录对外接口
 *
 * @author cgy
 * @date 2023年5月19日13:57:02
 */
public interface XuperAccountService {

    /**
     * 根据用户id 查询对应信息
     * @Author cgy
     * @Date 14:02 2023/5/19
     * @Param
     * @return
     * @return java.util.List<com.fc.v2.model.message.UserMessageHistory>
     **/
    XuperAccount getByUserId(Long userId);

    /**
     * 保存账户
     * @Author cgy
     * @Date 14:03 2023/5/19
     * @Param
     * @return Long
     **/
    Long save(XuperAccount xuperAccount);


}
