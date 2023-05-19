package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysQuartzJobLog;
import com.fc.v2.model.auto.SysQuartzJobLogExample;
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
public interface SysQuartzJobLogService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysQuartzJobLog> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysQuartzJobLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysQuartzJobLog record);

    int insertSelective(SysQuartzJobLog record);

    int updateByExampleSelective(SysQuartzJobLog record, SysQuartzJobLogExample example);

    int updateByExample(SysQuartzJobLog record, SysQuartzJobLogExample example);

    List<SysQuartzJobLog> selectByExample(SysQuartzJobLogExample example);

    long countByExample(SysQuartzJobLogExample example);

    int deleteByExample(SysQuartzJobLogExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysQuartzJobLog sysDepartment);

}
