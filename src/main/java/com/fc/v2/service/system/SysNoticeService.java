package com.fc.v2.service.system;

import com.fc.v2.model.auto.*;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 部门：
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/18 18:05
 */
public interface SysNoticeService {


    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysNotice> list(Tablepar tablepar, String name);

    /**
     * 对应用户的所有公告信息
     * @Author cgy
     * @Date 10:01 2023/5/19
     * @Param
     * @param tsysUser
     * @param tablepar
     * @param name
     * @return
     * @return com.github.pagehelper.PageInfo<com.fc.v2.model.auto.SysNotice>
     **/
    PageInfo<SysNotice> list(TsysUser tsysUser, Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysNotice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysNotice record);

    int insertSelective(SysNotice record);

    int updateByExampleSelective(SysNotice record, SysNoticeExample example);

    int updateByExample(SysNotice record, SysNoticeExample example);

    List<SysNotice> selectByExample(SysNoticeExample example);

    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysNotice sysDepartment);

    /**
     * 根据公告id把当前用户的公告置为以查看
     *
     * @param noticeid
     * @author fuce
     * @Date 2019年9月8日 下午7:14:19
     */
    void editUserState(String noticeid);

    /**
     * 获取最新8条公告
     *
     * @return
     */
    List<SysNotice> getNEW();

    /**
     * 获取用户未阅读公告
     *
     * @param tsysUser
     * @param state    阅读状态  0未阅读 1 阅读  -1全部
     * @return
     * @author fuce
     * @Date 2019年9月8日 上午3:36:21
     */
    List<SysNotice> getuserNoticeNotRead(TsysUser tsysUser, int state);

}
