package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.auto.TsysOperLog;
import com.fc.v2.model.auto.TsysOperLogExample;
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
public interface SysOperLogService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TsysOperLog> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    TsysOperLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsysOperLog record);

    int insertSelective(TsysOperLog record);

    int updateByExampleSelective(TsysOperLog record, TsysOperLogExample example);

    int updateByExample(TsysOperLog record, TsysOperLogExample example);

    List<TsysOperLog> selectByExample(TsysOperLogExample example);

    long countByExample(TsysOperLogExample example);

    int deleteByExample(TsysOperLogExample example);

    /**
     * 获取最新10条日志
     *
     * @return List<TsysOperLog>
     */
    List<TsysOperLog> getNEW();
}
