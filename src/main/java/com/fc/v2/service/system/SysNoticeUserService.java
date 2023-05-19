package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysNoticeUser;
import com.fc.v2.model.auto.SysNoticeUserExample;
import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
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
public interface SysNoticeUserService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysNoticeUser> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysNoticeUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysNoticeUser record);

    int insertSelective(SysNoticeUser record);

    int updateByExampleSelective(SysNoticeUser record, SysNoticeUserExample example);

    int updateByExample(SysNoticeUser record, SysNoticeUserExample example);

    List<SysNoticeUser> selectByExample(SysNoticeUserExample example);

    long countByExample(SysNoticeUserExample example);

    int deleteByExample(SysNoticeUserExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysNoticeUser sysDepartment);

}
