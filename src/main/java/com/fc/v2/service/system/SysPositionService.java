package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysPosition;
import com.fc.v2.model.auto.SysPositionExample;
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
public interface SysPositionService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysPosition> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysPosition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPosition record);

    int insertSelective(SysPosition record);

    int updateByExampleSelective(SysPosition record, SysPositionExample example);

    int updateByExample(SysPosition record, SysPositionExample example);

    List<SysPosition> selectByExample(SysPositionExample example);

    long countByExample(SysPositionExample example);

    int deleteByExample(SysPositionExample example);

    /**
     * 检查name
     * @param sysPosition
     * @return
     */
    int checkNameUnique(SysPosition sysPosition);

    /**
     * 修改权限状态展示或者不展示
     * @param record
     * @return
     */
    int updateVisible(SysPosition record);
}
